package com.zhanglei.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhanglei.hgshop.comm.HgShopConstant;
import com.zhanglei.hgshop.pojo.User;
import com.zhanglei.hgshop.service.WebUserService;

/** 
* @ClassName: UserController 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月11日 下午8:19:22 
*/
@Controller
@RequestMapping("user")
public class UserController {

	@Reference(timeout = 1044,version = "1.0.0")
	private WebUserService userService;
	/**
	 * 进入登陆的页面
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "user/login";
	}
	
	/**
	 * 接收用户登录的数据
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request,
			String username,String password) {
		// 登录
		User user = userService.login(username, password);
		if(user == null) {
			// 保存页面数据
			///  。。。。  todo
			request.setAttribute("error", "用户名密码错误");
			return "user/login";
		}
		// 写入session
		request.getSession().setAttribute(HgShopConstant.USEKEY, user);
		return "redirect:/user/home";
	}
	
	/**
	 * 进入注册的页面
	 * @return
	 */
	@RequestMapping("toRegister")
	public String toRegister() {
		return "user/register";
	}
	
	/**
	 * 接收用户注册提交的数据
	 * @param request
	 * @return
	 */
	@RequestMapping("register")
	public String login(HttpServletRequest request,User user) {
		// 注册
		User registerUser = userService.register(user);
		if(registerUser == null) {
			request.setAttribute("error", "注册失败");
			return "user/register";
		}
		//注册成功 跳转到登陆页面
		return "redirect:toLogin";
	}
	
	/**
	 * 进入个人中心
	 * @param request
	 * @return
	 */
	public String home(HttpServletRequest request) {
		return "user/home";
		
	}
}
