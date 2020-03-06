package com.zhanglei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.pojo.Spec;
import com.zhanglei.hgshop.pojo.SpecOption;
import com.zhanglei.hgshop.service.SpecService;

/** 
* @ClassName: SpecController 
* @Description: 规格管理
* @author: lei zhang
* @date: 2020年3月4日 下午4:25:47 
*/
@Controller
@RequestMapping("spec")
public class SpecController {

	@Reference(timeout = 1000,version = "1.0.0")
	private SpecService specService;
	
	/**
	 * 进入规格的列表
	 * @param request
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="") String name) {
		PageInfo<Spec> pageInfo = specService.list(name, page);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("queryName", name);
		return "spec/list";
	}
	
	/**
	 * 添加
	 * @param request
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public boolean add(HttpServletRequest request,Spec spec) {
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		//调用服务
		int add = specService.add(spec);
		if(add>0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 用于修改数据的时候回显
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getSpec")
	public Spec getSpec(int id) {
		return specService.findById(id);
	}
	
	/**
	 * 修改规格
	 * @param model
	 * @param spec
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public boolean update(Model model,Spec spec) {
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		System.err.println("1111111111");
		List<SpecOption> options = spec.getOptions();
		for (SpecOption specOption : options) {
			String optionName = specOption.getOptionName();
			System.err.println(optionName);
		}
		int update = specService.update(spec);
		if(update>0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 删除规格
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delSpec")
	public boolean delSpec(int id) {
		int delNum = specService.delete(id);
		if(delNum>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * 
	 * 规格批量删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delSpecBatch")
	public boolean delSpecBatch(@RequestParam(name="ids[]") int[] ids) {
		int delNum = specService.deleteBatch(ids);
		if(delNum>0) {
			return true;
		}else {
			return false;
		}
	}
	
}
