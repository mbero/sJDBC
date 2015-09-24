package com.mbero.sjdbc.interfaces;

import java.sql.Connection;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;

public interface DBConnectionManager {

	public Connection createConnection(
			DBConnectionConfiguration dbConnectionConfiguraton);

	public void closeConnection(Connection conn);

}
