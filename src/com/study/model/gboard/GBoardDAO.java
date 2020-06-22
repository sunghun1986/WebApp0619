package com.study.model.gboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.commons.db.DBManager;

public class GBoardDAO {
	
	DBManager dbManager= DBManager.getInstance();
	
	public int insert(GBoard gboard) {
		
		Connection con=null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "insert into gboard(gboard_id,title,writer,content,filename)";
		sql+=" values(seq_gboard.nextval,?,?,?,?)";
		
		con = dbManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gboard.getTitle());
			pstmt.setString(2, gboard.getWriter());
			pstmt.setString(3, gboard.getContent());
			pstmt.setString(4, gboard.getFilename());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.freeConnection(con, pstmt);
		}		
		return result;
	}
	
	//모든 글 가져오기
	public List selectAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		
		con = dbManager.getConnection();
		String sql = "select * from gboard order by gboard_id desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//rs를 List로 옮겨심자
			while(rs.next()) {
				GBoard gboard = new GBoard();
				
				//텅빈 VO에 rs정보를 옮겨담는다
				gboard.setGboard_id(rs.getInt("gboard_id"));
				gboard.setTitle(rs.getString("title"));
				gboard.setWriter(rs.getString("writer"));
				gboard.setContent(rs.getString("content"));
				gboard.setRegdate(rs.getString("regdate"));
				gboard.setHit(rs.getInt("hit"));
				gboard.setFilename(rs.getString("filename"));
				
				list.add(gboard);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.freeConnection(con,pstmt,rs);
		}
		
		
		return list;
	}
	
}















