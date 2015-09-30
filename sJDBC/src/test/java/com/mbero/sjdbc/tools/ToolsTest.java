package com.mbero.sjdbc.tools;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.configuration.TableCreationConfiguration;
import com.mbero.sjdbc.enumtype.DatabaseType;
import com.mbero.sjdbc.interfaces.DBConnectionManager;
import com.mbero.sjdbc.operations.service.InsertOperationsService;
import com.mbero.sjdbc.service.factory.DBOperationsServiceFactory;

public class ToolsTest {
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
	public void testGetOptionalParametersAsObjectsArray() {
		String firstParameter = "test1";
		String secondParameter = "test2";
		String thirdParameter = "test3";
		List<String> testList = new ArrayList<String>();
		testList.add(firstParameter);
		testList.add(secondParameter);
		testList.add(thirdParameter);
		List<String> returnedList =  Tools.getOptionalParametersAsObjectsArray(firstParameter,secondParameter,thirdParameter);
		assertTrue(returnedList.containsAll(testList));
	}

	@Test
	public void testReturnColumnsAsStringForQuery() {
		List<String> optionalParameters = new ArrayList<String>();
		optionalParameters.add("Kolumna1");
		optionalParameters.add("Kolumna2");
		optionalParameters.add("Kolumna3");
		String returnedString = Tools.returnColumnsAsStringForQuery(optionalParameters);
		String test = "Kolumna1,Kolumna2,Kolumna3";
		assertTrue(returnedString.equals(test));
	}

	@Test
	public void testReturnProperConnectionManager() {
		DatabaseType databaseType = configuration.getDatabaseType();
		DBConnectionManager dbConnectionManager = Tools.returnProperConnectionManager(databaseType);
		assertTrue(dbConnectionManager!=null);
	}

	@Test
	public void testReturnInsertQueryFromMap() {
		InsertOperationsService insertOperationsService = DBOperationsServiceFactory
				.getInsertOperationsService();
		String tableName = "trainingpartner.roles";
		Map<String,Object> valuesToInsert = new HashMap<String,Object>();
		valuesToInsert.put("role", "test");
		String insertQuery =Tools.returnInsertQueryFromMap(tableName, valuesToInsert);
		assertTrue(insertOperationsService
				.executeAnyInsertQueryFromParameter(configuration, insertQuery));
	}
	
	@Test
	public void testConstructCreateTableQuery()
	{
		String testQuery="CREATE TABLE Persons (PersonID int ,FirstName varchar (255),LastName varchar (255))";
		
		Map<String,String> columnNamesWithTypes = new HashMap<String,String>();
		Map<String,String> columnNamesWithSizes = new HashMap<String,String>();
		TableCreationConfiguration tableCreationConfigurationObject = new TableCreationConfiguration();
		
		columnNamesWithTypes.put("PersonID", "int");
		columnNamesWithTypes.put("LastName", "varchar");
		columnNamesWithTypes.put("FirstName", "varchar");
		
		columnNamesWithSizes.put("PersonID", "");
		columnNamesWithSizes.put("LastName", "255");
		columnNamesWithSizes.put("FirstName", "255");
		
		tableCreationConfigurationObject.setTableName("Persons");
		tableCreationConfigurationObject.setColumnsWithSizes(columnNamesWithSizes);
		tableCreationConfigurationObject.setColumnsWithTypes(columnNamesWithTypes);
		
		String queryFromTestedMethod = Tools.constructCreateTableQuery(tableCreationConfigurationObject);
		assertTrue(testQuery.equals(queryFromTestedMethod));
		
	}

}
