package com.shsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter({ "*.d1", "*.jsp1" })
public class LoginFilter implements Filter {
    public LoginFilter() {
    }

	public void destroy() {
	}

	/**
	 * 过滤方法：拦截未登录的用户访问某些资源   .do  .jsp
	 * 放行：
	 * 		loign.jsp   userController.do   register.jsp
	 * 		已经登陆过的，放行
	 * 拦截：
	 * 		除开放行的，都拦截， 跳转到登陆页面
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		// 固定资源请求放行
		if(uri.contains("login.jsp") || uri.contains("userController.do") || uri.contains("register.jsp")) {
			chain.doFilter(request, response);
		}else {
			// 已经登陆过的放行
			Object obj = req.getSession().getAttribute("user");
			if(null != obj) {
				// 放行
				chain.doFilter(request, response);
			}else {
				// 非法访问
				resp.sendRedirect("login.jsp");
			}
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
