package com.sjdbc.operations.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mysql.jdbc.StringUtils;
import com.sjdbc.configuration.DBConnectionConfiguration;
import com.sjdbc.interfaces.DBConnectionManager;
import com.sjdbc.tools.Tools;

public class SelectOperationsService extends DBOperationsService
{
	final static Logger log = Logger.getLogger(SelectOperationsService.class);
	
	/**
	 * Funkcja zwraca listę map na podstawie dwóch parametrów - dowolnego zapytania SELECT oraz parametru opcjonalnego zawierającego listę kolummn, czyli (kluczy w każdym z elementów listy map) 
	 * @param selectQuery
	 * @param columnNames
	 * @return List<Map<String,String>> results
	 */
	public List<Map<String,String>> executeAnySelectQueryFromParameter(DBConnectionConfiguration dbConnectionConfiguration, String selectQuery,  String...columnNames)
	{
		log.debug("Wywołuje funkcje executeAnySelectQueryFromParameter() z SelectOperationsService");
		List<Map<String,String>> results = new ArrayList<Map<String,String>>();
		DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
		Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
		List<String> columns = Tools.getOptionalParametersAsObjectsArray(columnNames);
		 try 
		 {
			Statement stmt = conn.createStatement();
			String query = selectQuery;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{	
				Map<String,String> currentMap = new HashMap<String,String>();
				for(String currentColumn : columns)
				{
					String currentResultFromRs = rs.getString(currentColumn);
					currentMap.put(currentColumn, currentResultFromRs);
				}
				results.add(currentMap);
			}
		 } 
		 catch (SQLException e) 
		 {
			log.debug("Wystapil blad podczas wykonywania zapytania : " + selectQuery);
			log.debug(e.getCause(),e);
		 }
		
		return results;	
	}	
	/**
	 * Funkcja pobiera wartości z tabeli na podstawie parametrów : nazwy tabeli , warunku WHERE w postaci np( 'nazwa_kolumny'='wartosc') i kolumn które będą zwrócone jako
	 * klucze w liście map będącej rezultatem
	 * @param dbConnectionConfiguration
	 * @param tableName
	 * @param condition
	 * @param columnNames
	 * @return List<Map<String,String>> - lista map w których kluczami są nazwy kolumn z parametru columnNames
	 */
	public List<Map<String,String>> getValuesFromDB(DBConnectionConfiguration dbConnectionConfiguration, String tableName, String condition, String...columnNames)
	{
		log.debug("Wywołuje funkcje getValuesFromDB() z SelectOperationsService");
		List<Map<String,String>> results = new ArrayList<Map<String,String>>();
		DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
		Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
		List<String> columnsList = Tools.getOptionalParametersAsObjectsArray(columnNames);
		String columnsString = Tools.returnColumnsAsStringForQuery(columnsList);
	    try 
		 {
	    	String query = "";
			Statement stmt = conn.createStatement();
			if(StringUtils.isNullOrEmpty(condition))
			{
				query="SELECT " + columnsString + " FROM " + tableName;
			}	
			else
			{
				query = "SELECT " + columnsString + " FROM " + tableName + " WHERE " + condition;
			}
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{	
				Map<String,String> currentMap = new HashMap<String,String>();
				for(String currentColumn : columnsList)
				{
					String currentResultFromRs = rs.getString(currentColumn);
					currentMap.put(currentColumn, currentResultFromRs);
				}
				results.add(currentMap);
			}
		 } 
		 catch (SQLException e) 
		 {
			log.debug("Wystapil blad podczas wykonywania funkcji getValuesFromDB");
			log.debug(e.getCause(),e);
		 }
		
		return results;	
	}
}
