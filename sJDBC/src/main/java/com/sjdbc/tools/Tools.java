package com.sjdbc.tools;

import java.util.ArrayList;
import java.util.List;

import com.sjdbc.connection.implementations.MySQLDBConnectionManager;
import com.sjdbc.connection.implementations.PostgreSQLDBConnectionManager;
import com.sjdbc.enumtypes.DatabaseType;
import com.sjdbc.interfaces.DBConnectionManager;

/**
 * Zbiór różnych funkcji wykorzystywanych w bibliotece sJDBC
 * @author Marcin
 *
 */
public class Tools {

	public static List<String> getOptionalParametersAsObjectsArray(String...optionalParameters)
	{
		List<String>list = new ArrayList<String>();
		for(String currentOptionalParameter : optionalParameters)
		{
			list.add(currentOptionalParameter);
		}
		
		return list;
	}
	public static String returnColumnsAsStringForQuery(List<String> optionalParameters)
	{
		String columnsString="";
		StringBuilder columnsStringBuilder = new StringBuilder();
		for(String currentString : optionalParameters)
		{
			columnsStringBuilder.append(currentString+",");
		}
		columnsString=columnsStringBuilder.toString();
		if(columnsString.endsWith(","))
		{
			columnsString=columnsString.substring(0, columnsString.length()-1);
		}
		return columnsString;
	}

	public static DBConnectionManager returnProperConnectionManager(DatabaseType databaseType)
	{
		DBConnectionManager properConnectionManager = null;
        switch (databaseType) 
        {
        	case MYSQL : properConnectionManager = new MySQLDBConnectionManager();
        	break;
        	case POSTGRESQL : properConnectionManager = new PostgreSQLDBConnectionManager();
        	break;
        }
        
        return properConnectionManager;
	}
}
