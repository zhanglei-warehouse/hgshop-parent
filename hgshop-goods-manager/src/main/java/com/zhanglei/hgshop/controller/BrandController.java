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
import com.zhanglei.hgshop.pojo.Brand;
import com.zhanglei.hgshop.service.BrandService;

/** 
* @ClassName: BrandController 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月6日 下午6:41:29 
*/
@Controller
@RequestMapping("brand")
public class BrandController {

	@Reference(timeout = 1050,version = "1.0.0")
	private BrandService brandService; 
	@RequestMapping("list")
	public String list(Model model,@RequestParam(defaultValue="1",value="page") int page,@RequestParam(defaultValue="") String name) {
		PageInfo<Brand> pageInfo = brandService.list(name, page);
		model.addAttribute("queryName", name);
		model.addAttribute("pageInfo", pageInfo);
		return "brand/list";
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
	public boolean add(HttpServletRequest request,Brand brand) {
		//调用服务
		int add = brandService.add(brand);
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
	@RequestMapping("get")
	public Brand getSpec(int id) {
		return brandService.get(id);
	}
	
	/**
	 * 修改规格
	 * @param model
	 * @param spec
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public boolean update(Model model,Brand brand) {
		int update = brandService.update(brand);
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
	@RequestMapping("delBrand")
	public boolean delSpec(int id) {
		int delNum = brandService.delete(id);
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
	@RequestMapping("delBrandBatch")
	public boolean delSpecBatch(@RequestParam(name="ids[]") int[] ids) {
		int delNum = brandService.deleteBatch(ids);
		if(delNum>0) {
			return true;
		}else {
			return false;
		}
	}
}
