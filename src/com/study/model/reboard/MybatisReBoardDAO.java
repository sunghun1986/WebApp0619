package com.study.model.reboard;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.MybatisConfigManager;

public class MybatisReBoardDAO {	
	
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
	
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = manager.getSqlSession();//가져오기
		list = sqlSession.selectList("test.selectAll");
		manager.closeSession(sqlSession);//닫기
		return list;
	}
	
/*
	// 한건만 선택할때는 아이디 넘버만 선택하면됨.
	public ReBoard select(int reboard_id) {

		return reboard;
	}
	
	//답변의 경우에는=기존자리확보 + 글 등록
		//답변이 들어갈 자리 확보하는 메서드!
		public void updateRank(ReBoard reboard) {
			
		}
		
		//답변등록 메서드
		public int reply(ReBoard reboard) {			
			
			return result;
		}
		
		public int insert(ReBoard reboard) {
		
			return result;
		}
		
		public int update(ReBoard reboard) {
			
			return result;
		}
		
		public int delete(int reboard_id) {
			
			return result;
		}
	*/

}

















