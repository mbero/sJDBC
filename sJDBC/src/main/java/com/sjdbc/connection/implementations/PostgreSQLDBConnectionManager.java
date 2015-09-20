package com.sjdbc.connection.implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.sjdbc.configuration.DBConnectionConfiguration;
import com.sjdbc.interfaces.DBConnectionManager;

public class PostgreSQLDBConnectionManager implements DBConnectionManager
{

	final static Logger log = Logger.getLogger(MySQLDBConnectionManager.class);
	private static Connection conn;
	public Connection createConnection(DBConnectionConfiguration dbConnectionConfiguraton)
	{

		if(conn==null)
		{
			final String dbUrl = "jdbc:postgresql://"+dbConnectionConfiguraton.getHostAndDatabaseName();
			final String userName = dbConnectionConfiguraton.getUser();
			final String password = dbConnectionConfiguraton.getPassword();
			
			
			try 
			{
				Class.forName("org.postgresql.Driver");
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(dbUrl, userName, password);
			} 
			catch (SQLException sqlException) 
			{
				log.debug("Wystąpił wyjątek w trakcie zestawiania połączenia z bazą : "+ dbConnectionConfiguraton.getDatabaseType());
				log.debug(sqlException.getCause(),sqlException);
			}
			catch (ClassNotFoundException classNotFoundException) 
			{
				log.debug(classNotFoundException.getCause(),classNotFoundException);
			}
			return conn;
		}
		else
		{
			return conn;
		}
	}

	public void closeConnection(Connection conn) 
	{	
		log.debug("Rozpoczynam działanie funkcji closeConnection()");
		if(conn!=null)
		{
			try 
			{
				conn.close();
				log.debug("Połączenie z bazą zamknięto poprawnie");
			} 
			catch (SQLException sqlException) 
			{
				log.debug("Wystapił błąd podczas zamykania połączenia z bazą");
				log.debug(sqlException.getCause(),sqlException);
			}
		}
		else
		{
			log.debug("Połączenie nie jest nawiązane, nie może zostać zamknięte");
		}
	}


}
