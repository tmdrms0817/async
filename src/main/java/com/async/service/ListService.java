package com.async.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.async.dao.ListDao;
import com.async.vo.ListVo;

@Service
public class ListService {

	@Autowired
	private ListDao listDao;

	public List<ListVo> getList() {
		System.out.println("여길 탐~~~~~~~~~~~~~~~~~");
		System.out.println(listDao.getList());
		return listDao.getList();
	}

}
