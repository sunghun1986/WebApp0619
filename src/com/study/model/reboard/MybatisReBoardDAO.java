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
	
	public int insert(ReBoard reboard) {
		int result = 0;
		SqlSession sqlSession = manager.getSqlSession();//가져오기
		result = sqlSession.insert("test.insert", reboard);
		sqlSession.commit();//DML만...
		manager.closeSession(sqlSession);//닫기
		return result;
	}
	
	public ReBoard select(int reboard_id) {
		ReBoard reboard=null;
		
		SqlSession sqlSession = manager.getSqlSession();//가져오기
		reboard = (ReBoard)sqlSession.selectOne("test.select", reboard_id);
		manager.closeSession(sqlSession);//닫기		
		return reboard;
	}
	//주의 아래의 쿼리는
	public void updateRank(ReBoard reboard) {
		SqlSession sqlSession = manager.getSqlSession();//가져오기
		sqlSession.update("test.updateRank", reboard);
		sqlSession.commit();
		manager.closeSession(sqlSession);//닫기		
	}
	
	//답변등록 메서드
	public int reply(ReBoard reboard) {
		int result = 0;
		SqlSession sqlSession = manager.getSqlSession();//가져오기
		result = sqlSession.insert("test.reply", reboard);
		sqlSession.commit();
		manager.closeSession(sqlSession);//닫기		
		return result;
	}	
	
/*		
		public int update(ReBoard reboard) {
			
			return result;
		}
		
		public int delete(int reboard_id) {
			
			return result;
		}
	*/

}

















