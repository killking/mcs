package com.shsxt.dto;

import java.util.List;

/*
 * 结果集对象
 */
public class ResultDto {
	private Integer total;
	private List<Object> rows;
	
	
	public ResultDto() {
	}
	

	public ResultDto(Integer total, List<Object> rows) {
		this.total = total;
		this.rows = rows;
	}


	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	
}
