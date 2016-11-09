package com.ashish.easydb.rest;


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
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(dbName + ", " + dbDriver + ", " + dbUrl + ", " + dbUser + ", " + dbPassword);
		String output = "Db Details : " + buffer;
		String success="";
		
		DbActionsDao obj = new DbActionsDaoImpl();
		if(obj.checkDbServer(dbName, dbDriver, dbUrl, dbUser, dbPassword)){
			success= "Connection is Sucess";
		}
		
		log.info(output);
		
		return Response.status(200).entity(success).build();
	}
}