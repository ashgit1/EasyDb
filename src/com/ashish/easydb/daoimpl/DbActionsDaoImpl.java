package com.ashish.easydb.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	List<String> tableList;

	@Override
	public List<String> checkDbServer(String dbName, String dbDriver, String dbUrl, String dbUser, String dbPassword) {

		tableList = new ArrayList<String>();
		String getAllTablesQuery;
		try {
			conn = DBUtil.getCon(dbDriver, dbUrl, dbUser, dbPassword);
			
			if (conn!=null){
				System.out.println("Connection : " + conn);
				// get all the tables of that database...
				int lastIndexOf = dbUrl.lastIndexOf("/");
				int length = dbUrl.length();
				String dbToConnect = dbUrl.substring((lastIndexOf + 1), length);

				if(dbName.equalsIgnoreCase("derby")){
					getAllTablesQuery = "select tablename from sys.systables where tabletype='T'";
					prepStat = conn.prepareStatement(getAllTablesQuery);
				}else if(dbName.equalsIgnoreCase("mysql")){
					getAllTablesQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES "
							+ " WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ? ";
					prepStat = conn.prepareStatement(getAllTablesQuery);
					prepStat.setString(1, dbToConnect);
				}else{
					getAllTablesQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES "
							+ " WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ? ";
					prepStat = conn.prepareStatement(getAllTablesQuery);
					prepStat.setString(1, dbToConnect);
				}

				resultSet = prepStat.executeQuery();

				if (resultSet == null) {
					tableList.add("No Tables in " + dbToConnect);
				} else {
					while (resultSet.next()) {
						tableList.add(resultSet.getString(1));
					}
				}
			}else{
				System.out.println("Connection is null");
				tableList.add("Couldn't connect to database: " + dbUrl + ". Access Denied");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tableList;
	}

	/*
	 * @Override public List<String> getAllTables(String dbName) { String
	 * getAllTablesQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES " +
	 * " WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ? "; return null; }
	 */
}