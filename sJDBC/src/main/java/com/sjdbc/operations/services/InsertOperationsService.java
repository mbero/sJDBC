	package com.sjdbc.operations.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.sjdbc.configuration.DBConnectionConfiguration;
import com.sjdbc.interfaces.DBConnectionManager;
import com.sjdbc.tools.Tools;

public class InsertOperationsService extends DBOperationsService
{
	final static Logger log = Logger.getLogger(InsertOperationsService.class);
	/**
	 * Funkcja wywołuje zapytanie zadane w parametrze insertQuery, wykorzystując obiekt dbConnectionConfiguration. Zwraca liczbę dodanych rekordów do
	 * tabeli
	 * @param dbConnectionConfiguration
	 * @param insertQuery
	 * @return insertedRows
	 */
	public int executeAnyInsertQueryFromParameter(DBConnectionConfiguration dbConnectionConfiguration, String insertQuery)
	{
		log.debug("Wywołuje funkcje executeAnyInsertQueryFromParameter() z InsertOperationsService");
		DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
		Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
		int insertedRows=0;
		try 
		{
			Statement stmt = conn.createStatement();
			String query = insertQuery;
			insertedRows = stmt.executeUpdate(insertQuery);
			log.debug(query);
		} 
		catch (SQLException e) 
		{
			log.debug("Wystapil blad podczas wykonywania zapytania : " + insertQuery);
			log.debug(e.getCause(),e);
		}	
		return insertedRows;
	}
}
