package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;
@Repository
public class GuestbookDao {
	
	
	@Autowired
	private SqlSession sqlSession;

	
	//리스트
	public List<GuestbookVo> guestbookList(){
		
		
		
	List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.selectList");
	
	System.out.println(guestbookList);
	
	return guestbookList;
	
	
	}
	
	public int Insert(GuestbookVo guestbookVo) {
		sqlSession.insert("guestbook.Insert",guestbookVo);
		return 1;
		
	}
	
	public int delete(GuestbookVo guestbookVo) {
		
		sqlSession.delete("guestbook.delete",guestbookVo);
		
		return 1;
		
		
		
		
	}
	
}