package com.mbero.sjdbc.configuration;

public class DBConnectionConfigurationStore {

    private static DBConnectionConfiguration dbConnectionConfiguration = null;

    public static DBConnectionConfiguration getDbConnectionConfiguration() {
	if (dbConnectionConfiguration == null) {
	    dbConnectionConfiguration = new DBConnectionConfiguration();
	}
	return dbConnectionConfiguration;
    }

    public static void setDbConnectionConfiguration(DBConnectionConfiguration dbConnectionConfiguration) {
	DBConnectionConfigurationStore.dbConnectionConfiguration = dbConnectionConfiguration;
    }

}
