package com.mbero.sjdbc.configuration;

public class DBConnectionConfigurationStore {

	private static DBConnectionConfiguration dbConnectionConfiguration = new DBConnectionConfiguration();

	public static DBConnectionConfiguration getDbConnectionConfiguration() {
		return dbConnectionConfiguration;
	}

	public static void setDbConnectionConfiguration(
			DBConnectionConfiguration dbConnectionConfiguration) {
		DBConnectionConfigurationStore.dbConnectionConfiguration = dbConnectionConfiguration;
	}

}
