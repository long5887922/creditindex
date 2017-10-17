<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</head>
<body >
<div class="container" style="margin-top: 11px;margin-left: 30px;">
    <div class="row" >
        <div class="navbar" style="background-color: rgb(204, 204, 204);">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation">
                    <a  href="mainFrame2" target="mainFrame" style="white-space: nowrap; text-align: left; font-size: 17px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(38, 19, 29);">首页</a></li>
                <li role="presentation" >
                    <a href="login" target="mainFrame"  style="white-space: nowrap; text-align: left; font-size: 17px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(38, 19, 29);">行情指数</a>
                </li>
                <li role="presentation">
                    <a href="#" target="mainFrame"  style="white-space: nowrap; text-align: left; font-size: 17px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(38, 19, 29);">Merton模型参数</a>
                </li>
                <li role="presentation">
                    <a href="#" target="mainFrame" style="white-space: nowrap; text-align: left; font-size: 17px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(38, 19, 29);">去壳模型参数</a>
                </li>
                <li role="presentation">
                    <a href="#" target="mainFrame" style="white-space: nowrap; text-align: left; font-size: 17px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(38, 19, 29);">CornishFisher参数</a>
                </li>
                <li role="presentation">
                    <a href="#" target="mainFrame" style="white-space: nowrap; text-align: left; font-size: 17px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(38, 19, 29);">流动性检验模型参数</a>
                </li>
                <li role="presentation">
                    <a href="managerPower" target="mainFrame" style="white-space: nowrap; text-align: left; font-size: 17px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(38, 19, 29);">权限管理</a>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
<script language="JavaScript">
/*    $(document).ready(function () {
        $('ul.nav > li').click(function (e) {
            e.preventDefault();
            $('ul.nav > li').removeClass('active');
            $(this).addClass('active');
        });
    });*/
</script>
</html>