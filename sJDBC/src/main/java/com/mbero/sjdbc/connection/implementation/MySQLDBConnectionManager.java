package com.mbero.sjdbc.connection.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.interfaces.DBConnectionManager;

public class MySQLDBConnectionManager implements DBConnectionManager {
    final static Logger log = Logger.getLogger(MySQLDBConnectionManager.class);
    private static Connection conn;

    public Connection createConnection(DBConnectionConfiguration dbConnectionConfiguraton) {
	if (conn == null) {
	    final String dbUrl = "jdbc:mysql://";
	    final String userName = dbConnectionConfiguraton.getUser();
	    final String password = dbConnectionConfiguraton.getPassword();

	    try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(dbUrl, userName, password);
	    } catch (SQLException sqlException) {
		log.debug("Wystąpił wyjątek w trakcie zestawiania połączenia z bazą : " + dbConnectionConfiguraton.getDatabaseType());
		log.debug(sqlException.getCause(), sqlException);
	    } catch (ClassNotFoundException classNotFoundException) {
		log.debug(classNotFoundException.getCause(), classNotFoundException);
	    }
	    return conn;
	} else {
	    return conn;
	}
    }

    public void closeConnection(Connection conn) {
	log.debug("Rozpoczynam działanie funkcji closeConnection()");
	if (conn != null) {
	    try {
		conn.close();
		log.debug("Połączenie z bazą zamknięto poprawnie");
	    } catch (SQLException sqlException) {
		log.debug("Wystapił błąd podczas zamykania połączenia z bazą");
		log.debug(sqlException.getCause(), sqlException);
	    }
	} else {
	    log.debug("Połączenie nie jest nawiązane, nie może zostać zamknięte");
	}
    }

}
