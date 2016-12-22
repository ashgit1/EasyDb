package com.ashish.easydb.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.ashish.easydb.dao.DbActionsDao;
import com.ashish.easydb.daoimpl.DbActionsDaoImpl;
import com.ashish.easydb.model.DBMetaData;
import com.ashish.easydb.model.DatabaseMetaDataInfo;

@Path("/db")
public class CheckDBServices {
	
	static Logger log = Logger.getLogger(CheckDBServices.class.getName());
	
	@POST
	@Path("/{checkdb}")
	public Response checkDatabaseConnection(@FormParam("db-name") String dbName, @FormParam("db-driver") String dbDriver,
											@FormParam("db-url") String dbUrl, @FormParam("db-user") String dbUser, 
											@FormParam("db-password") String dbPassword, @Context HttpServletRequest request) {
		
		StringBuffer dbBuffer = new StringBuffer();
		List<String> tableList = new ArrayList<String>();
		StringBuffer tableBuffer = new StringBuffer();
		DatabaseMetaDataInfo dbMetaDataInfo = new DatabaseMetaDataInfo();
		DBMetaData metaData = new DBMetaData();
		
		dbBuffer.append(dbName + ", " + dbDriver + ", " + dbUrl + ", " + dbUser + ", " + dbPassword);
		String dbConnectionString = "Db Details : " + dbBuffer;
		
		DbActionsDao obj = new DbActionsDaoImpl();
		tableList = obj.checkDbServer(dbName, dbDriver, dbUrl, dbUser, dbPassword);
		
		if(tableList!=null){
			for(String table : tableList){
				tableBuffer.append(table);
				tableBuffer.append(System.lineSeparator());
			}
		}
		
		log.info(dbConnectionString);
		System.out.println(dbConnectionString);
		System.out.println(tableBuffer.toString());
		
		// Putting the tables and db metadata info in session.
		HttpSession dbTablesInSession = request.getSession();
		
		dbMetaDataInfo.setTableList(tableList);
		dbMetaDataInfo.setConnectString(dbConnectionString);
		
		metaData = obj.getDbMetaData(dbDriver, dbUrl, dbUser, dbPassword);
		dbMetaDataInfo.setDbMetadata(metaData);
		
		
		int lastIndexOf = dbUrl.lastIndexOf("/");
		int length = dbUrl.length();
		String dbToConnect = dbUrl.substring((lastIndexOf + 1), length);
		dbMetaDataInfo.setDbName(dbToConnect);
		
		dbTablesInSession.setAttribute("dbMetaDataSession", dbMetaDataInfo);
		
		//return Response.status(200).entity(tableBuffer.toString()).build();
		try {
			java.net.URI location = new java.net.URI("../tables.jsp");
			return Response.temporaryRedirect(location).build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return Response.status(200).entity(tableBuffer.toString()).build();
		
	}
}