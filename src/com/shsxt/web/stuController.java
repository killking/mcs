package com.shsxt.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.bean.Student;
import com.shsxt.service.StuService;
import com.shsxt.util.ResultInfo;
import com.shsxt.util.StringUtil;


/**
 * Servlet implementation class stuController
 */
@WebServlet("/stuController.do")
public class stuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private StuService stuService=null;
    public stuController() {
    	stuService= new StuService();
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String act= request.getParameter("act");
			if(StringUtil.isEmptyOrNull(act)||"search".equals(act)){
				search(request,response);
			}else if("add".equals(act)){
				stuAdd(request,response);
			}else if("update".equals(act)){
				update(request,response);
			}else if("delete".equals(act)){
				delete(request,response);
			}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ids=request.getParameter("ids");
		
		ResultInfo result=stuService.deleteBySno(ids);
		
		response.getWriter().write(result.getCode()+"");
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String sno=request.getParameter("sno");
		String name=request.getParameter("nameUpd");
		String sex=request.getParameter("sexUpd");
		String age=request.getParameter("ageUpd");
		String address=request.getParameter("addressUpd");
		String introduce=request.getParameter("introduceUpd");
		String phone=request.getParameter("phoneUpd");
		String birthday=request.getParameter("birUpd");
		if(StringUtil.isEmptyOrNull(name)){
			response.getWriter().write("0");
			return;
		}
		Student stu= new Student(Integer.valueOf(sno),  name,  birthday,  Integer.valueOf(age),  sex,  address,  phone,
				 introduce);
		
		ResultInfo result= stuService.updata(stu);
		if(result.getCode()>0){
			response.getWriter().write(result.getCode()+"");
			return;
		}else{
			response.getWriter().write(result.getCode()+"");
			return;
		}
		
	}
	private void stuAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String name=request.getParameter("nameAdd");
			String sex=request.getParameter("sexAdd");
			String age=request.getParameter("ageAdd");
			String address=request.getParameter("addressAdd");
			String introduce=request.getParameter("introduceAdd");
			String phone=request.getParameter("phoneAdd");
			String birthday=request.getParameter("birAdd");
			
			if(StringUtil.isEmptyOrNull(name)){
				response.getWriter().write("0");
				return;
			}
			Student stu= new Student(null,  name,  birthday,  Integer.valueOf(age),  sex,  address,  phone,
					 introduce);
			
			ResultInfo<Student> result= stuService.add(stu);
			if (result.getCode()>0){//添加成功
				
				response.getWriter().write(result.getCode()+"");
				return;
			}else{
				response.getWriter().write(result.getCode()+"");
				return;
			}
		
	}
	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String page=request.getParameter("page");
			String rows =request.getParameter("row");
			ResultInfo result= stuService.queryStu(name,age,page,rows);
			String jsonStr= StringUtil.getJsonString(result.getResultData());
 			response.getWriter().write(jsonStr);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
