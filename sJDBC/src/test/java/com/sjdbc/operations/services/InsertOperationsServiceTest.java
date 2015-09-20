	package com.sjdbc.operations.services;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sjdbc.configuration.DBConnectionConfiguration;
import com.sjdbc.enumtypes.DatabaseType;
import com.sjdbc.services.factory.DBOperationsServiceFactory;

public class InsertOperationsServiceTest extends DBOperationsService
{
	final static Logger log = Logger.getLogger(InsertOperationsService.class);
	DBConnectionConfiguration configuration = new DBConnectionConfiguration();

	@Before
	public void setUp() throws Exception {
		configuration.setDatabaseType(DatabaseType.MYSQL);
		configuration.setHostAndDatabaseName("localhost:3306/trainingpartner");
		configuration.setUser("root");
		configuration.setPassword("password");
	}

	@Test
	public void executeAnyInsertQueryFromParameterTest() {
		
		InsertOperationsService insertOperationsService = DBOperationsServiceFactory.getInsertOperationsService();
		String query = "INSERT INTO `trainingpartner`.`roles`(`id`,`role`) VALUES ('4', 'test')";
		int insertedRows = insertOperationsService.executeAnyInsertQueryFromParameter(configuration, query);
		assertTrue(insertedRows!=0);
		
	}
}
