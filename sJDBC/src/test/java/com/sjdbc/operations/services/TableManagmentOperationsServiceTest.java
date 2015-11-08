package com.sjdbc.operations.services;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.enumtype.DatabaseType;
import com.mbero.sjdbc.operations.service.InsertOperationsService;
import com.mbero.sjdbc.operations.service.TableManagmentOperationsService;
import com.mbero.sjdbc.service.factory.DBOperationsServiceFactory;

public class TableManagmentOperationsServiceTest {
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
	public void testCreateTable() {
		fail("Not yet implemented"); // TODO
		//check if persons table exist
	    //if not exist createTable
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
