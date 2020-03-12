package com.zhanglei.hgshop.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhanglei.hgshop.pojo.User;

/** 
* @ClassName: UserDao 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月11日 下午7:46:30 
*/
public interface UserDao {

	@Select("SELECT * FROM  hg_user "
			+ " WHERE username=#{uname} AND password=#{pwd} limit 1")
	User find(@Param("uname") String username, @Param("pwd") String pwd);

	
	int add(User user);

	@Select("SELECT * FROM hg_user WHERE uid=#{value} ")
	User getById(Integer uid);

}
