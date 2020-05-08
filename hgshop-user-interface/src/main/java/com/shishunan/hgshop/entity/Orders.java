package com.shishunan.hgshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Orders implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer oid;
	private int  uid;
	private BigDecimal sumtotal;
	private String address;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;
	
	private List<OrderDetail> details;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public BigDecimal getSumtotal() {
		return sumtotal;
	}

	public void setSumtotal(BigDecimal sumtotal) {
		this.sumtotal = sumtotal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", uid=" + uid + ", sumtotal=" + sumtotal + ", address=" + address
				+ ", createTime=" + createTime + ", details=" + details + "]";
	}

	public Orders() {
		super();
	}

	public Orders(Integer oid, int uid, BigDecimal sumtotal, String address, Date createTime,
			List<OrderDetail> details) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.sumtotal = sumtotal;
		this.address = address;
		this.createTime = createTime;
		this.details = details;
	}
}
