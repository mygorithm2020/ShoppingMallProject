package com.ezenmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenmarket.controller.util.DBManager;
import com.ezenmarket.dto.CartVo;
import com.ezenmarket.dto.OrderVo;
import com.ezenmarket.dto.ProductVo;
import com.ezenmarket.dto.RentVo;
import com.ezenmarket.dto.RentcartVo;


public class OrderRentDao {
	private OrderRentDao() {}
	private static OrderRentDao instance = new OrderRentDao();
	public static OrderRentDao getInstance() { return instance;}
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public RentVo getRentDetail(String rseq) {
		RentVo rvo = null;
		String sql = "select * from rent where rnum=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(rseq));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rvo = new RentVo();
				rvo.setBorrow(rs.getDate("borrow"));
				rvo.setTurn(rs.getDate("turn"));
				rvo.setLocationname(rs.getString("locationname"));
				rvo.setCount(rs.getInt("count"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);}
		return rvo;
	}
	
	
	
	
	
	public void deleteRent(Integer num) {
		String sql = "delete from rent where num=?";
		try {			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();							
		}catch (SQLException e) {		e.printStackTrace();		}
		finally {			DBManager.close(con, pstmt, rs);		}	
	}
	
	public void rentWrite(RentVo rvo) {
		String sql ="insert into rent(num, name, rnum, id, borrow, turn, locationname, price, count)" + 
				"values(rent_seq.nextval, ?,?, ?,?,?,?,?,1)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rvo.getName());      
		    pstmt.setInt(2, rvo.getRnum());
		    pstmt.setString(3, rvo.getId());
		    pstmt.setDate(4, rvo.getBorrow());		    
		    pstmt.setDate(5, rvo.getTurn());
		    pstmt.setString(6, rvo.getLocationname());
		    pstmt.setInt(7, rvo.getPrice());
		    pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);}	
	}
	
	
	
	
	
	public ArrayList<OrderVo> buyList(String id){
		ArrayList<OrderVo> list = new ArrayList<OrderVo>();
		String sql = "select * from order where id=? order by num desc";
		try {
		      con = DBManager.getConnection();
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setString(1, id);
		      rs = pstmt.executeQuery();
				while(rs.next()) {
					OrderVo ovo = new OrderVo();			
					ovo.setIndate(rs.getTimestamp("indate"));
					ovo.setNum(rs.getInt("num"));
					ovo.setOnum(rs.getInt("onum"));
					ovo.setCount(rs.getInt("count"));		
					ovo.setPrice(rs.getInt("price"));
					ovo.setName(rs.getString("name"));
					list.add(ovo);
				}
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBManager.close(con, pstmt, rs); }   
		return list;
	}
	
	public ArrayList<RentVo> rentList(String id){
		ArrayList<RentVo> list = new ArrayList<RentVo>();
		String sql = "select * from rent where id=? order by num desc";
		try {
		      con = DBManager.getConnection();
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setString(1, id);
		      rs = pstmt.executeQuery();
				while(rs.next()) {
					RentVo ovo = new RentVo();			
					ovo.setBorrow(rs.getDate("borrow"));
					ovo.setTurn(rs.getDate("turn"));
					ovo.setNum(rs.getInt("num"));
					ovo.setRnum(rs.getInt("rnum"));
					ovo.setCount(rs.getInt("count"));		
					ovo.setPrice(rs.getInt("price"));
					ovo.setName(rs.getString("name"));
					ovo.setLocationname(rs.getString("locationname"));
					list.add(ovo);
				}
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBManager.close(con, pstmt, rs); }   
		return list;
	}
	
	

}
