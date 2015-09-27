package com.mbero.sjdbc.configuration;

import com.mbero.sjdbc.enumtype.DatabaseType;

/**
 * POJO class which will be used for creating database connection configuration
 * objects
 * 
 * @author Marcin Berendt
 */
public class DBConnectionConfiguration {

	private String hostAndDatabaseName;
	private String user;
	private String password;
	private DatabaseType databaseType;
	private String databaseName;
	
	public String getHostAndDatabaseName() {
		return hostAndDatabaseName;
	}

	/**
	 * Example for PostgresSQL : "localhost:5432/test"
	 * Example for MySQL : localhost:3306/test
	 * 
	 * @param hostAndDatabaseName
	 */
	public void setHostAndDatabaseName(String hostAndDatabaseName) {
		String[] arrayFromSplit = hostAndDatabaseName.split("/");
		this.databaseName=arrayFromSplit[1];	
		this.hostAndDatabaseName = hostAndDatabaseName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DatabaseType getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(DatabaseType databaseType) {
		this.databaseType = databaseType;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

}
