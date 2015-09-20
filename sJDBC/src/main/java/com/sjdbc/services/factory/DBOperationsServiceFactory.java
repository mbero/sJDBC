package com.sjdbc.services.factory;

import com.sjdbc.operations.services.DeleteOperationsService;
import com.sjdbc.operations.services.InsertOperationsService;
import com.sjdbc.operations.services.SelectOperationsService;

public class DBOperationsServiceFactory {

	public static SelectOperationsService getSelectOperationsService()
	{
		return new SelectOperationsService();
	}
	public static InsertOperationsService getInsertOperationsService()
	{
		return new InsertOperationsService();
	}
	public static DeleteOperationsService getDeleteOperationsService()
	{
		return new DeleteOperationsService();
	}
}
