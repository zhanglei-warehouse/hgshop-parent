package com.zhanglei.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.dao.SpecDao;
import com.zhanglei.hgshop.pojo.Spec;
import com.zhanglei.hgshop.pojo.SpecOption;
import com.zhanglei.hgshop.service.SpecService;

/** 
* @ClassName: SpecServiceImpl 
* @Description: 规格的管理
* @author: lei zhang
* @date: 2020年3月4日 下午4:17:07 
*/
@Service(interfaceClass = SpecService.class ,version = "1.0.0")
public class SpecServiceImpl implements SpecService{

	@Autowired
	private SpecDao specDao;
	
	/**
	 *查询分页
	 */
	@Override
	public PageInfo<Spec> list(String name, int page) {
		PageHelper.startPage(page, 3);
		List<Spec> list = specDao.list(name);
		PageInfo<Spec> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	//添加
	@Override
	public int add(Spec spec) {
			//添加主表
			specDao.addSpec(spec);
			// 这里才能获取到主键ID
			//添加子表
			List<SpecOption> options = spec.getOptions();
			//
			int n=1;
			for (SpecOption specOption : options) {
				// 设置主表的id
				specOption.setSpecId(spec.getId());
				specDao.addOption(specOption);
				n++;
			}
			// 返回的是影响数据的条数
			return n;
	}

	//修改
	@Override
	public int update(Spec spec) {
		//删除子表中数据
		specDao.deleteSpecOption(spec.getId());
		//修改主表
		specDao.updateSpec(spec);
		int x = 0 ;
		//添加子表数据
		List<SpecOption> options = spec.getOptions();
		for (SpecOption specOption : options) {
			//获取主表id
			specOption.setSpecId(spec.getId());
			x=specDao.addOption(specOption);
		}
		return x;
	}
	
	
	
	/**
	 *根据id查找spec对象
	 */
	@Override
	public Spec findById(int id) {
		return specDao.get(id);
	}
	/**
	 *删除
	 */
	@Override
	public int delete(int id) {
		//删除主表
		int i = specDao.deleteSpec(id);
		//删除子表
		int j = specDao.deleteSpecOption(id);
		return (i+j);
	}
	/**
	 *批量删除
	 */
	@Override
	public int deleteBatch(int[] ids) {
		//批量删除主表
		int i = specDao.deleteSpecBatch(ids);
		//批量删除子表
		int j = specDao.deleteSpecOptionBatch(ids);
		return (i+j);
	}

}
