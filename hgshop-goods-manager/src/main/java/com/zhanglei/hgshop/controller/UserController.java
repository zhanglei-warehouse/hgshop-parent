package com.zhanglei.hgshop.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhanglei.hgshop.service.UserService;

/** 
* @ClassName: UserController 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:35:30 
*/
@Controller
@RequestMapping
public class UserController {

	@Reference(timeout=2000,version="1.0.0")
	private UserService userService;
	
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String name,String password ) {
		if(userService.login(name, password))
			return "redirect:/";
		else {
			return "login";
		}
	}
}
