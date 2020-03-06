package com.zhanglei.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.dao.BrandDao;
import com.zhanglei.hgshop.pojo.Brand;
import com.zhanglei.hgshop.service.BrandService;

/** 
* @ClassName: BrandServiceImpl 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月6日 下午7:27:27 
*/
@Service(interfaceClass = BrandService.class,version = "1.0.0")
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandDao brandDao;
	@Override
	public PageInfo<Brand> list(String name, int page) {
		PageHelper.startPage(page, 3);
		List<Brand> list = brandDao.list(name);
		PageInfo<Brand> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public int add(Brand brand) {
		
		return brandDao.add(brand);
	}

	@Override
	public int delete(int id) {
		return brandDao.delete(id);
	}

	@Override
	public int update(Brand brand) {
		return brandDao.update(brand);
	}

	@Override
	public int deleteBatch(int[] ids) {
		return brandDao.deleteBatch(ids);
	}

	@Override
	public Brand get(int id) {
		return brandDao.get(id);
	}

}
