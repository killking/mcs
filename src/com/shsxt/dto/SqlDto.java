package com.shsxt.dto;
/**
 * 一个sql对象
 * 	Sql语句
 * 	对应的的参数
 * 
 * 为了以后能够在一个事务中执行多条sql语句
 */
public class SqlDto {
	private String sql;
	private Object[] params;
	public SqlDto() {
	}
	
	public SqlDto(String sql, Object[] params) {
		super();
		this.sql = sql;
		this.params = params;
	}


	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	
	
}
