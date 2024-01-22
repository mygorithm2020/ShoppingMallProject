package com.ezenmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.ezenmarket.controller.util.DBManager;
import com.ezenmarket.dto.CartVo;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.ProductVo;
import com.ezenmarket.dto.RentcartVo;



public class CartDao {
	private CartDao() {}
	private static CartDao instance = new CartDao();
	public static CartDao getInstance() { return instance;}
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void deleteCart(Integer num) {
		String sql = "delete from rentcart where num=?";
		try {			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();							
		}catch (SQLException e) {		e.printStackTrace();		}
		finally {			DBManager.close(con, pstmt, rs);		}	
	}
	
	public void insertRentCart(RentcartVo rcvo) {
		String sql ="insert into rentcart(num, rnum, id, count, borrow, turn, result, price) values (rentcart_seq.nextval, ?, ?, 1,?, ?, 0, ?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rcvo.getRnum());      
		    pstmt.setString(2, rcvo.getId());
		    pstmt.setDate(3, rcvo.getBorrow());
		    
		    pstmt.setDate(4, rcvo.getTurn());
		    pstmt.setInt(5, rcvo.getPrice());
		   
		    pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);}	
	}
	
	
	
	
	
	
	
	
	public ArrayList<CartVo> listCart(String id){
		ArrayList<CartVo> list = new ArrayList<CartVo>();
		String sql = "select * from cart where id=? order by num desc";
		try {
		      con = DBManager.getConnection();
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setString(1, id);
		      rs = pstmt.executeQuery();
				while(rs.next()) {
					CartVo cvo = new CartVo();				
					cvo.setIndate(rs.getTimestamp("indate"));
					cvo.	setNum(rs.getInt("num"));
					cvo.setCnum(rs.getInt("cnum"));
					cvo.setCount(rs.getInt("count"));					
					list.add(cvo);
				}
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBManager.close(con, pstmt, rs); }   
		return list;
	}
	
	public ArrayList<RentcartVo> listRentCart(String id, Integer num, String name){
		ArrayList<RentcartVo> list = new ArrayList<RentcartVo>();
		String sql = "select * from rentcart where id=? and rnum=? order by num desc";
		try {
		      con = DBManager.getConnection();
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setString(1, id);
		      pstmt.setInt(2, num);
		      rs = pstmt.executeQuery();
				while(rs.next()) {
					RentcartVo cvo = new RentcartVo();				
					cvo.setIndate(rs.getTimestamp("indate"));
					cvo.setName(name);
					cvo.setNum(rs.getInt("num"));					
					cvo.setCount(rs.getInt("count"));		
					cvo.setRnum(rs.getInt("rnum"));
					cvo.setId(rs.getString("id"));
					cvo.setPrice(rs.getInt("price"));
					cvo.setBorrow(rs.getDate("borrow"));
					cvo.setTurn(rs.getDate("turn"));
					cvo.setResult(rs.getString("result"));
					list.add(cvo);
				}
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBManager.close(con, pstmt, rs); }   
		return list;
	}
	
	public ArrayList<Integer> selectNumCart(String id){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select cnum from cart where id=? order by cnum desc";
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
	
	public ArrayList<Integer> selectNumRentCart(String id){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select* from rentcart where id=? order by rnum desc";
		try {
			  con = DBManager.getConnection();
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, id);
			  rs = pstmt.executeQuery();
			  while (rs.next()) {
					list.add(rs.getInt("rnum"));
			  }
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBManager.close(con, pstmt, rs); }    
		return list;
	}
}
