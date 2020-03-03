package com.zhanglei.hgshop.service.impl;


import org.apache.dubbo.config.annotation.Service;

import com.zhanglei.hgshop.pojo.Brand;
import com.zhanglei.hgshop.service.GoodsService;

/** 
* @ClassName: GoodsServiceImpl 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:27:49 
*/
@Service(interfaceClass = GoodsService.class,version = "1.0.0")
public class GoodsServiceImpl implements GoodsService{

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

}
