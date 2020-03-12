package com.zhanglei.hgshop.service;

import com.zhanglei.hgshop.pojo.User;

/** 
* @ClassName: WebUserService 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月11日 下午7:37:03 
*/
public interface WebUserService {

	/**
	 * 用户登录
	 * @param username
	 * @param pwd
	 * @return
	 */
	User login(String username,String pwd);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	User register(User user);
}
