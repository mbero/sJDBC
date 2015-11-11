package com.mbero.sjdbc.operations.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.configuration.DBConnectionConfigurationStore;
import com.mbero.sjdbc.interfaces.DBConnectionManager;
import com.mbero.sjdbc.tools.Tools;

public class AlterTableOperationsService extends DBOperationsService {
    final static Logger log = Logger.getLogger(AlterTableOperationsService.class);
    private DBConnectionConfiguration dbConnectionConfiguration = DBConnectionConfigurationStore.getDbConnectionConfiguration();

    public boolean addNewColumn(String tableName, String columnName, String columnType) {
	DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
	Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
	String addNewColumnQuery = "ALTER TABLE " + tableName + " ADD " + columnName + " " + columnType;
	boolean addedNewColumn = false;
	int insertedRows = 0;
	try {
	    Statement stmt = conn.createStatement();
	    insertedRows = stmt.executeUpdate(addNewColumnQuery);
	    if (insertedRows > 0) {
		addedNewColumn = true;
	    }
	    log.debug(addNewColumnQuery);
	} catch (SQLException e) {
	    log.debug("Wystapil blad podczas wykonywania zapytania : " + addNewColumnQuery);
	    log.debug(e.getCause(), e);
	    return addedNewColumn;
	}
	return true;
    }

    public boolean dropColummn(String tableName, String columnName) {
	DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
	Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
	String dropColumnQuery = "ALTER TABLE " + tableName + " DROP " + columnName;
	boolean addedNewColumn = false;
	int insertedRows = 0;
	try {
	    Statement stmt = conn.createStatement();
	    insertedRows = stmt.executeUpdate(dropColumnQuery);
	    if (insertedRows > 0) {
		addedNewColumn = true;
	    }
	    log.debug(dropColumnQuery);
	} catch (SQLException e) {
	    log.debug("Wystapil blad podczas wykonywania zapytania : " + dropColumnQuery);
	    log.debug(e.getCause(), e);
	    return addedNewColumn;
	}

	return true;
    }

    public boolean changeColumnType(String tableName, String columnName, String newColumnName, String newColumnType) {
	DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
	Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
	String dropColumnQuery = "ALTER TABLE " + tableName + " CHANGE  " + columnName + " " + newColumnName + " " + newColumnType;
	boolean addedNewColumn = false;
	int insertedRows = 0;
	try {
	    Statement stmt = conn.createStatement();
	    insertedRows = stmt.executeUpdate(dropColumnQuery);
	    if (insertedRows > 0) {
		addedNewColumn = true;
	    }
	    log.debug(dropColumnQuery);
	} catch (SQLException e) {
	    log.debug("Wystapil blad podczas wykonywania zapytania : " + dropColumnQuery);
	    log.debug(e.getCause(), e);
	    return addedNewColumn;
	}

	return true;
    }

    public boolean setDefaultColumnValue(String tableName, String columnName, String defaultValue) {
	DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
	Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
	String dropColumnQuery = "ALTER TABLE "+tableName+" ALTER  "+columnName+" SET DEFAULT '" +defaultValue + "'";
	boolean addedNewColumn = false;
	int insertedRows = 0;
	try {
	    Statement stmt = conn.createStatement();
	    insertedRows = stmt.executeUpdate(dropColumnQuery);
	    if (insertedRows > 0) {
		addedNewColumn = true;
	    }
	    log.debug(dropColumnQuery);
	} catch (SQLException e) {
	    log.debug("Wystapil blad podczas wykonywania zapytania : " + dropColumnQuery);
	    log.debug(e.getCause(), e);
	    return addedNewColumn;
	}

	return true;
    }

}