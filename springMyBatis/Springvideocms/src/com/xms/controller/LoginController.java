package com.xms.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xms.bean.ResponseInfo;
import com.xms.entity.Admin;
import com.xms.service.LoginService;
import com.xms.util.ImgUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
	private LoginService logService;
	@Resource
	private ResponseInfo body;
	
	@RequestMapping("toLogin.do")
	public String toLogin(){
		return "jsp/login";
	}
	
	@RequestMapping("getCodeImg.do")
	public void getCodeImg(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setHeader("Cache-Control", "no-cache");
		Map<String,BufferedImage> map = logService.getImage();
		String rightCode = map.keySet().iterator().next();
		request.getSession().setAttribute("rightCode", rightCode);
		BufferedImage image = map.get(rightCode);
		response.setContentType("image/jpeg");
		
		ImageIO.write(image, "jpeg", response.getOutputStream());
		
	}
	@RequestMapping("checkUserCode.do")
	@ResponseBody
	public ResponseInfo checkUserCode(HttpServletRequest request,String userCode){
		String rightCode = (String)request.getSession().getAttribute("rightCode");
		
		if(!rightCode.equalsIgnoreCase(userCode)){
			body.setCode("01");
			body.setMsg("验证码错误");
			body.setObj(false);
		}else{
			body.setCode("000");
			body.setMsg("验证码正确");
			body.setObj(true);
		}
		return body;
	}
	
	@RequestMapping("login.do")
	public String login(String username,String password,
			HttpServletRequest request) throws Exception{
		Admin admin = logService.checkLogin(username, password);
		request.getSession().setAttribute("admin", admin);
		
		return "redirect:/main/toVideos.do";
	}
	
	
}
