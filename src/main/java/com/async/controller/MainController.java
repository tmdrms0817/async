package com.async.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.async.service.ListService;
import com.async.vo.ListVo;

@Controller
public class MainController {
	
	@Autowired
	private ListService service;

	@ResponseBody
	@RequestMapping( "/getlist" )
	public List<ListVo> hello() {
		return service.getList();
	}
	
	
}
