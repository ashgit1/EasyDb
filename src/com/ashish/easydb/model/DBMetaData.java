package com.ashish.easydb.model;

public class DBMetaData {
	
	private String driverName;
	private String driverVersion;
	private String userName;
	private String dbProductName;
	private String dbProductVersion;
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	public String getDriverVersion() {
		return driverVersion;
	}
	public void setDriverVersion(String driverVersion) {
		this.driverVersion = driverVersion;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getDbProductName() {
		return dbProductName;
	}
	public void setDbProductName(String dbProductName) {
		this.dbProductName = dbProductName;
	}
	
	public String getDbProductVersion() {
		return dbProductVersion;
	}
	public void setDbProductVersion(String dbProductVersion) {
		this.dbProductVersion = dbProductVersion;
	}

}