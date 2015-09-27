package com.mbero.sjdbc.operations.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.interfaces.DBConnectionManager;
import com.mbero.sjdbc.tools.Tools;

public class InsertOperationsService extends DBOperationsService {
	final static Logger log = Logger.getLogger(InsertOperationsService.class);

	/**
	 * Function which executes query from parameter based on
	 * DBConnectionConfiguration object
	 *
	 * @param dbConnectionConfiguration
	 * @param insertQuery
	 */
	public boolean executeAnyInsertQueryFromParameter(
			DBConnectionConfiguration dbConnectionConfiguration,
			String insertQuery) {
		log.debug("Wywołuje funkcje executeAnyInsertQueryFromParameter() z InsertOperationsService");
		boolean rowsInsertedProperly = false;
		DBConnectionManager connectionManager = Tools
				.returnProperConnectionManager(dbConnectionConfiguration
						.getDatabaseType());
		Connection conn = connectionManager
				.createConnection(dbConnectionConfiguration);
		int insertedRows = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = insertQuery;
			insertedRows = stmt.executeUpdate(insertQuery);
			if (insertedRows > 0) {
				rowsInsertedProperly = true;
			}
			log.debug(query);
		} catch (SQLException e) {
			log.debug("Wystapil blad podczas wykonywania zapytania : "
					+ insertQuery);
			log.debug(e.getCause(), e);
		}
		return rowsInsertedProperly;
	}

	/**
	 * Function which insert data based on DBConnectionConfiguration object ,
	 * tableName parameter and values Map, which keys are columns id's
	 * 
	 * @param DBConnectionConfiguration
	 *            dbConnectionConfiguration
	 * @param String
	 *            tableName
	 * @param Map
	 *            <String,Object> values
	 * @return
	 */
	public boolean insertDataBasedOnValuesMap(
			DBConnectionConfiguration dbConnectionConfiguration,
			String tableName, Map<String, Object> values) {
		log.debug("Wywołuje funkcje executeAnyInsertQueryFromParameter() z InsertOperationsService");
		boolean rowsInsertedProperly = false;
		DBConnectionManager connectionManager = Tools
				.returnProperConnectionManager(dbConnectionConfiguration
						.getDatabaseType());
		Connection conn = connectionManager
				.createConnection(dbConnectionConfiguration);
		int insertedRows = 0;
		String insertQuery = "";
		try {
			Statement stmt = conn.createStatement();
			insertQuery = Tools.returnInsertQueryFromMap(tableName, values);
			insertedRows = stmt.executeUpdate(insertQuery);
			if (insertedRows > 0) {
				rowsInsertedProperly = true;
			}
			log.debug(insertQuery);
		} catch (SQLException e) {
			log.debug("Wystapil blad podczas wykonywania zapytania : "
					+ insertQuery);
			log.debug(e.getCause(), e);
		}
		return rowsInsertedProperly;
	}

}
