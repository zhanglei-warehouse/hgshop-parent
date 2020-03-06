package com.zhanglei.hgshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/** 
* @ClassName: AdminProperties 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:28:22 
*/

@Configuration
@PropertySource("classpath:hdshop-admin.properties")
public class AdminProperties {
	
	@Value("${amdin.name}")
	String adminName;
	
	@Value("${admin.pwd}")
	String password;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
