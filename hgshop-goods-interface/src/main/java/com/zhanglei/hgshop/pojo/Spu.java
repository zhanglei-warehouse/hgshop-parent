package com.zhanglei.hgshop.pojo;

import java.io.Serializable;

/** 
* @ClassName: Spu 
* @Description: 商品管理
* @author: lei zhang
* @date: 2020年3月10日 下午5:50:06 
*/
public class Spu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 402944056539020785L;
	private Integer	id; 
	private String	goodsName;
	private String	isMarketable; // 是否上线
	private int	brandId;  //品牌
	private String	caption; // 标题
	private int	categoryId; // 分类
	private String	smallPic; //小图
	private Brand	brand;
	private Category category;
	@Override
	public String toString() {
		return "Spu [id=" + id + ", goodsName=" + goodsName + ", isMarketable=" + isMarketable + ", brandId=" + brandId
				+ ", caption=" + caption + ", categoryId=" + categoryId + ", smallPic=" + smallPic + ", brand=" + brand
				+ ", category=" + category + "]";
	}
	public Spu() {
		super();
	}
	public Spu(Integer id, String goodsName, String isMarketable, int brandId, String caption, int categoryId,
			String smallPic, Brand brand, Category category) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.isMarketable = isMarketable;
		this.brandId = brandId;
		this.caption = caption;
		this.categoryId = categoryId;
		this.smallPic = smallPic;
		this.brand = brand;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getIsMarketable() {
		return isMarketable;
	}
	public void setIsMarketable(String isMarketable) {
		this.isMarketable = isMarketable;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
