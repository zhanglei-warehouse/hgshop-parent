package com.zhanglei.hgshop.service.impl;


import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.dao.BrandDao;
import com.zhanglei.hgshop.dao.CategoryDao;
import com.zhanglei.hgshop.dao.SkuDao;
import com.zhanglei.hgshop.dao.SpuDao;
import com.zhanglei.hgshop.pojo.Brand;
import com.zhanglei.hgshop.pojo.Category;
import com.zhanglei.hgshop.pojo.Sku;
import com.zhanglei.hgshop.pojo.SpecOption;
import com.zhanglei.hgshop.pojo.Spu;
import com.zhanglei.hgshop.pojo.SpuVo;
import com.zhanglei.hgshop.service.GoodsService;

/** 
* @ClassName: GoodsServiceImpl 
* @Description: 商品服务实现类
* @author: lei zhang
* @date: 2020年3月3日 下午12:27:49 
*/
@Service(interfaceClass = GoodsService.class,version = "1.0.0")
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private CategoryDao catDao;

	@Autowired
	private SpuDao spuDao;
	
	@Autowired
	SkuDao skuDao;
	
	@Autowired
	BrandDao brandDao;
	

	@Override
	public int addCategory(Category category) {
		return catDao.add(category);
	}
 
	@Override
	public int updateCategory(Category category) {
		return catDao.update(category);
	}

	@Override
	public int deleteCategory(Integer id) {
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
		return catDao.tree();
	}

	// spu的列表
		@Override
		public PageInfo<Spu> listSpu(int page, SpuVo vo) {
			PageHelper.startPage(page, 10);
			
			return new PageInfo<Spu>(spuDao.list(vo));
		}

		@Override
		public int addSpu(Spu spu) {
			int cnt =  spuDao.add(spu);
			//kafaTemplate.send("MyAddSpu", "spuId", cnt+"");
			return cnt;
			 
		}

		@Override
		public int updateSpu(Spu spu) {
			return spuDao.update(spu);
		}

		@Override
		public int deleteSpu(int id) {
			return spuDao.delete(id);
		}

		@Override
		public int deleteSpuBatch(int[] ids) {
			return spuDao.deleteSpuBatch(ids);
		}

		@Override
		public List<Brand> getAllBrands() {
			return brandDao.listAll();
		}

		@Override
		public PageInfo<Sku> listSku(int page, Sku sku) {
			PageHelper.startPage(page, 5);
			return new PageInfo<Sku>(skuDao.list(sku));
		}

		@Override
		public int addSku(Sku sku) {
			//先加主表
			int cnt = skuDao.addSku(sku);
			List<SpecOption> specs = sku.getSpecs();
			for (SpecOption specOption : specs) {
				cnt += skuDao.addSkuSpec(sku.getId(),specOption);
			}
			
			return cnt;
		}

		@Override
		public Sku getSku(int id) {
			return skuDao.get(id);
		}

		@Override
		public int updateSku(Sku sku) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int deleteSku(int id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int deleteSkuBatch(int[] id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Spu getSpu(int id) {
			// TODO Auto-generated method stub
			return spuDao.findById(id);
		}

		@Override
		public List<Sku> listSkuBySpu(int spuId) {
			return skuDao.listBySpu(spuId);
		}
}
