package com.shsxt.dao;

import java.util.ArrayList;
import java.util.List;

import com.myclass.bean.Student;
import com.shsxt.util.ResultInfo;
import com.shsxt.util.StringUtil;
import com.shsxt.dto.ResultDto;
import com.shsxt.dto.SqlDto;

public class StuDao {

	BaseDao baseDao = null;

	public StuDao() {
		baseDao = new BaseDao();
	}

	public ResultInfo query(String name, String age, String page, String rows) {
		String sql = "select * from student where 1=1 ";
		String sqlcount = "select count(1) from student where 1=1 ";
		List params = new ArrayList();

		if (!StringUtil.isEmptyOrNull(name)) {
			sql += " AND name like '%" + name + "%' ";
			sqlcount += " AND name like '%" + name + "%' ";
		}
		if (!StringUtil.isEmptyOrNull(age)) {
			sql += " And age = ? ";
			sqlcount += " And age =? ";
			params.add(age);
		}
		if (StringUtil.isEmptyOrNull(page)) {
			page = "1";
		}
		if (StringUtil.isEmptyOrNull(rows)) {
			rows = "10";
		}
		Long total = (Long) baseDao.querySingleValue(sqlcount, params.toArray());

		params.add((Integer.valueOf(page) - 1) * Integer.valueOf(rows));
		params.add(Integer.valueOf(rows));
		sql += " LIMIT ? , ? ";
		List stu = baseDao.queryRows(sql, params.toArray(), Student.class);
		// 转成一个结果对象
		ResultDto result = new ResultDto(Integer.valueOf(total + ""), stu);
		ResultInfo res = new ResultInfo(1, "挺好", result);

		return res;
	}

	public Student insert(Student stu) {
		String sql = "insert into student(sno,name,  birthday,  age,  sex,  address,  phone, introduce) "
				+ "values(null,?,?,?,?,?,?,?)";

		Object[] params = { stu.getName(), stu.getBirthday(), stu.getAge(), stu.getSex(), stu.getAddress(),
				stu.getPhone(), stu.getIntroduce() };

		int row = baseDao.updataOperation(sql, params);
		if (row > 0) {
			return stu;
		}

		return null;
	}

	public Student updt(Student stu) {
		String sql = "update student set name = ? ,sex =?,birthday =?,age =?,address =?,phone =?,"
				+ "introduce =? where sno = ? ";
		Object[] params = { stu.getName(), stu.getSex(), stu.getBirthday(), stu.getAge(), stu.getAddress(),
				stu.getPhone(), stu.getIntroduce(), stu.getSno() };
		int row = baseDao.updataOperation(sql, params);
		if (row > 0) {
			return stu;
		}
		return null;
	}

	public ResultInfo remove(String ids) {
		ResultInfo info = new ResultInfo();
		String[] idArr = ids.split(",");

		List<SqlDto> sqlDtos = new ArrayList<SqlDto>();
		String sqlQuery = "SELECT * FROM student WHERE sno= ? ";
		if (idArr != null && idArr.length > 0) {
			for (int i = 0; i < idArr.length; i++) {
				if (StringUtil.isEmptyOrNull(idArr[i])) {
					continue;
				}
				Object[] params = { Integer.valueOf(idArr[i]) };
				Student temp = (Student) baseDao.queryRow(sqlQuery, params, Student.class);
				if (null != temp) {
					String sqldel = "delete from student where sno =? ";
					Object[] paramsDel = { idArr[i] };
					SqlDto dto = new SqlDto(sqldel, paramsDel);
					sqlDtos.add(dto);
				}
			}
		}
		boolean flag = baseDao.updateOperations(sqlDtos);
		int row = flag ? 1 : 0;
		info.setCode(row);
		return info;
	}

}
