package com.zhanglei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zhanglei.hgshop.pojo.Sku;
import com.zhanglei.hgshop.pojo.Spu;
import com.zhanglei.hgshop.pojo.SpuVo;
import com.zhanglei.hgshop.service.GoodsService;

/** 
* @ClassName: IndexController 
* @Description: 商城首页
* @author: lei zhang
* @date: 2020年3月11日 下午8:15:50 
*/
@Controller
public class IndexController {

	@Reference(timeout = 1043,version = "1.0.0")
	private GoodsService goodsService;
	
	/**
	 * 
	 * @param request
	 * @param page
	 * @param catId
	 * @return
	 */
	@RequestMapping({"/","index"})
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="0") int catId) {
		// 获取商品的数据
		PageInfo<Spu> listSpu = goodsService.listSpu(page, new SpuVo());
		request.setAttribute("pageInfo", listSpu);
		return "index";
	}
	
	/**
	 * 显示商品详情
	 * @param request
	 * @param spuId
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(HttpServletRequest request,int spuId) {
		/**
		 * 获取详情
		 */
		// spu
		Spu spu = goodsService.getSpu(spuId);
		// TODO sku 
		List<Sku> skuList = goodsService.listSkuBySpu(spuId);
		
		request.setAttribute("spu", spu);
		request.setAttribute("skus", skuList);
		System.out.println("skuList is " + skuList);
		return "detail";
	}
}
