<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
<%@include file="commons.jsp"%>
</head>
<body>
	<!-- 添加datagrid -->
	<table id="dg" class="easyui-datagrid" url="stuController.do"
		pagination=true rownumbers=true fit=true toolbar="#tb">
		<thead>
			<tr>

				<th data-options="field:'kc'" checkbox='true'>选择</th>
				<th data-options="field:'sno'">编码</th>
				<th data-options="field:'name'">学生姓名</th>
				<th data-options="field:'sex'">性别</th>
				<th data-options="field:'birthday'">出生年月</th>
				<th data-options="field:'age'">年龄</th>
				<th data-options="field:'address'">住址</th>
				<th data-options="field:'phone'">电话</th>
				<th data-options="field:'introduce'">个人简介</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<a href="javascript:addStuDig()" class="easyui-linkbutton" plain=true
			iconCls="icon-save">添加</a> <a href="javascript:updatestuDig()"
			class="easyui-linkbutton" plain=true iconCls="icon-edit">修改</a> <a
			href="javascript:deletestu()" class="easyui-linkbutton" plain=true
			iconCls="icon-remove">删除</a><br /> 学生姓名: <input id="stuName"
			type="text" name="stuName" style="width: 200px" />
		&nbsp;&nbsp;&nbsp; 年龄:<input id="stuId" type="text" name="stuId"
			style="width: 200px" /> <a href="javascript:searchStu()"
			class="easyui-linkbutton" plain=true iconCls="icon-search">查询</a>
	</div>

	<!-- 添加账户  Dig start -->
	<div id="ddAdd" class="easyui-dialog" title="添加学生信息"
		style="width: 400px; height: 280px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
		<br>
		<form id="ffstuadd">
			<input type="hidden" name="act" value="add">
		
			<div>
				&nbsp;&nbsp;&nbsp;姓名: &nbsp;&nbsp;&nbsp;<input
					class="easyui-validatebox" type="text" id="nameAdd" name="nameAdd"
					data-options="required:true" />
			</div>
			<br />
			<div>
				&nbsp;性别:<select class="easyui-combobox" id="sexAdd" name="sexAdd"
					panelHeight='100' style='width: 100px;'>
					<option value="男">男</option>
					<option value="女">女</option>
				</select>

			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;出生年月: <input type="text"
					class="easyui-validatebox" id="birAdd" name="birAdd"
					data-options="min:0"></input>
			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;年龄: <input type="text" class="easyui-numberbox"
					id="ageAdd" name="ageAdd" data-options="min:0"></input>
			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;住址: <input type="text" class="easyui-validatebox"
					id="addressAdd" name="addressAdd" data-options="min:0"></input>
			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;手机号: <input type="text" class="easyui-validatebox"
					id="phoneAdd" name="phoneAdd" data-options="min:0"></input>
			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;个人简介: <input class="easyui-validatebox"
					type="text" id="introduceAdd" name="introduceAdd" />
			</div>

		</form>
		<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="javaScript:addStu();" class="easyui-linkbutton"
			data-options="iconCls:'icon-save'"></a> &nbsp;&nbsp; <a
			href="javaScript:addCancle();" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel'"></a>
	</div>
	<!-- 添加账户  Dig end -->

	<!-- 修改账户   Dig start -->

	<div id="ddupd" class="easyui-dialog" title="修改学生信息"
		style="width: 400px; height: 280px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
		<br>
		<form id="ffstuupd">
			<input type="hidden" name="act" value="update">
				<input type="hidden" name="sno" >
			<div>
				&nbsp;&nbsp;&nbsp;姓名: &nbsp;&nbsp;&nbsp;<input
					class="easyui-validatebox" type="text" id="nameUpd" name="nameUpd"
					data-options="required:true" />
			</div>
			<br />
			<div>
				&nbsp;性别:<select class="easyui-combobox" id="sexUpd" name="sexUpd"
					panelHeight='100' style='width: 100px;'>
					<option value="男">男</option>
					<option value="女">女</option>
				</select>

			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;出生年月: <input type="text"
					class="easyui-validatebox" id="birUpd" name="birUpd"
					data-options="min:0"></input>
			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;年龄: <input type="text" class="easyui-numberbox"
					id="ageUpd" name="ageUpd" data-options="min:0"></input>
			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;住址: <input type="text" class="easyui-validatebox"
					id="addressUpd" name="addressUpd" data-options="min:0"></input>
			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;手机号: <input type="text" class="easyui-validatebox"
					id="phoneUpd" name="phoneUpd" data-options="min:0"></input>
			</div>
			<br />
			<div>
				&nbsp;&nbsp;&nbsp;个人简介: <input class="easyui-validatebox"
					type="text" id="introduceUpd" name="introduceUpd" />
			</div>

		</form>
		<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="javaScript:updStu();" class="easyui-linkbutton"
			data-options="iconCls:'icon-save'"></a> &nbsp;&nbsp; <a
			href="javaScript:updCancle();" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel'"></a>
	</div>
	<!-- 修改账户   Dig end -->



</body>
<script type="text/javascript">

	//删除
	function deletestu(){
		var objs=$('#dg').datagrid('getSelections');
		if(objs==null){
			alert('请至选择一条记录!');
			return;
		}
		var flag=confirm("是否确定删除?");
		var ids = "";
		for(var i=0 ; i<objs.length; i++){
			if(i==objs.length-1){
				ids += objs[i].sno
			}else{
				ids += objs[i].sno+','
			}
		}
		if(flag){//执行删除操作
			$.ajax({
				url:'stuController.do',
				type:"POST",
				data:{
					act:"delete",
					ids:ids
				},
				success:function (data){
					if(data>0){
						alert('删除成功');
						searchStu();
					}else{
						alert("删除失败!");
					}
				}
			})
		}
	}

	//提交修改数据
	function updStu(){
		$('#ffstuupd').form('submit',{
			url:"stuController.do",
			success:function (data){
				if(data>0){
					alert('修改成功!');
					searchStu();
				}else{
					alert('修改失败!');
				}
			}
			
		});
		$('#ddupd').window('close');
	}
	//取消修改
	function updCancle(){
		$('#ddupd').window('close');
	}
	//修改选中的学生信息
	function updatestuDig(){
		var obj=$('#dg').datagrid('getSelected');
		if(obj==null){
			alert('请选择要修改的学生');
			return;
		}
		$('#sexupd').combobox("select",obj.sex);
		$('#ffstuupd').form('load',{
			sno:obj.sno,
			nameUpd:obj.name,
			sexUpd:obj.sex,
			ageUpd:obj.age,
			addressUpd:obj.address,
			phoneUpd:obj.phone,
			birUpd:obj.birthday,
			introduceUpd:obj.introduce
			
		});
		$('#ddupd').window('open');
	}
	
	

	//添加学生信息
	function addStu() {
		$("#ffstuadd").form('submit', {
			url : "stuController.do",
			success : function(data) {
				if (data > 0) {
					alert("添加成功");
					searchStu();
				} else {
					alert("添加失败");
				}
			}
		})
		$("#ddAdd").window('close');
	}
	function addCancle(){
		$("#ddAdd").window('close');
	}
	//首先弹出来填写信息的框
	function addStuDig() {
		$("#ddAdd").window('open');
	}
	//根据条件查询
	function searchStu() {
		$('#dg').datagrid('load', {
			name : $("#stuName").val(),
			age : $("#stuId").val(),
			act : 'search',
			url : 'stuController.do'
		});
	}
</script>
</html>