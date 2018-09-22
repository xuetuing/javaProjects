package com.xms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xms.bean.Page;
import com.xms.entity.User;
import com.xms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService us;
	@Resource
	private Page pages;
 	
	@RequestMapping("userList.do")
	@ResponseBody
	public Map<String,Object> userList(int page) throws Exception{
		
		System.out.println(page);
		List<User> list = us.findByPage(page);
		int totalPage = us.getTotalPages(pages.getPageSize());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("totalPage", totalPage);
		return map;
	}
	
}
