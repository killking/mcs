package com.shsxt.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shsxt.util.DBUtil;
import com.shsxt.util.StringUtil;
import com.shsxt.dto.SqlDto;




/**
 * 专门操作数据库   通用方法
 * 
 * 查询集合
 *
 */
public class BaseDao {
	/**
	 * 查询单航单列   统计的
	 */
	public Object querySingleValue(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object result = null;
		
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			if(null!=params && params.length>0) {
				for(int i=0 ; i<params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			
			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getObject(1);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}finally {
			DBUtil.release(conn, ps,rs);
			return result;
		}
			
	}
	
	
	/**
	 * 查询单条记录
	 * @param sql
	 * @param params
	 * @param clz
	 * @return
	 */
	public Object queryRow(String sql, Object[] params, Class clz) {
		Object obj = null;
		List list = queryRows(sql,params,clz);
		if(list!=null && list.size()>0) {
			obj = list.get(0);
		}
		return obj;
	}
	
	/**
	 * 查询多行多列的数据
	 * @param sql
	 * @param params
	 * @param clz
	 * @return
	 */
	public List queryRows(String sql, Object[] params, Class clz) {
		
		List list = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			if(null!=params && params.length>0) {
				for(int i=0 ; i<params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			
			rs = ps.executeQuery();
			// 获取结果集元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取一共查询了几个字段, 也就表示查询了几个属性
			int fieldNum = rsmd.getColumnCount();
			
			// 获取数据，并且封装成javaBean对象
			// 可能查询了很多条记录
			while(rs.next()) {
				// 表示现在有一条记录
				Object obj = clz.newInstance();
				// 一共要获取这么多次， 因为有这么多个字段
				for(int i=0; i<fieldNum; i++) {
					// 获取字段名 == 属性名称
					String temp = rsmd.getColumnName(i+1);
					// 有别名则获取别名， 没有则获取字段名
					String fieldName = rsmd.getColumnLabel(i+1);
					// 根据属性名称获取属性对象
					Field field = clz.getDeclaredField(fieldName);
					// 利用属性名字 拼接 setter方法， 属性对象获取方法参数的类型
					Method m = clz.getDeclaredMethod("set"+StringUtil.firstCharUp(fieldName), field.getType());
					// 执行方法， 并将数据传入
					m.invoke(obj, rs.getObject(fieldName));
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			list.clear();
		}finally {
			DBUtil.release(conn, ps,rs);
			return list;
		}
	}
	/**
	 * 增、删、改的单条录操作
	 * @param sql
	 * @param params
	 */
	public int updataOperation(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		// 影响的行数
		int row = 0;
		
		try {
			conn = DBUtil.getConnection();
			// 将事物提交设为手动
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			// 传参
			if(null!=params && params.length>0) {
				for(int i=0 ; i<params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			
			row = ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			try {
				// 回滚
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBUtil.release(conn, ps);
		}
		return row;
	}


	/**
	 * 批量执行sql语句， 同一个事务中
	 * @param sqls
	 * @return
	 */
	public boolean updateOperations(List<SqlDto> sqls) {
		boolean flag = true;
		Connection conn = null;
		PreparedStatement ps = null;
		// 影响的行数
		int row = 0;
		try {
		conn = DBUtil.getConnection();
		// 关闭自动提交
		conn.setAutoCommit(false);
		if(null != sqls && sqls.size()>0) {
			// 遍历sql对象集合， 获取出每一条sql和对应的参数
			for(int i=0; i<sqls.size(); i++) {
				// sql对象  
				SqlDto temp = sqls.get(i);
				// 传入sql语句
				ps = conn.prepareStatement(temp.getSql());
				Object[] params = temp.getParams();
				if(params!=null && params.length>0) {
					for(int j=0; j<params.length; j++) {
						ps.setObject(j+1, params[j]);
					}
				}
				row = ps.executeUpdate();
				// 我们自己抛出的异常， 是因为对数据库没有影响
				if(row<=0) {
					throw new Exception("数据库未受影响");
				}
				
			}
			
		}
		
		}catch(Exception e) {
			flag = false;
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBUtil.release(conn, ps);
		}
		return flag;
	}

}
