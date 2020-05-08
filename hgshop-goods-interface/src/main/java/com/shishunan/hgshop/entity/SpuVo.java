package com.shishunan.hgshop.entity;

public class SpuVo extends Spu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page=1;
	private int pageSize=6;
	//排序的字段
	private String orderField="";
	private String orderType="ASC";//默认升序
	public SpuVo() {
		super();
	}
	public SpuVo(int page, int pageSize, String orderField, String orderType) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.orderField = orderField;
		this.orderType = orderType;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	@Override
	public String toString() {
		return "SpuVo [page=" + page + ", pageSize=" + pageSize + ", orderField=" + orderField + ", orderType="
				+ orderType + "]";
	}
	
	
}
