package com.ezenmarket.controller.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			con = ds.getConnection();
		} catch (NamingException e) { e.printStackTrace();	}
		return con;
	}
	public static void close(Connection con, Statement stmt, ResultSet rs){
		try {	
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();}
		catch (Exception e) {e.printStackTrace();}
	}
}
