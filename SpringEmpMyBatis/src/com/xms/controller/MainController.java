package com.xms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xms.entity.Emp;
import com.xms.service.EmpService;
import com.xms.service.UserService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private UserService us;
	
	@Resource
	private EmpService es;
	
//	@RequestMapping("list.do")
//	public ModelAndView list(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		List<Emp> list = us.findAllEmp();
//		map.put("empList",list);
//		
//		return new ModelAndView("jsp/emplist",map);
//	}
	@RequestMapping("list.do")
	public String list(Model model){
		List<Emp> list = es.findAllEmp();
		model.addAttribute("empList", list);
		return "jsp/emplist";
	}
	
	@RequestMapping("toDirect.do")
	public String toDirect(){
		
		return "jsp/direct";
	}
	@RequestMapping("delete.do")
	public String delete(int id){
		es.delete(id);
		return "redirect:/main/list.do";
	}
	
	
}
