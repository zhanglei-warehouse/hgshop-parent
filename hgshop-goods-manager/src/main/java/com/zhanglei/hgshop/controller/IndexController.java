package com.zhanglei.hgshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @ClassName: IndexController 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午1:19:59 
*/
@Controller
public class IndexController {

	@RequestMapping({"/","index"})
	public String index() {
		return "index";
	}
}
