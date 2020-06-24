package com.study.model.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.commons.db.DBManager;

public class StoreDAO {
	
	DBManager manager = DBManager.getInstance();
	
	//모두 가져오기 Read
	public List selectAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List list = new ArrayList();
		
		String sql = "select * from store";
		
		con = manager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Store store = new Store();
				store.setStore_id(rs.getInt("store_id"));
				store.setName(rs.getString("name"));
				store.setAddr(rs.getString("addr"));
				store.setLati(rs.getDouble("lati"));
				store.setLongi(rs.getDouble("longi"));
				store.setImg(rs.getString("img"));
				store.setMemo(rs.getString("memo"));
				
				list.add(store);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con, pstmt, rs);
		}		
		return list;
	}
	
	//한건만 가져오기 Read
	public Store select(int store_id) {			
		Store store = null;		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		String sql = "select * from store where store_id=?";
		
		con = manager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, store_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				store = new Store();
				store.setStore_id(rs.getInt("store_id"));
				store.setName(rs.getString("name"));
				store.setAddr(rs.getString("addr"));
				store.setLati(rs.getDouble("lati"));
				store.setLongi(rs.getDouble("longi"));
				store.setImg(rs.getString("img"));
				
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con, pstmt, rs);
		}		
		return store;
	}
	
	//등록하기 Create
	public int insert(Store store) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		con = manager.getConnection();
		
		String sql="insert into store(store_id,name,addr,lati,longi,img,memo)";
		sql+=" values(seq_store.nextval,?,?,?,?,?,?)";
		
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, store.getName());
			pstmt.setString(2, store.getAddr());
			pstmt.setDouble(3, store.getLati());
			pstmt.setDouble(4, store.getLongi());
			pstmt.setString(5, store.getImg());
			pstmt.setString(6, store.getMemo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con, pstmt);
		}
		
		return result;
	}
	
	//수정하기 Update
	public int update(Store store) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;		
		
		String sql="update store set name=?,addr=?,lati=?,longi=?";
		sql+=",img=?,memo=? where store_id=?";
		
		con = manager.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, store.getName());
			pstmt.setString(2, store.getAddr());
			pstmt.setDouble(3, store.getLati());
			pstmt.setDouble(4, store.getLongi());
			pstmt.setString(5, store.getImg());
			pstmt.setString(6, store.getMemo());
			pstmt.setInt(7, store.getStore_id());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con, pstmt);
		}		
		return result;
	}
	
	//삭제하기 Delete
	public int delete(int store_id) {		
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;		
		
		String sql="delete from store where store_id=?";		
		
		con = manager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, store_id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			manager.freeConnection(con, pstmt);
		}
		
		return result;
	}
}













