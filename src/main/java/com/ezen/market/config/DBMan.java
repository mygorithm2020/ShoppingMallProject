package com.ezen.market.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class DBMan {
	
	@Autowired 
	ComboPooledDataSource dataSource;
	//private ComboPooledDataSource dataSource = dbcon.dataSource();
	 
	
	public Connection getConnection() {
		Connection con =null;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");			 
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			con = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(con!=null) {con.close();}
			if(pstmt != null) {pstmt.close();}
			if(rs!=null) {rs.close();}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
