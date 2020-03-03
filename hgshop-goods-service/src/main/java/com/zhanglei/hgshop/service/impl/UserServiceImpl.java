package com.zhanglei.hgshop.service.impl;



import org.apache.dubbo.config.annotation.Service;

import com.zhanglei.hgshop.service.UserService;

/** 
* @ClassName: UserServiceImpl 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:28:22 
*/
@Service(interfaceClass = UserService.class,version = "1.0.0")
public class UserServiceImpl implements UserService{

	@Override
	public boolean login(String userName, String passWord) {
		// TODO Auto-generated method stub
		return "admin".equals(userName) && "admin".equals(passWord);
	}

}
