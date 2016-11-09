package com.ashish.easydb.dao;

import java.util.List;

public interface DbActionsDao {

	public boolean checkDbServer(String dbName, String dbDriver, String dbUrl, String dbUser, String dbPassword);
	
	public List<String> getAllTables(String dbName);

}
