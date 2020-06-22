package com.study.model.gboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}















