<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var = "cxt" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8" />
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport' />
    <meta name="description" content="Developed By M Abdur Rokib Promy" />
    <meta name="keywords"  content="Admin, Bootstrap 3, Template, Theme, Responsive" />
    <!-- bootstrap 3.0.2 -->

    <link href="${cxt}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="${cxt}/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="${cxt}/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="${cxt}/css/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="${ctx}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${cxt}/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
    <!-- Date Picker -->
    <link href="${cxt}/css/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
    <!-- fullCalendar -->
    <!-- <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" /> -->
    <!-- Daterange picker -->
    <link href="${cxt}/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
    <!-- iCheck for checkboxes and radio inputs -->
    <link href="../../css/iCheck/all.css" rel="stylesheet" type="text/css" />
    <!-- bootstrap wysihtml5 - text editor -->
    <!-- <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" /> -->
    <!-- Theme style -->
    <link href="${cxt}/css/style.css" rel="stylesheet" type="text/css" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <script src="${cxt}/js/jquery.min.js" type="text/javascript"></script>
    <!-- jQuery UI 1.10.3 -->
    <script src="${cxt}/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
    <!-- Bootstrap -->
    <script src="${cxt}/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- daterangepicker -->
    <script src="${cxt}/js/plugins/daterangepicker/daterangepicker.js"  type="text/javascript"></script>
    <script src="${cxt}/js/plugins/chart.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <!-- calendar -->
    <script src="${cxt}/js/plugins/fullcalendar/fullcalendar.js" type="text/javascript"></script>
    <!-- Director App -->
    <script src=" ${cxt}/js/Director/app.js" type="text/javascript"></script>
    <!-- Director dashboard demo (This is only for demo purposes) -->
    <script src="${cxt}/js/Director/dashboard.js" type="text/javascript"></script>
    <!-- Director for demo purposes -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-black">
<div class="container">
    <div class="row">
        <div class="col-md-10">
            <ul class="list-group">
                <a class="list-group-item"> 行业信贷违约风险指数>行情指数 </a>
            </ul>
        </div>
        <form id="">
            <div class="col-md-10" >
                <div>
                    <%--<ul class="list-group">
                        <a class="list-group-item" style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">行情指数</a>
                    </ul>--%>
                    <section class="panel">
                        <div class="panel-body" style="top:-10px;">
                            <canvas id="linechart" width="500" height="300"></canvas>
                        </div>
                    </section>

                    <div style="width:50%">
                        <div id="line-legend">
                        </div>
                        <div>
                            <canvas id="line-chart" height="450px" width="800px"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(function() {
        "use strict";
        //BAR CHART
        /*  $.ajax({
         url:'${ctx}/mp/selectData',
         type:'post',
         data : $('#addUserManager').serialize(),
         dataType:'json',
         success:function(data){
         new Chart(document.getElementById("linechart").getContext("2d"))
         .Line(data, {
         responsive : true,
         maintainAspectRatio : false
         });
         }
         });*/
        var data = {
            labels : [ "January", "February", "March", "April", "May",
                "June", "July" ],
            datasets : [ {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                data : [ 65, 59, 80, 81, 56, 199, 300 ]
            },{
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                data : [ 15, 69, 77, 81, 90, 100, 189 ]
            }]

        };

        new Chart(document.getElementById("linechart").getContext("2d"))
                .Line(data, {
                    responsive : true,
                    //Boolean - Whether to fill the dataset with a color
                    datasetFill: false,
                    maintainAspectRatio : false
                });
    });
    //Chart.defaults.global.responsive = true;
</script>
</body>
</html>