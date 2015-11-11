package com.mbero.sjdbc.operations.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.configuration.DBConnectionConfigurationStore;
import com.mbero.sjdbc.configuration.TableCreationConfiguration;
import com.mbero.sjdbc.interfaces.DBConnectionManager;
import com.mbero.sjdbc.tools.Tools;

public class TableManagmentOperationsService extends DBOperationsService {
    final static Logger log = Logger.getLogger(TableManagmentOperationsService.class);
    private DBConnectionConfiguration dbConnectionConfiguration = DBConnectionConfigurationStore.getDbConnectionConfiguration();

    /**
     * Function check if table exists in db
     * @param tableName
     * @return boolean tableExists
     */
    public boolean checkIfTableExists(String tableName) {
	DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
	Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
	boolean tableExists = false;
	String checkIfTableExistsQuery = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + dbConnectionConfiguration.getDatabaseName() + "' AND table_name LIKE '"
		+ tableName + "'";
	int resultCounter = 0;
	try {
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(checkIfTableExistsQuery);

	    while (rs.next()) {
		resultCounter++;
	    }
	    if (resultCounter > 0) {
		tableExists = true;
	    }
	} catch (SQLException e) {
	    log.debug("Wystapil blad podczas wykonywania zapytania : " + checkIfTableExistsQuery);
	    log.debug(e.getCause(), e);
	}
	return tableExists;
    }

    /**
     * Function which create table based on DBConnectionConfigurationObject and
     * TableCreationConfiguration class object
     * 
     * @param dbConnectionConfiguration
     * @param ctobject
     * @return
     */
    public boolean createTable(TableCreationConfiguration tableCreationConfiguration) {
	DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
	Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
	String dropTableQuery = Tools.constructCreateTableQuery(tableCreationConfiguration);
	try {
	    Statement stmt = conn.createStatement();
	    stmt.executeUpdate(dropTableQuery);
	} catch (SQLException e) {
	    log.debug("Wystapil blad podczas wykonywania zapytania : " + dropTableQuery);
	    log.debug(e.getCause(), e);
	}
	return true;
    }

    /**
     * Function which create table based on DBConnectionConfigurationObject and
     * createTableQuery
     * 
     * @param dbConnectionConfiguration
     * @param createTableQuery
     * @return
     */
    public boolean createTableByExecutingQuery(String createTableQuery) {
	boolean tableCreatedProperly = false;
	DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
	Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
	int insertedRows = 0;
	try {
	    Statement stmt = conn.createStatement();
	    insertedRows = stmt.executeUpdate(createTableQuery);
	    if (insertedRows > 0) {
		tableCreatedProperly = true;
	    }
	    log.debug(createTableQuery);
	} catch (SQLException e) {
	    log.debug("Wystapil blad podczas wykonywania zapytania : " + createTableQuery);
	    log.debug(e.getCause(), e);
	    return false;
	}

	return tableCreatedProperly;
    }

}
