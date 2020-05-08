package com.shishunan.hgshop.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import net.sf.jsqlparser.statement.select.First.Keyword;

public class SkuVo extends Sku{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int page=1;
	private int pageSize=6;
	/**
	 *  title 或者  sellPoint 包含keyWord
	 */
	private String keyWord;
	//最大价格
	private BigDecimal maxPrice;
	//最小价格
	private BigDecimal minPrice;
	
	//最早的时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minTime;
	//最晚的时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxTime;
	
	//排序字段
	private String[] sortColumn;
	//排序的方式
	private String sortType;
	public SkuVo() {
		super();
	}
	public SkuVo(int page, int pageSize, String keyWord, BigDecimal maxPrice, BigDecimal minPrice, Date minTime,
			Date maxTime, String[] sortColumn, String sortType) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.keyWord = keyWord;
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
		this.minTime = minTime;
		this.maxTime = maxTime;
		this.sortColumn = sortColumn;
		this.sortType = sortType;
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
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	public Date getMinTime() {
		return minTime;
	}
	public void setMinTime(Date minTime) {
		this.minTime = minTime;
	}
	public Date getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(Date maxTime) {
		this.maxTime = maxTime;
	}
	public String[] getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String[] sortColumn) {
		this.sortColumn = sortColumn;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SkuVo [page=" + page + ", pageSize=" + pageSize + ", keyWord=" + keyWord + ", maxPrice=" + maxPrice
				+ ", minPrice=" + minPrice + ", minTime=" + minTime + ", maxTime=" + maxTime + ", sortColumn="
				+ Arrays.toString(sortColumn) + ", sortType=" + sortType + "]";
	}
	
}
