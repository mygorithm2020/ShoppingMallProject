package com.ezen.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.market.config.DBMan;
import com.ezen.market.dto.LocationVo;
import com.ezen.market.dto.ProductVo;
import com.ezen.market.dto.RentVo;




@Repository
public class ProdDao {
	
	@Autowired
	DBMan dbm;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<ProductVo> productSearchList(String pname,String gu){
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		String sql = "select * from product where content like ?";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+pname+"%");
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				ProductVo pvo = new ProductVo();
				pvo.setNum(rs.getInt("num"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setImg(rs.getString("img"));
				pvo.setLocationname(rs.getString("locationname"));
				pvo.setTitle(rs.getString("title"));
				list.add(pvo);
			}
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
		
		return list;
	}
	
	public void updateProduct(ProductVo pvo) {
		String sql = "update product set category=?, title=?, name=?, price=?, "
				+ "content=?, img=?,locationname=?  where num=?";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pvo.getCategory());
			pstmt.setString(2, pvo.getTitle());
			pstmt.setString(3, pvo.getName());
			pstmt.setInt(4, pvo.getPrice());
			pstmt.setString(5, pvo.getContent());
			pstmt.setString(6, pvo.getImg());
			pstmt.setString(7, pvo.getLocationname());
			pstmt.setInt(8, pvo.getNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
	}
	
	public ProductVo getProduct(String pseq) {
		ProductVo pvo = null;
		String sql = "select * from product where num=?";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(pseq));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pvo = new ProductVo();
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
			}
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
		return pvo;
	}
	
	public ProductVo subListProduct(int num) {
		ProductVo pvo = new ProductVo();
		String sql = "select * from product where num=? order by num desc";
		try {
		      con = dbm.getConnection();
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setInt(1, num);
		      rs = pstmt.executeQuery();		      
				while(rs.next()) {											
						pvo.setIndate(rs.getTimestamp("indate"));
						pvo.setNum(rs.getInt("num"));
						pvo.setName(rs.getString("name"));
						pvo.setPrice(rs.getInt("price"));
						pvo.setCount(rs.getInt("count"));
						pvo.setClassify(rs.getString("classify"));								
				}
		} catch (Exception e) { e.printStackTrace();
	    } finally { dbm.close(con, pstmt, rs); }   
		return pvo;
	}
	
	public void deleteRent(int k){
		String sql = "delete from rent where num=?";
		try {			
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, k);
			pstmt.executeUpdate();							
		}catch (Exception e) {		e.printStackTrace();		}
		finally {			dbm.close(con, pstmt, rs);		}
	}
	
	public ArrayList<RentVo> rentList(String id){
		ArrayList<RentVo> list = new ArrayList<RentVo>();
		String sql = "select * from rent where id=? order by num desc";
		try {
		      con = dbm.getConnection();
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
	    } finally { dbm.close(con, pstmt, rs); }   
		return list;
	}
	
	public ArrayList<ProductVo> listProduct(String id){
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		String sql = "select * from product where id=? order by num desc";
		try {
		      con = dbm.getConnection();
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setString(1, id);
		      rs = pstmt.executeQuery();
				while(rs.next()) {
					ProductVo pvo = new ProductVo();						
					pvo.setIndate(rs.getTimestamp("indate"));
					pvo.setNum(rs.getInt("num"));
					pvo.setName(rs.getString("name"));
					pvo.setPrice(rs.getInt("price"));
					pvo.setCount(rs.getInt("count"));
					pvo.setClassify(rs.getString("classify"));						
					list.add(pvo);
				}
		} catch (Exception e) { e.printStackTrace();
	    } finally { dbm.close(con, pstmt, rs); }   
		return list;
	}
	
	public void insertProduct(ProductVo pvo) {
		String sql = "insert into product(num, id, title, name,img, locationname, content, category, classify, price)"
				+ "values(product_seq.nextval,?,?,?,?,?,?,?,'1',?)";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getId());      
		    pstmt.setString(2, pvo.getTitle());
		    pstmt.setString(3, pvo.getName());
		    
		    pstmt.setString(4, pvo.getImg());
		    pstmt.setString(5, pvo.getLocationname());
		    pstmt.setString(6, pvo.getContent());
		    pstmt.setInt(7, pvo.getCategory());
		    pstmt.setInt(8, pvo.getPrice());
		    pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
	}
	
	public ArrayList<LocationVo> locationList(){
		ArrayList<LocationVo> list = new ArrayList<LocationVo>();
		String sql = "select * from location";
		try {
		      con = dbm.getConnection();
		      pstmt = con.prepareStatement(sql); 
		      rs = pstmt.executeQuery();
				while(rs.next()) {
					LocationVo lvo = new LocationVo();						
					lvo.setNum(rs.getInt("num"));
					lvo.setName(rs.getString("name"));
					lvo.setCity(rs.getString("city"));
					lvo.setGu(rs.getString("gu"));
					lvo.setDong(rs.getString("dong"));
					list.add(lvo);
				}
		} catch (Exception e) { e.printStackTrace();
	    } finally { dbm.close(con, pstmt, rs); }   
		return list;
	}
	
	public ArrayList<ProductVo> listNewProduct(){
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		String sql = "select * from new_pro_view";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo pvo = new ProductVo();
				pvo.setNum(rs.getInt("num"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setImg(rs.getString("img"));
				pvo.setLocationname(rs.getString("locationname"));
				pvo.setTitle(rs.getString("title"));
				list.add(pvo);
			}
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
		return list;
	}
	
	public ArrayList<ProductVo> listBestProduct(){
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		String sql = "select * from best_pro_view";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo pvo = new ProductVo();
				pvo.setNum(rs.getInt("num"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setImg(rs.getString("img"));
				pvo.setLocationname(rs.getString("locationname"));
				pvo.setTitle(rs.getString("title"));
				list.add(pvo);
			}
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
		return list;
	}
	
	

}
