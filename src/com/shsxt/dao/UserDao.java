package com.shsxt.dao;

import com.myclass.bean.User;

public class UserDao {

	/**
	 * 根据用户名和密码查询用户信息
	 * @param user
	 */
	public User queryUserBySnoAndPwd(User user) {
		String sql = "SELECT * FROM user WHERE sno=? AND pwd=?";
		Object[] params = {user.getSno(), user.getPwd()};
		
		BaseDao dao = new BaseDao();
		User u = (User) dao.queryRow(sql, params, User.class);
		return u;
	}

	
	

	
	

}
