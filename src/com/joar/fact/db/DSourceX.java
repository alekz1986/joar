package com.joar.fact.db;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;

public class DSourceX {

	public static Connection getConnection() {
		try {
			Context ctx = new InitialContext();
	        DSourceX ds = (DSourceX)ctx.lookup("jfact");
	        return ds.getConnection();
			/*
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/jfact");
			return ds.getConnection();
			*/
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
}
