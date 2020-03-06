package com.zhanglei.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.pojo.Brand;
import com.zhanglei.hgshop.pojo.Category;

/** 
* @ClassName: GoodsSErvice 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:14:08 
*/
public interface GoodsService {

	
	int addBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Brand> listBrand( String firstChar,int page); 
	
	
	int addCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Category> listCategory( String firstChar,int page); 
	/**
	 * 以树的形式显示列表
	 * @return
	 */
	List<Category> treeCategory(); 
}
