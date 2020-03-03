package com.zhanglei.hgshop.service;

import com.zhanglei.hgshop.pojo.Brand;

/** 
* @ClassName: GoodsSErvice 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:14:08 
*/
public interface GoodsService {

	
	/**
	 * @param Brand
	 * @return int
	 */
	int addBrand(Brand brand);
	
	/**
	 * @param Brand
	 * @return int
	 */
	int updateBrand(Brand brand);
	
	/**
	 * @param id
	 * @return int
	 */
	int deleteBrand(Integer id);
}
