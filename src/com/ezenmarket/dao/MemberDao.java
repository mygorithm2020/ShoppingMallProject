package com.ezenmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ezenmarket.controller.util.DBManager;
import com.ezenmarket.dto.MemberVo;



public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() { return instance; }
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	
		
	public MemberVo getMember(String id) {   // LoginAction 
		MemberVo mvo = null;
		String sql = "select * from member where id=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			 if(rs.next()) {
				 mvo = new MemberVo();
				 mvo.setId(rs.getString("id"));
				 mvo.setNum(rs.getInt("num"));				 
				 mvo.setName(rs.getString("name"));
				 mvo.setPw(rs.getString("pw"));
				 mvo.setEmail(rs.getString("email"));
				 mvo.setPhone(rs.getString("phone"));
				 mvo.setZipcode(rs.getString("zipcode"));
				 mvo.setAddress(rs.getString("address"));
				 mvo.setGender(rs.getString("gender"));
				 mvo.setBirth(rs.getInt("birth"));
				 mvo.setAdmin(rs.getInt("admin"));
			 }
		} catch (SQLException e) {	e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs); }
		return mvo;
	}
	
		
	
	public void deleteMember(String id) {   //MemberDeleteAction
		String sql = "Delete from member where id=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {DBManager.close(con, pstmt, rs); }
		
	}
	
	
	 
	public void updateMember(MemberVo mvo) {   // MemberUpdateAction
		String sql = "Update member set pw=?, name=?, zipcode=?, address=?, email=?, phone=?, gender=?, birth=? where id=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPw());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getZipcode());
			pstmt.setString(4, mvo.getAddress());
			pstmt.setString(5, mvo.getEmail());
			pstmt.setString(6, mvo.getPhone());
			pstmt.setString(7, mvo.getGender());
			pstmt.setInt(8, mvo.getBirth());
			pstmt.setString(9, mvo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {DBManager.close(con, pstmt, rs); }
	}
		
	
	
	public void insertMember(MemberVo mvo) {   // JoinAction
		String sql = "insert into member(id, pw, name, zipcode, address, email, phone, gender, birth) values(?,?,?,?,?,?,?,?,?) ";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPw());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getZipcode());
			pstmt.setString(5, mvo.getAddress());
			pstmt.setString(6, mvo.getEmail());
			pstmt.setString(7, mvo.getPhone());
			pstmt.setString(8, mvo.getGender());
			pstmt.setInt(9, mvo.getBirth());
			pstmt.executeUpdate();			
			System.out.println(mvo.getBirth());
		} catch (SQLException e) {  e.printStackTrace();
		}  finally {DBManager.close(con, pstmt, rs); }
	}
	
	
	
	public int confirmID(String id) {   // IdCheckFormAction
		int message = -1;
		String sql = "select * from member where id=?";
		try { 
		  con = DBManager.getConnection(); 
		  pstmt = con.prepareStatement(sql);
		  pstmt.setString(1, id);
		  rs = pstmt.executeQuery();
		  if(rs.next())message = 1;  // 중복 아이디 존재
		  else message = -1;  // 아이디 사용 가능		 
		  } catch (Exception e) { e.printStackTrace(); 
		  } finally { DBManager.close(con, pstmt, rs); }
		
		return message;
	}
					
		
}
