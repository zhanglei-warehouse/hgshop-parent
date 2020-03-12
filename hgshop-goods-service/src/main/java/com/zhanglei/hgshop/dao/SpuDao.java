package com.zhanglei.hgshop.dao;

import java.util.List;

import com.zhanglei.hgshop.pojo.Spu;
import com.zhanglei.hgshop.pojo.SpuVo;

/** 
* @ClassName: SpuDao 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月10日 下午6:01:47 
*/
public interface SpuDao {

	int add(Spu spu);

	int deleteSpuBatch(int[] ids);

	int update(Spu spu);

	List<Spu> list(SpuVo vo);

	int delete(int id);

	Spu findById(int id);
}
