package com.sjdbc.operations.services;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.enumtype.DatabaseType;
import com.mbero.sjdbc.operations.service.SelectOperationsService;
import com.mbero.sjdbc.service.factory.DBOperationsServiceFactory;

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
	List<Map<String, String>> result = selectOperationsService.executeAnySelectQueryFromParameter("SELECT * FROM trainingpartner.exercises;", "planned_repeats");
	assertTrue(result.size() != 0);
    }

    @Test
    public void getValuesFromDBTest() {
	SelectOperationsService selectOperationsService = DBOperationsServiceFactory.getSelectOperationsService();
	List<Map<String, String>> result = selectOperationsService.getValuesFromDB("trainingpartner.exercises", "", "planned_repeats");
	assertTrue(result.size() != 0);
    }

}
