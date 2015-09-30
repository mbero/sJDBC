package com.mbero.sjdbc.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mbero.sjdbc.configuration.TableCreationConfiguration;
import com.mbero.sjdbc.connection.implementation.MySQLDBConnectionManager;
import com.mbero.sjdbc.connection.implementation.PostgreSQLDBConnectionManager;
import com.mbero.sjdbc.enumtype.DatabaseType;
import com.mbero.sjdbc.interfaces.DBConnectionManager;

/**
 * Zbiór różnych funkcji wykorzystywanych w bibliotece sJDBC
 * 
 * @author Marcin Berendt
 *
 */
public class Tools {

	public static List<String> getOptionalParametersAsObjectsArray(
			String... optionalParameters) {
		List<String> list = new ArrayList<String>();
		for (String currentOptionalParameter : optionalParameters) {
			list.add(currentOptionalParameter);
		}

		return list;
	}

	public static String returnColumnsAsStringForQuery(
			List<String> optionalParameters) {
		String columnsString = "";
		StringBuilder columnsStringBuilder = new StringBuilder();
		for (String currentString : optionalParameters) {
			columnsStringBuilder.append(currentString + ",");
		}
		columnsString = columnsStringBuilder.toString();
		if (columnsString.endsWith(",")) {
			columnsString = columnsString.substring(0,
					columnsString.length() - 1);
		}
		return columnsString;
	}

	public static DBConnectionManager returnProperConnectionManager(
			DatabaseType databaseType) {
		DBConnectionManager properConnectionManager = null;
		switch (databaseType) {
		case MYSQL:
			properConnectionManager = new MySQLDBConnectionManager();
			break;
		case POSTGRESQL:
			properConnectionManager = new PostgreSQLDBConnectionManager();
			break;
		}

		return properConnectionManager;
	}

	/**
	 * Create insert query from values map and table name
	 * 
	 * @return
	 */
	public static String returnInsertQueryFromMap(String tableName,
			Map<String, Object> valuesToInsert) {
		/*
		 * INSERT INTO `trainingpartner`.`roles` (`id`, `role`) VALUES (<{id:
		 * }>, <{role: }>);
		 */
		String columnNames = getKeysFromMapAsString(valuesToInsert);
		String columnValues = getValuesFromMapAsString(valuesToInsert);
		String query = "INSERT INTO " + tableName + "(" + columnNames
				+ ") VALUES" + "(" + columnValues + ")";

		return query;
	}

	private static String getKeysFromMapAsString(Map<String, Object> values) {
		Set<String> keys = values.keySet();
		StringBuilder columnsBuilder = new StringBuilder();
		for (String currentKey : keys) {
			columnsBuilder.append(currentKey).append(",");
		}
		String columns = columnsBuilder.toString();
		columns = columns.substring(0, columns.length() - 1);

		return columns;
	}

	private static String getValuesFromMapAsString(Map<String, Object> values) {

		Set<String> keys = values.keySet();
		StringBuilder valuesBuilder = new StringBuilder();
		for (String currentKey : keys) {
			String currentValue = values.get(currentKey).toString();
			valuesBuilder.append("'").append(currentValue).append("'").append(",");
		}
		String valuesToReturn = valuesBuilder.toString();
		valuesToReturn = valuesToReturn.substring(0,
				valuesToReturn.length() - 1);
		return valuesToReturn;
	}
	
	public static String constructCreateTableQuery(TableCreationConfiguration tableCreationConfigurationObject)
	{
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("CREATE TABLE ").append(tableCreationConfigurationObject.getTableName()+" (");
		Map<String,String> columnNamesWithTypes = tableCreationConfigurationObject.getColumnsWithTypes();
		Map<String,String> columnNamesWithSizes = tableCreationConfigurationObject.getColumnsWithSizes();
		Set<String> columnNames = columnNamesWithTypes.keySet();
		
		for(String currentColumnName : columnNames)
		{
			queryBuilder.append(currentColumnName+" ").append(columnNamesWithTypes.get(currentColumnName) + " ");
			if(columnNamesWithSizes.get(currentColumnName).equals("")!=true)
			{
				queryBuilder.append("(" + columnNamesWithSizes.get(currentColumnName)+ "),");
			}
			else
			{
				queryBuilder.append(",");	
			}
		}
		String finalQuery = queryBuilder.toString();
		if(finalQuery.endsWith(","))
		{
			finalQuery=finalQuery.substring(0,finalQuery.length()-1).concat(")");
		}
		/*
		 CREATE TABLE Persons (PersonID  (),FirstName 255 (255),LastName 255 (255),
		 */
		
		return finalQuery;
	}

}
