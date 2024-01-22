package com.ezenmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.ezenmarket.controller.util.DBManager;
import com.ezenmarket.dto.Paging;
import com.ezenmarket.dto.QnaVo;




public class QnaDao {
	private QnaDao() {}
	private static QnaDao instance = new QnaDao();
	public static QnaDao getInstance() { return instance;}
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<QnaVo> listQna(String id){
		ArrayList<QnaVo> list  = new ArrayList<QnaVo>();
		String sql = "select * from qna  order by num desc";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()) {
		    	QnaVo qvo = new QnaVo();
		    	qvo.setNum(rs.getInt("num"));
		    	qvo.setTitle(rs.getString("title"));
		    	qvo.setContent(rs.getString("content"));
		    	qvo.setId(rs.getString("id"));
		    	qvo.setIndate(rs.getTimestamp("indate"));
		    	qvo.setReply(rs.getString("reply"));
		    	qvo.setResult(rs.getString("result"));		    	    	
		    	list.add(qvo);
		    }
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);}	
		return list;
	}
	
	public ArrayList<QnaVo> myList(String id){
		ArrayList<QnaVo> list  = new ArrayList<QnaVo>();
		String sql = "select * from qna where id=?  order by num desc";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
		    	QnaVo qvo = new QnaVo();
		    	qvo.setNum(rs.getInt("num"));
		    	qvo.setTitle(rs.getString("title"));
		    	qvo.setContent(rs.getString("content"));
		    	qvo.setId(rs.getString("id"));
		    	qvo.setIndate(rs.getTimestamp("indate"));
		    	qvo.setReply(rs.getString("reply"));
		    	qvo.setResult(rs.getString("result"));		    	    	
		    	list.add(qvo);
		    }
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);}	
		return list;
	}
	
	public void updateQna(QnaVo qvo) {
		String sql = "update qna set title=?, content=? where num=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getTitle());
			pstmt.setString(2, qvo.getContent());
			pstmt.setInt(3,  qvo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {DBManager.close(con, pstmt, rs);}
	}
	
	
	public int getAllcount() {
		int count = 0;
		String sql = "select Count(*) as count from qna";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		} catch (SQLException e) { e.printStackTrace();
		} finally {DBManager.close(con, pstmt, rs);
		}
		return count;
	}
	
	public ArrayList<QnaVo> listAllQna(Paging paging){
		ArrayList<QnaVo> list = new ArrayList<QnaVo> ();
	    String sql = "select * from "
				+ " ( select * from "
                + " ( select rownum as row_num, qna.* from qna  order by qseq desc )"
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
	
	
	public void insertQna(QnaVo qvo, String id) {
		String sql = "insert into qna (num, title, content, id, reply) values(qna_seq.nextval, ?, ?, ?, ?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getTitle());
		    pstmt.setString(2, qvo.getContent());
		    pstmt.setString(3, id);
		    pstmt.setString(4, "답변 예정");
		    pstmt.executeUpdate();  
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);}	
	}
	
	public QnaVo getQna(int num) {
		QnaVo qvo = null;
		String sql = "select * from qna where num=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qvo = new QnaVo();
				qvo.setNum(rs.getInt("num"));
				qvo.setTitle(rs.getString("title"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setResult(rs.getString("result"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);}	
		return qvo;
	}
	
	public void deleteQna(Integer num) {
		String sql = "delete from qna where num=?";
		try {			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();							
		}catch (SQLException e) {		e.printStackTrace();		}
		finally {			DBManager.close(con, pstmt, rs);		}	
	}
	
		
	
	
	

}
