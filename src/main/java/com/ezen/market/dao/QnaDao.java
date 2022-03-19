package com.ezen.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.market.config.DBMan;
import com.ezen.market.dto.QnaVo;

@Repository
public class QnaDao {
	
	@Autowired
	DBMan dbm;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void deleteQna(Integer num) {
		String sql = "delete from qna where num=?";
		try {			
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();							
		}catch (Exception e) {		e.printStackTrace();		}
		finally {			dbm.close(con, pstmt, rs);		}
	}
	
	public void updateQna(QnaVo qvo) {
		String sql = "update qna set title=?, content=? where num=?";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getTitle());
			pstmt.setString(2, qvo.getContent());
			pstmt.setInt(3,  qvo.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
		} finally {dbm.close(con, pstmt, rs);}
	}
	
	public QnaVo getQna(int num) {
		QnaVo qvo = null;
		String sql = "select * from qna where num=?";
		try {
			con = dbm.getConnection();
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
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}	
		return qvo;
	}
	
	public ArrayList<QnaVo> myList(String id){
		ArrayList<QnaVo> list  = new ArrayList<QnaVo>();
		String sql = "select * from qna where id=?  order by num desc";
		try {
			con = dbm.getConnection();
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
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}	
		return list;
	}
	
	public void insertQna(QnaVo qvo, String id) {
		String sql = "insert into qna (num, title, content, id, reply) values(qna_seq.nextval, ?, ?, ?, ?)";
		try {
			con = dbm.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getTitle());
		    pstmt.setString(2, qvo.getContent());
		    pstmt.setString(3, id);
		    pstmt.setString(4, "답변 예정");
		    pstmt.executeUpdate();  
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}
	}
	
	public ArrayList<QnaVo> listQna(String id){
		ArrayList<QnaVo> list  = new ArrayList<QnaVo>();
		String sql = "select * from qna  order by num desc";
		try {
			con = dbm.getConnection();
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
		} catch (Exception e) {e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs);}	
		return list;
	}

}
