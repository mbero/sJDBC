package com.mbero.sjdbc.configuration;

import java.util.Map;

public class TableCreationConfiguration {

	private String tableName;
	private Map<String, String> columnsWithTypes;
	private Map<String, String> columnsWithSizes;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map<String, String> getColumnsWithTypes() {
		return columnsWithTypes;
	}

	public void setColumnsWithTypes(Map<String, String> columnsWithTypes) {
		this.columnsWithTypes = columnsWithTypes;
	}

	public Map<String, String> getColumnsWithSizes() {
		return columnsWithSizes;
	}

	public void setColumnsWithSizes(Map<String, String> columnsWithSizes) {
		this.columnsWithSizes = columnsWithSizes;
	}

}
