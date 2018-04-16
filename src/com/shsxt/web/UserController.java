package com.shsxt.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.bean.ResultInfo;
import com.myclass.bean.User;
import com.shsxt.service.UserService;
import com.shsxt.util.WebUtils;

@WebServlet("/user")
public class UserController extends HttpServlet {
	UserService userService=new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String sno =request.getParameter("userName");
		String pwd = request.getParameter("userPwd");
		
		//处理空判断..........		
		if(WebUtils.isNullOrBlank(sno)||WebUtils.isNullOrBlank(pwd)){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return ;
		}
		
		
		ResultInfo<User> resultInfo = userService.login(new User(pwd,sno));
		
		if(resultInfo.getCode()>0) {
			// 成功了
			String rem = request.getParameter("rem");
			if(!WebUtils.isNullOrBlank(rem) && "1".equals(rem)) {
				// 存 Cookie  
				Cookie cookie = new Cookie("user",resultInfo.getResult().getSno()+"&"+pwd);
				cookie.setMaxAge(3*24*60*60);
				response.addCookie(cookie);
			}
			
			// 写入session
			request.getSession().setAttribute("user", resultInfo.getResult());
			response.sendRedirect("main.jsp");
		}else {
			// 失败了
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
