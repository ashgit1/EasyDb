package com.ashish.easydb.rest;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.ashish.easydb.dao.DbActionsDao;
import com.ashish.easydb.daoimpl.DbActionsDaoImpl;

@Path("/db")
public class CheckDBServices {
	
	static Logger log = Logger.getLogger(CheckDBServices.class.getName());
	
	@POST
	@Path("/{checkdb}")
	public Response checkDatabaseConnection(@FormParam("db-name") String dbName, @FormParam("db-driver") String dbDriver,
											@FormParam("db-url") String dbUrl, @FormParam("db-user") String dbUser, 
											@FormParam("db-password") String dbPassword) {
		
		StringBuffer dbBuffer = new StringBuffer();
		List<String> tableList = new ArrayList<String>();
		StringBuffer tableBuffer = new StringBuffer();
		
		dbBuffer.append(dbName + ", " + dbDriver + ", " + dbUrl + ", " + dbUser + ", " + dbPassword);
		String output = "Db Details : " + dbBuffer;
		
		DbActionsDao obj = new DbActionsDaoImpl();
		tableList = obj.checkDbServer(dbName, dbDriver, dbUrl, dbUser, dbPassword);
		
		if(tableList!=null){
			for(String table : tableList){
				tableBuffer.append(table);
				tableBuffer.append(System.lineSeparator());
			}
		}
		
		log.info(output);
		System.out.println(output);
		System.out.println(tableBuffer);
		
		return Response.status(200).entity(tableBuffer.toString()).build();
	}
}