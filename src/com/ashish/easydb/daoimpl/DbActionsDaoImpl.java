package com.ashish.easydb.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

import com.ashish.easydb.dao.DbActionsDao;
import com.ashish.easydb.utils.DBUtil;

public class DbActionsDaoImpl implements DbActionsDao {

	static Logger log = Logger.getLogger(DbActionsDaoImpl.class.getName());
	boolean dbConnectionStatus;
	Connection conn;
	PreparedStatement prepStat;
	ResultSet resultSet;

	@Override
	public boolean checkDbServer(String dbName, String dbDriver, String dbUrl, String dbUser, String dbPassword) {

		try {
			
			conn = DBUtil.getCon(dbDriver, dbUrl, dbUser, dbPassword);
			//get all the tables of that database...
			String getAllTablesQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES " +
                    " WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ? ";
			prepStat = conn.prepareStatement(getAllTablesQuery);
			prepStat.setString(1, "testdb");
			
			resultSet = prepStat.executeQuery();
			
			while(resultSet.next()){
				System.out.println(resultSet.getString(1));
			}
			
			if(conn != null){
				dbConnectionStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnectionStatus;
	}


	@Override
	public List<String> getAllTables(String dbName) {
		
		String getAllTablesQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES " +
                                   " WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ? ";
		
		
		return null;
	}
	
	


}
