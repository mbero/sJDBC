package com.mbero.sjdbc.operations.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mbero.sjdbc.configuration.DBConnectionConfiguration;
import com.mbero.sjdbc.interfaces.DBConnectionManager;
import com.mbero.sjdbc.tools.Tools;
import com.mysql.jdbc.StringUtils;

public class TableManagmentOperationsService extends DBOperationsService {
	final static Logger log = Logger
			.getLogger(TableManagmentOperationsService.class);

	// TODO : rozwiazanie kwestii jakich danych potrzeba do stworzenia tabeli -
	// utworzenie klasy obiektu konfiguracyjnego sluzacego
	// do tworzenia tabeli - na podstawie
	public void createTable(
			DBConnectionConfiguration dbConnectionConfiguration, Object ctobject) {
		//
	}

}
