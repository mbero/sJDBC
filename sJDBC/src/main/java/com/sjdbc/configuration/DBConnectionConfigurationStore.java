package com.sjdbc.configuration;

public  class DBConnectionConfigurationStore {
	
	/**
	 * Użycie obiektu statycznego daje możliwość jednokrotnego stworzenia obiektu connection i wykorzystywania go wielokrotnie w różnych miejscach
	 */
	private static DBConnectionConfiguration dbConnectionConfiguration = new DBConnectionConfiguration();
	
	public static DBConnectionConfiguration getDbConnectionConfiguration(){
		return dbConnectionConfiguration;
	}

	public static void setDbConnectionConfiguration(DBConnectionConfiguration dbConnectionConfiguration) {
		DBConnectionConfigurationStore.dbConnectionConfiguration = dbConnectionConfiguration;
	}
	
	
	
}
