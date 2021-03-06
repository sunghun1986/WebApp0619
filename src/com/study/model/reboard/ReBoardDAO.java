package com.study.model.reboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.commons.db.PoolManager;

public class ReBoardDAO {

	PoolManager manager = PoolManager.getInstance();

	public List selectAll() {
		ArrayList list = new ArrayList();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = manager.getConnection();

		String sql = "select * from reboard order by team desc , rank asc";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReBoard reboard = new ReBoard();
				reboard.setReboard_id(rs.getInt("reboard_id"));
				reboard.setTitle(rs.getString("title"));
				reboard.setWriter(rs.getString("writer"));
				reboard.setContent(rs.getString("content"));
				reboard.setRegdate(rs.getString("regdate"));
				reboard.setHit(rs.getInt("hit"));
				reboard.setTeam(rs.getInt("team"));
				reboard.setRank(rs.getInt("rank"));
				reboard.setDepth(rs.getInt("depth"));
				list.add(reboard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	// 한건만 선택할때는 아이디 넘버만 선택하면됨.
	public ReBoard select(int reboard_id) {

		ReBoard reboard = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from reboard where reboard_id=?";
		con = manager.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reboard_id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				reboard = new ReBoard();
				reboard.setReboard_id(rs.getInt("reboard_id"));
				reboard.setTitle(rs.getString("title"));
				reboard.setWriter(rs.getString("writer"));
				reboard.setContent(rs.getString("content"));
				reboard.setRegdate(rs.getString("regdate"));
				reboard.setHit(rs.getInt("hit"));
				reboard.setTeam(rs.getInt("team"));
				reboard.setRank(rs.getInt("rank"));
				reboard.setDepth(rs.getInt("depth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.freeConnection(con, pstmt, rs);
		}
		return reboard;
	}
	
	//답변의 경우에는=기존자리확보 + 글 등록
		//답변이 들어갈 자리 확보하는 메서드!
		public void updateRank(ReBoard reboard) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			//주의 아래의 쿼리는
			String sql = "update reboard set rank=rank+1";
			sql += "where team=? and rank >? ";
			con = manager.getConnection();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, reboard.getTeam());
				pstmt.setInt(2, reboard.getRank());
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				manager.freeConnection(con, pstmt);
			}			
		}
		
		//답변등록 메서드
		public int reply(ReBoard reboard) {			
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			String sql = "insert into reboard(reboard_id,title,writer,content,team,rank,depth)";
			sql += " values(seq_reboard.nextval,?,?,?,?,?,?)";
			con = manager.getConnection();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, reboard.getTitle());
				pstmt.setString(2, reboard.getWriter());
				pstmt.setString(3, reboard.getContent());
				pstmt.setInt(4, reboard.getTeam());
				pstmt.setInt(5, reboard.getRank()+1);
				pstmt.setInt(6, reboard.getDepth()+1);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				manager.freeConnection(con, pstmt);
			}			
			return result;
		}
		
		public int insert(ReBoard reboard) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			String sql = "insert into reboard(reboard_id,title,writer,content,team)";
			sql += " values(seq_reboard.nextval,?,?,?,seq_reboard.nextval)";
			
			con = manager.getConnection();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, reboard.getTitle());
				pstmt.setString(2, reboard.getWriter());
				pstmt.setString(3, reboard.getContent());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				manager.freeConnection(con, pstmt);
			}			
			return result;
		}
		
		public int update(ReBoard reboard) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			String sql = "update reboard title=?,writer=?,content=?,regdate=?,team=?,rank=?,depth=?";
			
			con = manager.getConnection();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, reboard.getTitle());
				pstmt.setString(2, reboard.getWriter());
				pstmt.setString(3, reboard.getContent());
				pstmt.setString(4, reboard.getRegdate());
				pstmt.setInt(5, reboard.getTeam());
				pstmt.setInt(6, reboard.getRank());
				pstmt.setInt(7, reboard.getDepth());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				manager.freeConnection(con, pstmt);
			}			
			return result;
		}
		
		public int delete(int reboard_id) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			String sql = "delete from reboard where reboard_id=?";
			con = manager.getConnection();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, reboard_id);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {				
				e.printStackTrace();
			}finally {
				manager.freeConnection(con, pstmt);
			}			
			return result;
		}
	

}

















