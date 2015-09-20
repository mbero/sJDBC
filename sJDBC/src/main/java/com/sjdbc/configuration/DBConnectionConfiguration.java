package com.sjdbc.configuration;

import com.sjdbc.enumtypes.DatabaseType;

/**
 * Klasa służąca do tworzenia obiektów zawierających niezbędne informacje do połączenia
 * 
 * @author Marcin Berendt
 *
 */
public class DBConnectionConfiguration {

	private String hostAndDatabaseName;
	private String user;
	private String password;
	private DatabaseType databaseType; 

	public String getHostAndDatabaseName() {
		return hostAndDatabaseName;
	}
	/**
	 * Example for PostgresSQL : "localhost:5432/test"
	 * Example for MySQL : localhost:3306/test
	 * @param hostAndDatabaseName
	 */
	public void setHostAndDatabaseName(String hostAndDatabaseName) {
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

}
