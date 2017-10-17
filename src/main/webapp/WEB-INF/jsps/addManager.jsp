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
    <link href="<%=basePath%>bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="<%=basePath%>bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.0/bootstrap-table.min.css" rel="stylesheet">

    <script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.8.1/bootstrap-table-all.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.8.1/locale/bootstrap-table-zh-CN.js"></script>

    <style>
        .table th, .table td {
            text-align: center;
            height:38px;
        }
        .td{
            font-size: 14px;
            font-weight: 400;
            font-style: normal;
            text-decoration: none;
            font-family: 微软雅黑;
            color: rgb(0, 0, 0);

            box-sizing: border-box;
            overflow: hidden;
            vertical-align: middle !important;
            text-align: center;
            height: 60px;
        }
    </style>
</head>
<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<div class="container">
    <div class="row">
        <div class="row">
            <div class="col-md-10">
                <ul class="list-group">
                    <a class="list-group-item"> 行业信贷违约风险指数>管理员维护 </a>
                </ul>
            </div>

        </div>
    </div>
</div>
</body>
<script type="text/javascript">

</script>
</html>