package com.shsxt.service;

import com.myclass.bean.Student;
import com.shsxt.util.ResultInfo;
import com.shsxt.dao.StuDao;

public class StuService {
	
	StuDao stuDao=null;
	public StuService() {
		stuDao=new StuDao();
	}

	public ResultInfo queryStu(String name, String age, String page, String rows) {
		
		ResultInfo result=stuDao.query(name,age,page,rows);
		
		
	
		return result;
	}

	public ResultInfo<Student> add(Student stu) {
		ResultInfo<Student> info= new ResultInfo<Student>();
		if(stu==null){
			return null;
		}
		Student stu1=stuDao.insert(stu);
		if(stu1==null){//添加失败
			info.setCode(-1);
			info.setMsg("添加失败");
			info.setResultData(stu);
		}else{//添加成功
			info.setCode(1);
			info.setMsg("添加成功");
		}
		return info;
	}

	public ResultInfo updata(Student stu) {
		ResultInfo info= new ResultInfo();
		if(stu==null){
			return info;
		}
		Student student =stuDao.updt(stu);
		if(student==null){//插入失败
			info.setCode(-1);
			info.setMsg("修改失败!");
			info.setResultData(info);
		}else{
			info.setCode(1);
			info.setMsg("修改成功!");
			info.setResultData(student);
		}
		
		return info;
	}

	public ResultInfo deleteBySno(String ids) {
		ResultInfo info= new ResultInfo();
		if(ids==null){
			return info;
		}
		info=stuDao.remove(ids);
	
		return info;
	}

}
