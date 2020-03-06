package com.zhanglei.hgshop.service.impl;



import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanglei.hgshop.config.AdminProperties;
import com.zhanglei.hgshop.service.UserService;

/** 
* @ClassName: UserServiceImpl 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:28:22 
*/
@Service(interfaceClass = UserService.class,version = "1.0.0")
public class UserServiceImpl implements UserService{

	// 得到管理员的信息
	@Autowired
	private AdminProperties adminPro;
	
	@Override
	public boolean login(String userName, String passWord) {
		// TODO Auto-generated method stub
		//判断用户和密码是否与配置文件一致
		return (adminPro.getAdminName().equals(userName) && adminPro.getPassword().equals(passWord));
	}

}
