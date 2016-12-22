package com.ashish.easydb.model;

import java.util.List;

public class DatabaseMetaDataInfo {
	
	private List<String> tableList;
	private DBMetaData dbMetadata;
	private String connectString;
	private String dbName;
	
	public List<String> getTableList() {
		return tableList;
	}
	public void setTableList(List<String> tableList) {
		this.tableList = tableList;
	}
	
	public String getConnectString() {
		return connectString;
	}
	public void setConnectString(String connectString) {
		this.connectString = connectString;
	}
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	public DBMetaData getDbMetadata() {
		return dbMetadata;
	}
	public void setDbMetadata(DBMetaData dbMetadata) {
		this.dbMetadata = dbMetadata;
	}

}