package com.zhanglei.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhanglei.hgshop.pojo.Brand;

/** 
* @ClassName: BrandDao 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月6日 下午7:31:11 
*/
public interface BrandDao {

	List<Brand> list(String name);

	int add(Brand brand);

	int delete(int id);

	int update(Brand brand);

	int deleteBatch(int[] ids);

	Brand get(int id);

}
