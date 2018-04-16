package com.shsxt.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.shsxt.util.StringUtil;


/**
 * 用来解决乱码的问题
 * 1、在放行之前设定编码
 * 2、根据请求的不同来分别处理乱码
 * 	请求方式:服务器版本不同
 * 		GET : Tomcat8及其以上，  不用处理， 直接放行
 * 			  Tomcat7及其以下 ， 处理，  必须使用String的构造方法来解决
 * 		POST:
 * 			  直接处理， request.setCharacterEncoding()
 * 	
 * 
 */
@WebFilter("/*")
public class CharsetFilter implements Filter {
	String charset = null;


	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setContentType("text/html;charset="+charset);
		
		// 获取请求方式
		String method = req.getMethod();
		if("POST".equalsIgnoreCase(method)) {
			// POST方式的请求
			req.setCharacterEncoding(charset);
		}else {
			// GET方式请求
			String serverInfo = req.getServletContext().getServerInfo();
			serverInfo = serverInfo.substring(serverInfo.lastIndexOf("/")+1);
			serverInfo = serverInfo.substring(0, serverInfo.indexOf("."));
			
			int version = Integer.valueOf(serverInfo);
			if(version<=7) {
				req = new MyWrapper(req,charset);
			} 
			// 其他情况不作处理
		}
		// 放行
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String charset = fConfig.getServletContext().getInitParameter("charset");
		this.charset = charset;
		if(StringUtil.isEmptyOrNull(charset)) {
			this.charset = "UTF-8";
		}
	}

}

class MyWrapper extends HttpServletRequestWrapper{
	HttpServletRequest req = null;
	String charset = null;

	public MyWrapper(HttpServletRequest request,String charset) {
		super(request);
		req = request;
		this.charset = charset;
	}
	
	@Override
	public String getParameter(String name) {
		String value = null;
		// 乱码
		value = req.getParameter(name);
		try {
			// 正确的数据
			value = new String(value.getBytes("ISO-8859-1"),charset);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			value = null;
		}
		
		return value;
	}
	
}







