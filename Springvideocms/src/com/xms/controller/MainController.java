package com.xms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping("toVideos.do")
	public String toVideos(){
		
		return "jsp/videos";
	}
	@RequestMapping("userAdmin.do")
	public String userAdmin(){
		
		return "jsp/userAdmin";
	}
	@RequestMapping("roleList.do")
	public String roleList(){
		
		return "jsp/roleList";
	}
	@RequestMapping("userVip.do")
	public String userVip(){
		
		return "jsp/userVip";
	}
	@RequestMapping("videosList.do")
	public String videosList(){
		
		return "jsp/videoList";
	}
	@RequestMapping("videosUpload.do")
	public String videosUpload(){
		
		return "jsp/videosUpload";
	}
	
	
	
}
