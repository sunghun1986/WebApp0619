package com.study.async;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.commons.db.DBManager;

public class HotPlaceDAO {
	
	DBManager manager = DBManager.getInstance();
	
	public int insert(HotPlace hp) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into hotplace(hotplace_id,name,tel,addr,food)";
		sql+=" values(seq_hotplace.nextval,?,?,?,?)";
		
		con = manager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hp.getName());
			pstmt.setString(2, hp.getTel());
			pstmt.setString(3, hp.getAddr());
			pstmt.setString(4, hp.getFood());
			
			result = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con, pstmt);
		}
		
		return result;
	}
	
	public List selectAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HotPlace> list = new ArrayList();
		
		con = manager.getConnection();
		String sql = "select * from hotplace order by hotplace_id desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HotPlace hp = new HotPlace();
				hp.setHotplace_id(rs.getInt("hotplace_id"));
				hp.setName(rs.getString("name"));
				hp.setTel(rs.getString("tel"));
				hp.setAddr(rs.getString("addr"));
				hp.setFood(rs.getString("food"));
				
				list.add(hp);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con, pstmt, rs);
		}		
		return list;		
	}

}










