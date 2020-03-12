package com.zhanglei.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.pojo.Spec;

/** 
* @ClassName: SpecService 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月4日 下午4:13:52 
*/
public interface SpecService {

	PageInfo<Spec> list(String name,int page);
	
	int add(Spec spec);
	
	int update(Spec spec);
	
	int delete(int id);
	
	/**
	 * 查找一个规格 用于修改时候的回显
	 * @param id
	 * @return
	 */
	Spec findById(int id);
	
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	int deleteBatch(int[] id);
	
	/**
	 * 获取所有的规格名称
	 * @param name
	 * @param page
	 * @return
	 */
	List<Spec> listAll();
}
