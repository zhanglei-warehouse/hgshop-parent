package com.zhanglei.hgshop.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanglei.hgshop.dao.UserDao;
import com.zhanglei.hgshop.pojo.User;
import com.zhanglei.hgshop.service.WebUserService;

/** 
* @ClassName: WebUserServiceIMpl 
* @Description: 用户服务 商城用户
* @author: lei zhang
* @date: 2020年3月11日 下午7:44:54 
*/
@Service(interfaceClass = WebUserService.class,version = "1.0.0")
public class WebUserServiceImpl implements WebUserService {

	@Autowired
	private UserDao userDao;
	@Override
	public User login(String username, String pwd) {
		return userDao.find(username,DigestUtils.md5Hex(pwd));
	}

	@Override
	public User register(User user) {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		if(userDao.add(user)>0) {
			return userDao.getById(user.getUid());
		}
		return null;
	}

}
