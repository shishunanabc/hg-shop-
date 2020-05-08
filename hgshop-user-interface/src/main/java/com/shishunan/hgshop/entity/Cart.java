package com.shishunan.hgshop.entity;
/**
 * 购物车
 * @author 师述男
 *
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int uid;
	private int skuid;
	private int pnum;
	//名称
	private String skuName;
	//单价
	private BigDecimal unitPrice;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createtime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatetime;
	private BigDecimal sumTotal;
	
	public Cart() {
		super();
	}

	public Cart(Integer id, int uid, int skuid, int pnum, String skuName, BigDecimal unitPrice, Date createtime,
			Date updatetime, BigDecimal sumTotal) {
		super();
		this.id = id;
		this.uid = uid;
		this.skuid = skuid;
		this.pnum = pnum;
		this.skuName = skuName;
		this.unitPrice = unitPrice;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.sumTotal = sumTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSkuid() {
		return skuid;
	}

	public void setSkuid(int skuid) {
		this.skuid = skuid;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public BigDecimal getSumTotal() {
		return sumTotal;
	}

	public void setSumTotal(BigDecimal sumTotal) {
		this.sumTotal = sumTotal;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", skuid=" + skuid + ", pnum=" + pnum + ", skuName=" + skuName
				+ ", unitPrice=" + unitPrice + ", createtime=" + createtime + ", updatetime=" + updatetime
				+ ", sumTotal=" + sumTotal + "]";
	}
	
}
