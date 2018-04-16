<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级信息管理系统</title>
<link href="statics/css/login.css" rel="stylesheet" type="text/css" />
<script src="statics/js/jquery-1.11.3.js" type=text/javascript></script>
<script src="statics/js/config.js" type=text/javascript></script>
 
</head>
<body>
<!--head-->
<!-- <div id="head">
	<div class="top">
        <div class="fl" style="margin-top:10px"><img src="static/images/logo.png" /></div>
        <div class="fl"><img src="statics/images/li.png" /></div>
        <div class="fl yahei18">欢迎进入XXX班级信息管理系统</div>       
    </div>
</div>
 -->
<!--login box-->
<div class="wrapper">
	<div id="box">
        <div class="loginbar">用户登录</div>
        <div id="tabcon">
        <div class="box show">
        <form method="POST" action="user" id="myform">
        	<input type="text" class="user yahei16" id="userName" value="shsxt" name="userName" style="width:250px"/><br /><br />
            <input type="password" class="pwd yahei16" id="userPwd" value="123456"  name="userPwd" style="width:250px"/><br /><br />
            <input name="rem" type="checkbox" value="1"  class="inputcheckbox"/> <label>记住我</label>&nbsp; &nbsp; <span id="Msg">${info.msg }</span><br /><br />
            <input type="button" class="log jc yahei16" value="登 录" onclick="checkLogin()" />&nbsp; &nbsp; &nbsp; <input type="reset" v="reg jc yahei18" />
		</form>
		</div>
        </div>        
    </div>
</div>

<div id="flash">
	<div class="pos">
		<a bgUrl="statics/images/banner-bg1.jpg" id="flash1" style="display:block;"><img src="statics/images/login01.jpg"></a>
	    <a bgUrl="statics/images/banner-bg2.jpg" id="flash2"                       ><img src="statics/images/login02.jpg"></a>	   
	</div>    
	<div class="flash_bar">
		<div class="dq" id="f1" onclick="changeflash(1)"></div>
		<div class="no" id="f2" onclick="changeflash(2)"></div>		
	</div>
</div>

<!--bottom-->
<div id="bottom">
	<div id="copyright">
        <div class="quick">
        	<ul>
                    <li><input type="button" class="quickbd iphone" onclick="location.href='http://www.shsxt.com'" /></li>
                    <li><input type="button" class="quickbd android" onclick="location.href='http://www.shsxt.com'" /></li>
                    <li><input type="button" class="quickbd pc" onclick="location.href='http://www.shsxt.com'" /></li>
                <div class="clr"></div>
            </ul>
            <div class="clr"></div>
        </div>
        <div class="text">
        <a href="http://www.baidu.com">校园官网</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.baidu.com">xxx</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.baidu.com">xxx</a>&nbsp;&nbsp;&nbsp;&nbsp; <br />
        </div>
    </div>
</div>
</body>
</html>