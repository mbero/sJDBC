package com.mbero.sjdbc.operations.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.configuration.DBConnectionConfigurationStore;
import com.mbero.sjdbc.configuration.TableCreationConfiguration;
import com.mbero.sjdbc.enumtype.AlterTableOperations;
import com.mbero.sjdbc.interfaces.DBConnectionManager;
import com.mbero.sjdbc.tools.Tools;

public class TableManagmentOperationsService extends DBOperationsService {
    final static Logger log = Logger.getLogger(TableManagmentOperationsService.class);
    private DBConnectionConfiguration dbConnectionConfiguration = DBConnectionConfigurationStore.getDbConnectionConfiguration();

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
