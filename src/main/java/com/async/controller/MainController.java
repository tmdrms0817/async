package com.async.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.async.service.FileUploadService;
import com.async.service.ListService;
import com.async.vo.ListVo;

@Controller
public class MainController {
	
	@Autowired
	private ListService service;
	private FileUploadService fileUploadService;

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
	
	
	@ResponseBody
	@RequestMapping( value="/insert", method=RequestMethod.POST )
	public Map<String, String> insert( @ModelAttribute ListVo listVo ) {
           
		String result = "fail";
		
		if(listVo != null){
			if(service.insert(listVo)){
				result = "success";
			}
		}
		
		Map<String, String> map = new HashMap<String, String>(); 
		map.put( "result", result );
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping( value="/upfile", method=RequestMethod.POST )
	public Map<String, String> upfile(@RequestParam( value="file1" ) MultipartFile file1 ) {
		
		String result = "fail";
		
		if(file1 != null){
			result = fileUploadService.restore( file1 );
		}
		
		Map<String, String> map = new HashMap<String, String>(); 
		map.put( "result", result );
		
		return map;
	}
	
	
}
