package com.ezen.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.market.config.DBMan;
import com.ezen.market.dto.RentVo;
import com.ezen.market.dto.RentcartVo;

@Repository
public class MypageDao {
	
	@Autowired
	DBMan dbm;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void rentWrite(RentVo rvo) {
		String sql ="insert into rent(num, name, rnum, id, borrow, turn, locationname, price, count)" + 
				"values(rent_seq.nextval, ?,?, ?,?,?,?,?,1)";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rvo.getName());      
		    pstmt.setInt(2, rvo.getRnum());
		    pstmt.setString(3, rvo.getId());
		    pstmt.setDate(4, rvo.getBorrow());		    
		    pstmt.setDate(5, rvo.getTurn());
		    pstmt.setString(6, rvo.getLocationname());
		    pstmt.setInt(7, rvo.getPrice());
		    pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
	}
	
	public void insertRentCart(RentcartVo rcvo) {
		String sql ="insert into rentcart(num, rnum, id, count, borrow, turn, result, price) values (rentcart_seq.nextval, ?, ?, 1,?, ?, 0, ?)";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rcvo.getRnum());      
		    pstmt.setString(2, rcvo.getId());
		    pstmt.setDate(3, rcvo.getBorrow());
		    
		    pstmt.setDate(4, rcvo.getTurn());
		    pstmt.setInt(5, rcvo.getPrice());
		   
		    pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
	}
	
	public RentVo getRentDetail(String rseq) {
		RentVo rvo = null;
		String sql = "select * from rent where rnum=?";
		try {
			con = dbm.getConnection();
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
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
		return rvo;
	}
	
	public ArrayList<RentcartVo> listRentCart(String id, int num, String name){
		ArrayList<RentcartVo> list = new ArrayList<RentcartVo>();
		String sql = "select * from rentcart where id=? and rnum=? order by num desc";
		try {
		      con = dbm.getConnection();
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
	    } finally { dbm.close(con, pstmt, rs); }   
		return list;
	}
	
	public ArrayList<Integer> selectNumRentCart(String id){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select* from rentcart where id=? order by rnum desc";
		try {
			  con = dbm.getConnection();
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, id);
			  rs = pstmt.executeQuery();
			  while (rs.next()) {
					list.add(rs.getInt("rnum"));
			  }
		} catch (Exception e) { e.printStackTrace();
	    } finally { dbm.close(con, pstmt, rs); }    
		return list;
	}

}
