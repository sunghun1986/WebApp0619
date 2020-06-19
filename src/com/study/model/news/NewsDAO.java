package com.study.model.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.commons.db.DBManager;

//오직 데이터베이스 관련한 CURD만을 수행하는 객체를 DAO라고 한다
//기술 및 플랫폼 중립적이어야 한다
public class NewsDAO {
	
	DBManager manager = DBManager.getInstance();
	
	//뉴스 등록
	public int insert(News news) {
		int result=0;
		
		Connection con = null;
		PreparedStatement pstmt=null;
		String sql="insert into news(news_id,title,writer,content)";
		sql+=" values(seq_news.nextval,?,?,?)";
		
		con = manager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,news.getTitle());
			pstmt.setString(2, news.getWriter());
			pstmt.setString(3, news.getContent());
			
			//쿼리수행
			result = pstmt.executeUpdate();//쿼리수행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con,pstmt);
		}
		return result;		
	}
	
	//목록 - CRUD중 Read에 해당, (모든 글 가져오기)
	public List selectAll() {		
		ArrayList list = new ArrayList();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql = "select * from news order by news_id desc";
		con = manager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				News news = new News();
				news.setNews_id(rs.getInt("news_id"));
				news.setTitle(rs.getString("title"));
				news.setWriter(rs.getString("writer"));
				news.setContent(rs.getString("content"));
				news.setRegdate(rs.getString("regdate"));
				news.setHit(rs.getInt("hit"));
				list.add(news);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con,pstmt,rs);
		}		
		return list;
	}
	
	//글 한건 가져오기
	public News select(int news_id) {
		ArrayList list = new ArrayList();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		News news = null;
		
		String sql = "select * from news where news_id=?";
		con = manager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, news_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				news = new News();
				news.setNews_id(rs.getInt("news_id"));
				news.setTitle(rs.getString("title"));
				news.setWriter(rs.getString("writer"));
				news.setContent(rs.getString("content"));
				news.setRegdate(rs.getString("regdate"));
				news.setHit(rs.getInt("hit"));
				list.add(news);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con,pstmt,rs);
		}
			
		return news;
	}
	
}








