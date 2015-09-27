package com.mbero.sjdbc.operations.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.configuration.TableCreationConfiguration;
import com.mbero.sjdbc.interfaces.DBConnectionManager;
import com.mbero.sjdbc.tools.Tools;
import com.mysql.jdbc.StringUtils;

public class TableManagmentOperationsService extends DBOperationsService {
	final static Logger log = Logger
			.getLogger(TableManagmentOperationsService.class);

	/**
	 * Function which create table based on DBConnectionConfigurationObject and TableCreationConfiguration class object
	 * @param dbConnectionConfiguration
	 * @param ctobject
	 * @return
	 */
	public boolean createTable(
			DBConnectionConfiguration dbConnectionConfiguration, TableCreationConfiguration tableCreationConfiguration) {

		return true;
	}
	/**
	 * Function which create table based on DBConnectionConfigurationObject and createTableQuery
	 * @param dbConnectionConfiguration
	 * @param createTableQuery
	 * @return
	 */
	public boolean createTableByExecutingQuery(DBConnectionConfiguration dbConnectionConfiguration, String createTableQuery) {
		boolean tableCreatedProperly = false;
		DBConnectionManager connectionManager = Tools
				.returnProperConnectionManager(dbConnectionConfiguration
						.getDatabaseType());
		Connection conn = connectionManager
				.createConnection(dbConnectionConfiguration);
		int insertedRows = 0;
		try {
			Statement stmt = conn.createStatement();
			insertedRows = stmt.executeUpdate(createTableQuery);
			if (insertedRows > 0) {
				tableCreatedProperly = true;
			}
			log.debug(createTableQuery);
		} catch (SQLException e) {
			log.debug("Wystapil blad podczas wykonywania zapytania : "
					+ createTableQuery);
			log.debug(e.getCause(), e);
		}
		
		return tableCreatedProperly;
	}
	/**
	 * Function which delete table based on DBConnectionConfigurationObject and tableName
	 * @param dbConnectionConfiguration
	 * @param tableName
	 * @return
	 */
	public boolean deleteTable(DBConnectionConfiguration dbConnectionConfiguration, String tableName)
	{
		return true;
	}
	/**
	 * Function which executes alterTable query based on DBConnectionConfigurationOBject , table name and alter query
	 * @param dbConnectionConfiguration
	 * @param tableName
	 * @return
	 */	
	public boolean alterTable(DBConnectionConfiguration dbConnectionConfiguration, String tableName)
	{
		return true;
	}

}
