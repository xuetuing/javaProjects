package com.xms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping("toIndex.do")
	public String toIndex(){
		return "index";
	}
	@RequestMapping("toDirect.do")
	public String toDirect(){
		
		return "direct";
	}
}
