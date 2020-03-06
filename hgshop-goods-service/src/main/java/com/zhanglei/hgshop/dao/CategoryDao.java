package com.zhanglei.hgshop.dao;

import java.util.List;

import com.zhanglei.hgshop.pojo.Category;
import com.zhanglei.hgshop.pojo.Spec;
import com.zhanglei.hgshop.pojo.SpecOption;

/** 
* @ClassName: CategoryDao 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月6日 上午10:07:50 
*/
public interface CategoryDao {

	List<Category> tree();

	int add(Category category);

	/**
	 * 
	 * @param id
	 * @return
	 */
	int delete(Integer id);

	/**
	 * 修改
	 * @param category
	 * @return
	 */
	int update(Category category);

}
