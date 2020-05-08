package com.shishunan.hgshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 订单
 * @author 师述男
 *
 */
public class OrderDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int skuid;//对应的sku的id
	private BigDecimal total;//该条明细的总价
	private int oid;//订单的id
	private int pnum;//购买数量
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", skuid=" + skuid + ", total=" + total + ", oid=" + oid + ", pnum=" + pnum
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getSkuid() {
		return skuid;
	}
	public void setSkuid(int skuid) {
		this.skuid = skuid;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public OrderDetail() {
		super();
	}
	public OrderDetail(Integer id, int skuid, BigDecimal total, int oid, int pnum) {
		super();
		this.id = id;
		this.skuid = skuid;
		this.total = total;
		this.oid = oid;
		this.pnum = pnum;
	}
}
