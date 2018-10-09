package com.xms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xms.bean.Page;
import com.xms.entity.User;
import com.xms.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private AdminService as;
	@Resource
	private Page pages;
	
	@RequestMapping("AdminList.do")
	public Map<String,Object> AdminList(int page){
		System.out.println(page);
		List<User> list = as.findByPage(page);
		int totalPage = as.getTotalPages(pages.getPageSize());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("totalPage", totalPage);
		return map;
	}
	
	@RequestMapping("add.do")
	public String addAdmin(){
		
		return null;
	}
	@RequestMapping("update.do")
	public String updateAdmin(){
		
		return null;
	}
	@RequestMapping("delete.do")
	public String delAdmin(){
		
		return null;
	}
	
}
