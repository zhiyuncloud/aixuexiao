package com.aixuexiao.web.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class LoginController {
	
	private static final String USERNAME = "zhiyun";
	private static final String PASSWORD = "123456";
	
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(String username,String password,HttpServletRequest request){
		ModelAndView mv=new ModelAndView("");
		if( USERNAME.equals(username)&& PASSWORD.equals(password)){
			request.getSession().setAttribute("user", username);
			mv.setViewName("redirect:/manager/students");
		}else{
			mv.setViewName("forward:/");
			mv.addObject("username",username);
			mv.addObject("message", "username or password error ");
		}
		return mv;
	}
	
	
	@RequestMapping(value="/loginout",method=RequestMethod.POST)
	public ModelAndView loginOut(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/");
		request.getSession().removeAttribute("user");
		return mv;
	}

}
