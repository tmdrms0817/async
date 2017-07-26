package com.async.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.async.service.ListService;
import com.async.vo.ListVo;

@Controller
public class MainController {
	
	@Autowired
	private ListService service;

	@ResponseBody
	@RequestMapping( "/getlist" )
	public List<ListVo> getlist() {
		return service.getList();
	}
	
	@ResponseBody
	@RequestMapping( value="/delete", method=RequestMethod.POST )
	public Map<String, String> delete(
			@RequestParam( value="delete_num", required=true, defaultValue="0") Integer delete_num ) {
		
		String result = "fail";
		
		if(delete_num != 0){
			if(service.delete(delete_num)){
				result = "success";
			}
		}
		
		Map<String, String> map = new HashMap<String, String>(); 
		map.put( "result", result );
		
		
		return map;
	}
	
	
}
