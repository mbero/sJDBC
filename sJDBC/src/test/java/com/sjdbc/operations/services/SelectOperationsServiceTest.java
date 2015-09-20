package com.sjdbc.operations.services;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.sjdbc.configuration.DBConnectionConfiguration;
import com.sjdbc.enumtypes.DBOperationsServiceType;
import com.sjdbc.enumtypes.DatabaseType;
import com.sjdbc.services.factory.DBOperationsServiceFactory;

public class SelectOperationsServiceTest {

	DBConnectionConfiguration configuration = new DBConnectionConfiguration();

	@Before
	public void setUp() throws Exception {
		configuration.setDatabaseType(DatabaseType.MYSQL);
		configuration.setHostAndDatabaseName("localhost:3306/trainingpartner");
		configuration.setUser("root");
		configuration.setPassword("password");
	}

	@Test
	public void executeAnySelectQueryFromParameterTest() {
		SelectOperationsService selectOperationsService = DBOperationsServiceFactory.getSelectOperationsService();
		List<Map<String, String>> result = selectOperationsService.executeAnySelectQueryFromParameter(configuration,"SELECT * FROM trainingpartner.exercises;","planned_repeats");
		assertTrue(result.size() != 0);
	}
	
	@Test
	public void getValuesFromDBTest()
	{
		SelectOperationsService selectOperationsService = DBOperationsServiceFactory.getSelectOperationsService();
		List<Map<String,String>> result = selectOperationsService.getValuesFromDB(configuration, "trainingpartner.exercises", "", "planned_repeats" );                     
		assertTrue(result.size() != 0);
	}

}
