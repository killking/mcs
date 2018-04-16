<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>江苏师范大学学生信息管理系统</title>
<%@include file="commons.jsp" %>
</head>

<body class="easyui-layout">  
	<!--  north 开始  -->
    <div data-options="region:'north'"
		style="height: 100px; background-image: url(static/images/jssd.png); background-repeat: no-repeat;">
    	<div style="margin-top: 80px; margin-left: 80px; font-size: 13px;" >
    	<!-- <img alt="" src="static/images/jssd.png"> -->
    		<a href="">站点导航:</a>&nbsp;&nbsp;&nbsp;
			<a href="http://www.baidu.com">百度一下</a>&nbsp;&nbsp;&nbsp;
			<a href="http://www.baidu.com">百度一下</a>&nbsp;&nbsp;&nbsp;
			<a href="http://www.baidu.com">百度一下</a>&nbsp;&nbsp;&nbsp;
			<a href="http://www.baidu.com">百度一下</a>&nbsp;&nbsp;&nbsp;
			<a href="http://www.baidu.com">百度一下</a>
			<span
				style="float: right; margin-right: 30px;"> 当前用户：&nbsp;<span
				id="currUser"> ${user.name } </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="userController.do?act=logout"> 退出登录 </a>
			</span>
		</div>
    </div>  
    <!-- north结束 -->
     <!--south start  -->
   <div data-options="region:'south',split:true"
		style="height: 50px;">
			xxx大学班级信息管理系统2018-3-22
	</div>
    <!--south end  -->
    <!-- west start -->
    <div  region="west" style="width: 200px ;" title="导航菜单" split="true"  >
	    <div id="aa"  class="easyui-accordion" data-options="selected:false" style="width:190px;">  
		    <div title="学生基本信息管理" data-options="iconCls:'icon-yxgl'"
				style="padding: 10px"  >  
				<a href="javascript:openTab('学生信息','stu.jsp')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-yxjhgl'"
					style="width: 150px">查询学生信息</a>
		    </div>  
		</div>
		<div id="aa" class="easyui-accordion" data-options="selected:false" style="width:190px;">  
		    <div title="学生成绩管理" data-options="iconCls:'icon-yxgl'"
				style="padding: 10px"  >  
				<a href="javascript:openTab('学生成绩','score.jsp')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-yxjhgl'"
					style="width: 150px">查询学生成绩信息</a>
		    </div>  
		</div>
		<div id="aa" class="easyui-accordion" data-options="selected:false"  style="width:190px;">  
		    <div title="学生课表管理"  data-options="iconCls:'icon-yxgl'"
				style="padding: 10px"  >  
				<a href="javascript:openTab('课程信息','cheng.jsp')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-yxjhgl'"
					style="width: 150px">查询学生课程信息</a>
		    </div>  
		</div>
    	<div id="bb" class="easyui-accordion" data-options="selected:false"v style="width:190px;">  
		    <div title="站点链接" data-options="iconCls:'icon-save' " style="overflow:auto;padding:10px;">  
		        <!-- <h3 style="color:#0099FF;">Accordion for jQuery</h3> -->  
		       <!--  <p>Accordion is a part of easyui framework for jQuery.    
		        It lets you define your accordion component on web page more easily.</p>  --> 
		        <a href="http://www.baidu.com">百度</a>&nbsp;&nbsp;&nbsp;
		        <a href="http://www.baidu.com">新浪</a>
		    </div>  
		 
		</div>  
    	<div id="bb" class="easyui-accordion" data-options="selected:false" style="width:190px;">  
		    <div title="班级口号" data-options="iconCls:'icon-save' " style="overflow:auto;padding:10px;">  
		        这是一个团结友爱的班级   <br>  这是一个团结友爱的班级  <br>  这是一个团结友爱的班级
		    </div>  
		 
		</div>  
    </div>  
    <!-- west end -->  
    <!-- center start -->
    <div data-options="region:'center'"
		style="padding: 5px; background: #eee;">
    <!-- 显示面板，展示数据 -->
	    <div  class="easyui-tabs" fit="true" border="false" id="tabs">  
		    <div title="首页" data-options="iconCls:'icon-home'">
				<div align="center" style="padding-top: 100px">
					<font color="blue" size="10">xxx班级信息管理系统1.0版</font>
				</div>
			</div>
		     
		</div>  
    </div>
     <!-- center end -->    
</body>  
<script type="text/javascript">
	function openTab(text,url){
		/* 如果选项卡已经存在了， 选中即可， 如果不存在，新增 */
		if($('#tabs').tabs('exists',text)){
			$('#tabs').tabs('select',text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
			$('#tabs').tabs('add',{   
			    title:text,   
			    content:content,   
			    closable:true,   
			});  
		}

	}
	</script>
</html>