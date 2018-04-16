package com.shsxt.service;

import com.myclass.bean.ResultInfo;
import com.myclass.bean.User;
import com.shsxt.dao.UserDao;

public class UserService {
	private UserDao userDao = null;
	public UserService() {
		userDao = new UserDao();
	}

	/**
	 * 登陆的操作
	 * @param user
	 * @return
	 */
	public ResultInfo login(User user) {
		ResultInfo resultInfo = new ResultInfo();
		if(user==null) {
			return resultInfo;
		}
		
		User u = userDao.queryUserBySnoAndPwd(user);
		if(u!=null) {
			resultInfo.setCode(1);
			resultInfo.setMsg("登陆成功");
			resultInfo.setResult(u);
		}else {
			resultInfo.setCode(-1);
			resultInfo.setMsg("用户名或密码错误，登录失败");		
			resultInfo.setResult(user);
		}
		return resultInfo;
	}
}
