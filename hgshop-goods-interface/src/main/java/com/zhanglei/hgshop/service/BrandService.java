package com.zhanglei.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.pojo.Brand;

/** 
* @ClassName: BrandService 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月6日 下午7:26:41 
*/
public interface BrandService {

	PageInfo<Brand> list(String name,int page);
	
	int add(Brand brand);
	
	int delete(int id);
	
	int deleteBatch(int[] ids);
	
	Brand get(int id);
	
	int update(Brand brand);
}
