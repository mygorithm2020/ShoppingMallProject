package com.ezenmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ezenmarket.controller.util.DBManager;



public class UploadDao {
	private UploadDao() {}
	private static UploadDao instance = new UploadDao();
	public static UploadDao getInstance() { return instance;}
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<Integer> selectnumUpload(String id){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select*from product where id=? order by oseq desc";
		try {
			  con = DBManager.getConnection();
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, id);
			  rs = pstmt.executeQuery();
			  while (rs.next()) {
					list.add(rs.getInt(1));
			  }
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBManager.close(con, pstmt, rs); }    
		return list;
	}

}
