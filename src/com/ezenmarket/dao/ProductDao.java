package com.ezenmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenmarket.controller.util.DBManager;
import com.ezenmarket.dto.LocationVo;
import com.ezenmarket.dto.ProductVo;









public class ProductDao {

		private ProductDao() {}
		private static ProductDao instance = new ProductDao();
		public static ProductDao getInstance() { return instance;}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		public void deleteProduct(String pseq) {
			String sql = "delete product where num=?";
			try {
			      con = DBManager.getConnection();
			      pstmt = con.prepareStatement(sql); 
			      pstmt.setInt(1, Integer.parseInt(pseq));
			      pstmt.executeUpdate();
			} catch (Exception e) { e.printStackTrace();
		    } finally { DBManager.close(con, pstmt, rs); }   
		}
		
		
		
		public void updateProduct(ProductVo pvo) {
			String sql = "update product set category=?, title=?, name=?, price=?, "
									+ "content=?, img=?,locationname=?  where num=?";
			try {
				con = DBManager.getConnection();
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
			} catch (SQLException e) {e.printStackTrace();
			} finally { DBManager.close(con, pstmt, rs);}	
		}
		
		

		public void insertProduct(ProductVo pvo) {
			String sql = "insert into product(num, id, title, name,img, locationname, content, category, classify, price)"
					+ "values(product_seq.nextval,?,?,?,?,?,?,?,'1',?)";
			try {
				con = DBManager.getConnection();
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
			} catch (SQLException e) {e.printStackTrace();
			} finally { DBManager.close(con, pstmt, rs);}	
		}
		
		
		
		
		
		public ArrayList<LocationVo> locationList(){
			ArrayList<LocationVo> list = new ArrayList<LocationVo>();
			String sql = "select * from location";
			try {
			      con = DBManager.getConnection();
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
		    } finally { DBManager.close(con, pstmt, rs); }   
			return list;
		}
		
		
		
		
		
		public ArrayList<ProductVo> listProduct(String id){
			ArrayList<ProductVo> list = new ArrayList<ProductVo>();
			String sql = "select * from product where id=? order by num desc";
			try {
			      con = DBManager.getConnection();
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
		    } finally { DBManager.close(con, pstmt, rs); }   
			return list;
		}
		
		public ProductVo subListProduct(Integer num) {
			ProductVo pvo = new ProductVo();
			String sql = "select * from product where num=? order by num desc";
			try {
			      con = DBManager.getConnection();
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
		    } finally { DBManager.close(con, pstmt, rs); }   
			return pvo;
		}
		
		
		
		
		
		
		
		
		
		public ProductVo getProduct(String pseq) {
			ProductVo pvo = null;
			String sql = "select * from product where num=?";
			try {
				con = DBManager.getConnection();
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
			} catch (SQLException e) {e.printStackTrace();
			} finally { DBManager.close(con, pstmt, rs);}
			return pvo;
		}
		
		
		
		
		
		
		
		public ArrayList<ProductVo> productSearchList(String pname, String gu){
			ArrayList<ProductVo> list = new ArrayList<ProductVo>();
			String sql = "select * from product where content like ?";
			try {
				con = DBManager.getConnection();
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
			} catch (SQLException e) {e.printStackTrace();
			} finally { DBManager.close(con, pstmt, rs);}
			
			return list;
		}
		
		
		public ArrayList<ProductVo> listNewProduct(){
			ArrayList<ProductVo> list = new ArrayList<ProductVo>();
			String sql = "select * from new_pro_view";
			try {
				con = DBManager.getConnection();
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
			} catch (SQLException e) {e.printStackTrace();
			} finally { DBManager.close(con, pstmt, rs);}
			return list;
		}
		
		public ArrayList<ProductVo> listBestProduct(){
			ArrayList<ProductVo> list = new ArrayList<ProductVo>();
			String sql = "select * from best_pro_view";
			try {
				con = DBManager.getConnection();
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
			} catch (SQLException e) {e.printStackTrace();
			} finally { DBManager.close(con, pstmt, rs);}
			return list;
		}
}

