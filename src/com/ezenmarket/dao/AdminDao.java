package com.ezenmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenmarket.controller.util.DBManager;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.OrderVo;
import com.ezenmarket.dto.Paging;
import com.ezenmarket.dto.ProductVo;
import com.ezenmarket.dto.QnaVo;
import com.ezenmarket.dto.RentVo;



public class AdminDao {
	private AdminDao() {}
	private static AdminDao instance = new AdminDao();
	public static AdminDao getInstance() { return instance;}
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<QnaVo> listAllQna(Paging paging){
		ArrayList<QnaVo> list = new ArrayList<QnaVo> ();
	    String sql = "select * from "
				+ " ( select * from "
                + " ( select rownum as row_num, qna.* from qna  order by num desc )"
                + "  where row_num >= ? )"
                + "  where row_num <= ?";
	    int startNum = paging.getStartNum();
	    int endNum = paging.getEndNum();
	    try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVo qvo = new QnaVo();
				qvo.setNum(rs.getInt("num"));
				qvo.setTitle(rs.getString("title"));
				qvo.setResult(rs.getString("result"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));				
		        list.add(qvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {DBManager.close(con, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<RentVo> listOrder(Paging paging, String key){
		ArrayList<RentVo> list = new ArrayList<RentVo>();
		String sql = "select * from   "
				+ "(select * from   " 
				+ "(select rownum as row_num, rent.* from rent "
				+ "   where name like '%'||?||'%'  order by borrow, num desc)"
				+ "   where row_num>=?)"
				+ "   where row_num<=?";
		int startNum = paging.getStartNum();
	    int endNum = paging.getEndNum();
		try {
			  con = DBManager.getConnection();
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, key);
			  pstmt.setInt(2, startNum);
			  pstmt.setInt(3, endNum);
			  rs = pstmt.executeQuery();
			  while(rs.next()) {
				  RentVo ovo = new RentVo();
					ovo.setNum(rs.getInt("num"));
					ovo.setName(rs.getString("name"));
					ovo.setRnum(rs.getInt("rnum"));
					ovo.setId(rs.getString("id"));
					ovo.setBorrow(rs.getDate("borrow"));
					ovo.setTurn(rs.getDate("turn"));
					ovo.setLocationname(rs.getString("locationname"));
					ovo.setPrice(rs.getInt("price"));
					ovo.setCount(rs.getInt("count"));
					list.add(ovo);
			  }
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBManager.close(con, pstmt, rs); } 
		return list;
	}
	
	public ArrayList<ProductVo> listProduct(Paging paging, String key){
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		int startNum = paging.getStartNum();
	    int endNum = paging.getEndNum();
		String sql = "select * from "
							+ "(select * from "
							+ "(select rownum as row_num, product.* from product "
							+ " where name like '%'||?||'%' order by num desc)"
							+ " where row_num>=?)"
							+ " where row_num<=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, key);
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			
			rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	ProductVo pvo = new ProductVo();
		    	pvo.setNum(rs.getInt("num"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setImg(rs.getString("img"));
				pvo.setLocationname(rs.getString("locationname"));
				pvo.setTitle(rs.getString("title"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setId(rs.getString("id"));
				pvo.setCategory(rs.getInt("category"));
				pvo.setClassify(rs.getString("classify"));
    	    	list.add(pvo);
		    }
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);}	
		return list;
	}
	
	public int getAllCount(String key) {
		int count =0;
		String sql = "select count(*) as count from member where name like '%'||?||'%'";
		try {
			  con = DBManager.getConnection();
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1,  key);
			  rs = pstmt.executeQuery();
			  if(rs.next()) count = rs.getInt("count");
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBManager.close(con, pstmt, rs); } 
		return count;
	}
	
	public ArrayList<MemberVo> listMember(Paging paging, String key){
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "select * from   "
				+ "(select * from   " 
				+ "(select rownum as row_num, member.* from member "
				+ "  where name like '%'||?||'%' order by indate desc)"
				+ "  where row_num>=?)"
				+ "  where row_num<=?";
		int startNum = paging.getStartNum();
	    int endNum = paging.getEndNum();
		try {
			  con = DBManager.getConnection();
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, key);
			  pstmt.setInt(2, startNum);
			  pstmt.setInt(3, endNum);
			  rs = pstmt.executeQuery();
			  while(rs.next()) {
				  MemberVo mvo = new MemberVo();
				  	mvo.setNum(rs.getInt("num"));
					mvo.setId(rs.getString("id"));
					mvo.setPw(rs.getString("pw"));
					mvo.setName(rs.getString("name"));
					mvo.setEmail(rs.getString("email"));
					mvo.setZipcode(rs.getString("zipcode"));
					mvo.setAddress(rs.getString("address"));
					mvo.setPhone(rs.getString("phone"));
					mvo.setGender(rs.getString("gender"));
					mvo.setBirth(rs.getInt("birth"));
					mvo.setIndate(rs.getTimestamp("indate"));
					list.add(mvo);
			  }
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBManager.close(con, pstmt, rs); } 
		return list;
	}

}
