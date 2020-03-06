package com.zhanglei.hgshop.service.impl;


import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.dao.CategoryDao;
import com.zhanglei.hgshop.pojo.Brand;
import com.zhanglei.hgshop.pojo.Category;
import com.zhanglei.hgshop.service.GoodsService;

/** 
* @ClassName: GoodsServiceImpl 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:27:49 
*/
@Service(interfaceClass = GoodsService.class,version = "1.0.0")
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	CategoryDao catDao;

	@Override
	public int addBrand(Brand brand) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBrand(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Brand> listBrand(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return catDao.add(category);
	}
 
	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return catDao.update(category);
	}

	@Override
	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return catDao.delete(id);
	}

	/**
	 * 
	 */
	@Override
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return catDao.tree();
	}
}
