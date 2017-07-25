package com.async.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.async.vo.ListVo;

@Repository
public class ListDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ListVo getList(){
		return sqlSession.selectOne("list.getList");
	}
}
