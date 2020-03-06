package com.zhanglei.hgshop.dao;

import java.util.List;

import com.zhanglei.hgshop.pojo.Spec;
import com.zhanglei.hgshop.pojo.SpecOption;

/** 
* @ClassName: SpecDao 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月4日 下午4:12:51 
*/
public interface SpecDao {

	List<Spec> list(String name);

	int addSpec(Spec spec);

	int addOption(SpecOption specOption);

	Spec get(int id);

	int updateSpec(Spec spec);
	
	int deleteSpec(int id);
	
	int deleteSpecOption(Integer id);

	int deleteSpecBatch(int[] ids);

	int deleteSpecOptionBatch(int[] ids);


}
