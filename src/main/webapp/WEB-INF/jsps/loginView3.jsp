<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    String basePath =request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path+"/";
%>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <link href="<%=basePath%>bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="<%=basePath%>bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<%=basePath%>assets/fonts.css"/>
    <script src="<%=basePath%>js/config.js"></script>
    <script src="<%=basePath%>js/bundle.js"></script>
    <script src="<%=basePath%>js/libs.js"></script>
    <script src="<%=basePath%>js/load.js"></script>
    <script type="text/javascript"
            src="https://run.mockplus.cn/js/bundle.js?v=150665"></script>
    <link href="assets/fonts.css"rel="stylesheet"/>
    <style>
       /* .border1,.border2{ display:inline}*/
    </style>
</head>
<body >
<table width="100%" cellpadding="0" cellspacing="0" style="table-layout:fixed">
    <tr>
        <th width="225" height="48" align="right" scope="col"><img  align="right" src="../../img/app/xhcj.png" width="206" height="103" /></th>
        <th width="427" align="left" scope="col"><label  style="white-space: nowrap; text-align: left; font-size: 26px; font-weight: 400; font-style: normal; text-decoration: none; color: rgb(72, 85, 110);">| 行业信贷违约风险指数</label></th>
        <th width="530" align="left" valign="bottom" scope="col">
            <label
                    style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 91, 142);">
                你好，Administrator@cnfic.com.cn
                <a href="#" style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 255);">退出</a>
            </label>
        </th>
    </tr>
</table>
</body>
<script language="JavaScript">
    /*$(document).ready(function () {
        $('ul.nav > li').click(function (e) {
            e.preventDefault();
            $('ul.nav > li').removeClass('active');
            $(this).addClass('active');
        });
    });*/
</script>
</html>