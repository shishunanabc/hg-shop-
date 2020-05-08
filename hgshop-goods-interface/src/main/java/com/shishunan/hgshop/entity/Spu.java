package com.shishunan.hgshop.entity;

import java.io.Serializable;
import java.util.List;

public class Spu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String goodsName;
	private int isMarketable;
	private int brandId;//品牌Id
	private String caption;//标题
	private int categoryId;//分类
	private String smallPic;//处处图片的路径
	
	private Category category;//分类
	private Brand brand;//品牌id
	
	private List<Sku> skuList; //获取这个商品所有的sku
	public Spu() {
		super();
	}
	public Spu(Integer id, String goodsName, int isMarketable, int brandId, String caption, int categoryId,
			String smallPic, Category category, Brand brand, List<Sku> skuList) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.isMarketable = isMarketable;
		this.brandId = brandId;
		this.caption = caption;
		this.categoryId = categoryId;
		this.smallPic = smallPic;
		this.category = category;
		this.brand = brand;
		this.skuList = skuList;
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
	public int getIsMarketable() {
		return isMarketable;
	}
	public void setIsMarketable(int isMarketable) {
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public List<Sku> getSkuList() {
		return skuList;
	}
	public void setSkuList(List<Sku> skuList) {
		this.skuList = skuList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Spu [id=" + id + ", goodsName=" + goodsName + ", isMarketable=" + isMarketable + ", brandId=" + brandId
				+ ", caption=" + caption + ", categoryId=" + categoryId + ", smallPic=" + smallPic + ", category="
				+ category + ", brand=" + brand + ", skuList=" + skuList + "]";
	}
	
}
