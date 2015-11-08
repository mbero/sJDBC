package com.mbero.sjdbc.service.factory;

import com.mbero.sjdbc.operations.service.DeleteOperationsService;
import com.mbero.sjdbc.operations.service.InsertOperationsService;
import com.mbero.sjdbc.operations.service.SelectOperationsService;
import com.mbero.sjdbc.operations.service.TableManagmentOperationsService;

public class DBOperationsServiceFactory {

	public static SelectOperationsService getSelectOperationsService() {
		return new SelectOperationsService();
	}

	public static InsertOperationsService getInsertOperationsService() {
		return new InsertOperationsService();
	}

	public static DeleteOperationsService getDeleteOperationsService() {
		return new DeleteOperationsService();
	}

	public static TableManagmentOperationsService getTableManagmentOperationsService() {
		return new TableManagmentOperationsService();
	}
}
