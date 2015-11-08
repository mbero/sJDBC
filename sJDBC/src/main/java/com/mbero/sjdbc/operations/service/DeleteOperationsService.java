package com.mbero.sjdbc.operations.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.configuration.DBConnectionConfigurationStore;
import com.mbero.sjdbc.interfaces.DBConnectionManager;
import com.mbero.sjdbc.tools.Tools;

public class DeleteOperationsService extends DBOperationsService {
    final static Logger log = Logger.getLogger(DeleteOperationsService.class);
    private DBConnectionConfiguration dbConnectionConfiguration = DBConnectionConfigurationStore.getDbConnectionConfiguration();
    /**
     * Function which delete table based on DBConnectionConfigurationObject and
     * tableName
     * 
     * @param dbConnectionConfiguration
     * @param tableName
     * @return
     */
    public boolean deleteTable( String tableName) {
	DBConnectionManager connectionManager = Tools.returnProperConnectionManager(dbConnectionConfiguration.getDatabaseType());
	Connection conn = connectionManager.createConnection(dbConnectionConfiguration);
	String dropTableQuery = "DROP TABLE " + tableName;
	try {
	    Statement stmt = conn.createStatement();
	    stmt.executeUpdate(dropTableQuery);
	} catch (SQLException e) {
	    log.debug("Wystapil blad podczas wykonywania zapytania : " + dropTableQuery);
	    log.debug(e.getCause(), e);
	    return false;
	}
	return true;
    }
}
