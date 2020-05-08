package com.shishunan.hgshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Sku implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; //主键
	private String title; //标题
	private String sellPoint; //卖点
	private BigDecimal price; //价格
	private Integer stockCount; //库存
	private String barcode; //条形码
	private String image;  //图片
	private String status;  //状态
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;  //添加的时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateTime;  //修改的时间
	private BigDecimal costPrice;  //成本
	private BigDecimal marketPrice;  //市场价格
	private String spuId;  //spu的id
	private String cartThumbnail; //购物车显示的小图
	private Spu spu; 
	
	private List<SpecOption> optionList; //这个sku 拥有哪些属性

	public Sku() {
		super();
	}
	public Sku(Integer id, String title, String sellPoint, BigDecimal price, Integer stockCount, String barcode,
			String image, String status, Date createTime, Date updateTime, BigDecimal costPrice, BigDecimal marketPrice,
			String spuId, String cartThumbnail, Spu spu, List<SpecOption> optionList) {
		super();
		this.id = id;
		this.title = title;
		this.sellPoint = sellPoint;
		this.price = price;
		this.stockCount = stockCount;
		this.barcode = barcode;
		this.image = image;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.costPrice = costPrice;
		this.marketPrice = marketPrice;
		this.spuId = spuId;
		this.cartThumbnail = cartThumbnail;
		this.spu = spu;
		this.optionList = optionList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStockCount() {
		return stockCount;
	}
	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getSpuId() {
		return spuId;
	}
	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}
	public String getCartThumbnail() {
		return cartThumbnail;
	}
	public void setCartThumbnail(String cartThumbnail) {
		this.cartThumbnail = cartThumbnail;
	}
	public Spu getSpu() {
		return spu;
	}
	public void setSpu(Spu spu) {
		this.spu = spu;
	}
	public List<SpecOption> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<SpecOption> optionList) {
		this.optionList = optionList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Sku [id=" + id + ", title=" + title + ", sellPoint=" + sellPoint + ", price=" + price + ", stockCount="
				+ stockCount + ", barcode=" + barcode + ", image=" + image + ", status=" + status + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", costPrice=" + costPrice + ", marketPrice="
				+ marketPrice + ", spuId=" + spuId + ", cartThumbnail=" + cartThumbnail + ", spu=" + spu
				+ ", optionList=" + optionList + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sku other = (Sku) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
