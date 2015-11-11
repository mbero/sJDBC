package com.sjdbc.operations.services;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.configuration.DBConnectionConfigurationStore;
import com.mbero.sjdbc.configuration.TableCreationConfiguration;
import com.mbero.sjdbc.enumtype.DatabaseType;
import com.mbero.sjdbc.operations.service.DeleteOperationsService;
import com.mbero.sjdbc.operations.service.InsertOperationsService;
import com.mbero.sjdbc.operations.service.TableManagmentOperationsService;
import com.mbero.sjdbc.service.factory.DBOperationsServiceFactory;

public class TableManagmentOperationsServiceTest {
	final static Logger log = Logger.getLogger(InsertOperationsService.class);
	DBConnectionConfiguration dbConnectionConfiguration = new DBConnectionConfiguration();

	@Before
	public void setUp() throws Exception {
		dbConnectionConfiguration.setDatabaseType(DatabaseType.MYSQL);
		dbConnectionConfiguration.setHostAndDatabaseName("localhost:3306/test");
		dbConnectionConfiguration.setUser("root");
		dbConnectionConfiguration.setPassword("password");
		DBConnectionConfigurationStore.setDbConnectionConfiguration(dbConnectionConfiguration);
	}

	@Test
	public void testCreateTable() {
	    
	    	TableManagmentOperationsService tableManagmentOperationsService = DBOperationsServiceFactory.getTableManagmentOperationsService();
	    	DeleteOperationsService deleteOperationsService = DBOperationsServiceFactory.getDeleteOperationsService();
	    	
	    	if(tableManagmentOperationsService.checkIfTableExists("test")==true)
	    	{
	    	    deleteOperationsService.deleteTable("test");
	    	}
	    	if(tableManagmentOperationsService.checkIfTableExists("test")==false)
	    	{
        		TableCreationConfiguration tableCreationConfiguration = new TableCreationConfiguration();	
        		Map<String, String> columnsWithSizes = new HashMap<String,String>();
        		columnsWithSizes.put("kolumna1", "255");
        		columnsWithSizes.put("kolumna2", "255");
        		columnsWithSizes.put("kolumna3", "255");
        		Map<String, String> columnsWithTypes = new HashMap<String,String>();
        		columnsWithTypes.put("kolumna1", "varchar");
        		columnsWithTypes.put("kolumna2", "varchar");
        		columnsWithTypes.put("kolumna3", "varchar");
        		
        		tableCreationConfiguration.setColumnsWithSizes(columnsWithSizes);
        		tableCreationConfiguration.setColumnsWithTypes(columnsWithTypes);
        		tableCreationConfiguration.setTableName("test");
        		tableManagmentOperationsService.createTable(tableCreationConfiguration);
	        }
	    	assertTrue(tableManagmentOperationsService.checkIfTableExists("test"));
	}

	@Test
	public void testCreateTableByExecutingQuery() {
		fail("Not yet implemented"); // TODO
		//check if persons table exist
	    //if not exist createTable
	}

	@Test
	public void testDeleteTable() {
		TableManagmentOperationsService tableManagmentOperationsService = DBOperationsServiceFactory.getTableManagmentOperationsService();
	
	}
 
	@Test
	public void testAlterTable() {
		fail("Not yet implemented"); // TODO
	}

}
