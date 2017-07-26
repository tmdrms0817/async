package com.async.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.async.vo.ListVo;

@Repository
public class ListDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ListVo> getList(){
		return sqlSession.selectList("list.getList");
	}
	
	public int delete(int delete_num){
		return sqlSession.delete("list.delete", delete_num);
	}
}
