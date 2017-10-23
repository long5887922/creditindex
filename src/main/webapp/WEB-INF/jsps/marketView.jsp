<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var = "cxt" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport' />
    <meta name="description" content="Developed By M Abdur Rokib Promy" />
    <meta name="keywords"  content="Admin, Bootstrap 3, Template, Theme, Responsive" />
    <link href="${ctx}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <script src="${cxt}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/daterangepicker/daterangepicker.js"  type="text/javascript"></script>
    <script src="${cxt}/js/plugins/chart.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/utils.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div style="width:80%;">
    <canvas id="canvas"></canvas>
</div>
<br>
<br>

<script>
    var config;
    var colorNames;
    var colorName;
    var newColor;
    var newDataset;
    var newTest='行业信贷风险指数';
    $(function(){
        $.ajax({
            url:'${ctx}/mp/selectData',
            type:'post',
            dataType:'json',
            success:function(data){
                console.log(data);

                config = {
                    type: 'line',
                    data: data,
                    options: {
                        responsive: true,
                        title:{
                            display:true,
                            text:newTest
                        },
                        tooltips: {
                            mode: 'index',
                            intersect: false
                        },
                        hover: {
                            mode: 'nearest',
                            intersect: true
                        }
                    }
                };
                var ctx = document.getElementById("canvas").getContext("2d");
                window.myLine = new Chart(ctx, config);

            }
        });
    });
</script>
</body>
</html>