<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${ctx}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
    <link href="${ctx}/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <style type="text/css">
        .span{
            white-space: nowrap;
            text-align: left;
            font-size: 17px;
            font-weight: 400;
            font-style: normal;
            text-decoration: none;
            font-family: 微软雅黑;
            color: rgb(38, 19, 29);
        }
    </style>
</head>
<body>
<div style="width:100%;" align="center">
    <div style="width: 200px;" align="left">
        <div class="container" style="weight:200px;height:950px;background-color: rgb(204, 204, 204);">
            <div class="row">
                <div class="navbar" style="background-color: rgb(204, 204, 204);">
                    <ul class="nav nav-pills nav-stacked">
                        <li role="presentation">
                            <a href="mainFrame2" target="mainFrame"><span class="span">首页</span></a>
                        </li>
                        <li role="presentation">
                            <a href="market" target="mainFrame"><span class="span">行情指数</span></a>
                        </li>
                        <li role="presentation">
                            <a href="#" target="mainFrame"><span class="span">Merton模型参数</span></a>
                        </li>
                        <li role="presentation">
                            <a href="#" target="mainFrame"><span class="span">去壳模型参数</span></a>
                        </li>
                        <li role="presentation">
                            <a href="#" target="mainFrame"><span class="span">CornishFisher参数</span></a>
                        </li>
                        <li role="presentation">
                            <a href="#" target="mainFrame"><span class="span">流动性检验模型参数</span></a>
                        </li>
                        <li role="presentation">
                            <a href="managerPower" target="mainFrame"><span class="span">权限管理</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>