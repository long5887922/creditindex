<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath =request.getScheme()+"://"+request.getServerName()+":"
			+request.getServerPort()+path+"/";
%>
<style>
	.border1,.border2{ display:inline}
</style>
<head>
	<title>行业信贷违约风险指数</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/login.js"></script>
	<script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
	<link href="<%=basePath%>bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>

<body>
<br/>
<div class="container">
	<%-- 由于本次的编写需要基于表单，同时还需要考虑到数据验证的问题，那么就可以不写row样式 --%>
	<form id="loginForm" action="/um/frameset" method="post" class="form-horizontal">
		<div class="border1" style="left: 0px; top: 0px; width: 170px; height: 95px;">
			<img style="width: 180px;height: 120px;" src="../../img/app/xhcj.png"/>
		</div>
		<div class="border2" >
			<label
					style="white-space: nowrap; text-align: left; font-size: 32px; font-style: normal; text-decoration: none; color: rgb(72, 85, 110);">
				| 行业信贷违约风险指数</label>
		</div>
		<br/><br/>
		<fieldset>
			<legend><label><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;用户登录</label></legend>
			<br/><br/><br/><br/><br/>
			<%-- 描述mid输入信息的内容 --%>
			<div class="form-group" id="midDiv">
				<label class="col-md-3 control-label" for="mid">用户名：</label>
				<div class="col-md-5">
					<%-- id是为JavaScript服务的，而name是为了JSP的接收数据服务的 --%>
					<input type="text" id="mid" name="usernumber" class="form-control" placeholder="请输入登录名">
				</div>
				<div class="col-md-4" id="midSpan"></div>
			</div>
			<div class="form-group" id="passwordDiv">
				<label class="col-md-3 control-label" for="password">密码：</label>
				<div class="col-md-5">
					<%-- id是为JavaScript服务的，而name是为了JSP的接收数据服务的 --%>
					<input type="password" id="password" name="password" class="form-control" placeholder="请输入登录密码">
				</div>
				<div class="col-md-4" id="passwordSpan"></div>
			</div>
			<div class="form-group" id="butDiv">
				<div class="col-md-5 col-md-offset-3">
					<button type="submit" id="subBut" class="btn btn-xs btn-primary">登录</button>
					<button type="reset" id="rstBut" class="btn btn-xs btn-warning">重置</button>
				</div>
			</div>
		</fieldset>
	</form>
</div>
</body>

</html>