package com.sjdbc.connection.implementations;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.sjdbc.configuration.DBConnectionConfiguration;
import com.sjdbc.enumtypes.DatabaseType;

public class MySQLDBConnectionManagerTest {
	DBConnectionConfiguration configuration = new DBConnectionConfiguration();

	@Before
	public void setUp() throws Exception {
		configuration.setDatabaseType(DatabaseType.MYSQL);
		configuration.setHostAndDatabaseName("localhost:3306/trainingpartner");
		configuration.setUser("root");
		configuration.setPassword("password");
	}

	@Test
	public void connectionManagerTest() {
		MySQLDBConnectionManager mySQLDBConnectionManager = new MySQLDBConnectionManager();
		java.sql.Connection connection = mySQLDBConnectionManager.createConnection(configuration);
		assertNotNull(connection);
	}
}
