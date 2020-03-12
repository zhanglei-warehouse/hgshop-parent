package com.zhanglei.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.pojo.Brand;
import com.zhanglei.hgshop.pojo.Category;
import com.zhanglei.hgshop.pojo.Sku;
import com.zhanglei.hgshop.pojo.Spu;
import com.zhanglei.hgshop.pojo.SpuVo;

/** 
* @ClassName: GoodsSErvice 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:14:08 
*/
public interface GoodsService {

	
	
	
	
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
	
	List<Brand> getAllBrands();
	
	// spu的管理
		PageInfo<Spu>  listSpu(int page,SpuVo vo);
		int addSpu(Spu spu);
		int updateSpu(Spu spu);
		int deleteSpu(int id);
		Spu getSpu(int id);
		int deleteSpuBatch(int[] id);
		
		// sku的管理
		PageInfo<Sku>  listSku(int page,Sku sku);
		int addSku(Sku sku);
		Sku getSku(int id);//获取详情
		int updateSku(Sku sku);
		int deleteSku(int id);
		int deleteSkuBatch(int[] id);
		/**
		 * 根据spu 获取所有的sku
		 * @param spuId
		 * @return
		 */
		List<Sku> listSkuBySpu(int spuId);
}
