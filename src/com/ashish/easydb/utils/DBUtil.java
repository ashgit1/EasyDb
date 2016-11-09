package com.ashish.easydb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBUtil {

	static Logger log = Logger.getLogger(DBUtil.class.getName());
	static Connection conn;
	
	public static Connection getCon(String dbDriver, String dbUrl, String dbUser, String dbPassword) {

		try {
			Class.forName(dbDriver);
			log.info("Driver Loaded....");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			log.info("Connection establish....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
