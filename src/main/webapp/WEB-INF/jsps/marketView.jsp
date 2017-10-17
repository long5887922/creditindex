<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8" />
    <meta
            content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
            name='viewport' />
    <meta name="description" content="Developed By M Abdur Rokib Promy" />
    <meta name="keywords"
          content="Admin, Bootstrap 3, Template, Theme, Responsive" />
    <!-- bootstrap 3.0.2 -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="../../css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="../../css/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="../../css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet"
          type="text/css" />
    <!-- Date Picker -->
    <link href="../../css/datepicker/datepicker3.css" rel="stylesheet"
          type="text/css" />
    <!-- fullCalendar -->
    <!-- <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" /> -->
    <!-- Daterange picker -->
    <link href="../../css/daterangepicker/daterangepicker-bs3.css"
          rel="stylesheet" type="text/css" />
    <!-- iCheck for checkboxes and radio inputs -->
    <link href="../../css/iCheck/all.css" rel="stylesheet" type="text/css" />
    <!-- bootstrap wysihtml5 - text editor -->
    <!-- <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" /> -->
    <!-- Theme style -->
    <link href="../../css/style.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-black">
<!-- header logo: style can be found in header.less -->
<header class="header">
    <div id="border1">
        <img style="width:90px ;height: 50px" alt="" src="../../img/app/xhcj.png" />
        <!-- Header Navbar: style can be found in header.less -->
    </div>
    <div>
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="navbar-btn sidebar-toggle"
               data-toggle="offcanvas" role="button">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
        </nav>
    </div>
</header>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <ul class="sidebar-menu">
                <li class="active"><a href="index.html"> <i
                        class="fa fa-dashboard"></i> <span>行情指数</span>
                </a></li>
            </ul>
        </section>
    </aside>
    <aside class="right-side">
        <!-- Main content -->
        <section class="content">
            <div class="row" style="margin-bottom: 5px;">
                <div class="col-md-5">
                    <div class="sm-st clearfix">
                        <div class="sm-st-info">
                            <label
                                    style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">行业信贷违约风险指数&gt;行情指数</label>
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="sm-st clearfix">
                        <div class="sm-st-info">
                            <label
                                    style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                你好，Administrator@cnfic.com.cn <a href="#">退出</a>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Main row -->
            <div class="row">
                <div class="col-md-8">
                    <!--earning graph start-->
                    <section class="panel">
                        <header class="panel-heading"> 行情指数 </header>
                        <div class="panel-body">
                            <canvas id="linechart" width="600" height="330"></canvas>
                        </div>
                    </section>
                    <!--earning graph end-->
                </div>
            </div>
            <!-- row end -->
        </section>
        <!-- /.content -->
    </aside>
    <!-- /.right-side -->
</div>
<!-- ./wrapper -->

<!-- jQuery 2.0.2 -->
<script src="../../js/jquery.min.js"></script>
<script src="../../js/jquery.min.js" type="text/javascript"></script>
<!-- jQuery UI 1.10.3 -->
<script src="../../js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
<!-- Bootstrap -->
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<!-- daterangepicker -->
<script src="../../js/plugins/daterangepicker/daterangepicker.js"
        type="text/javascript"></script>
<script src="../../js/plugins/chart.js" type="text/javascript"></script>
<!-- datepicker
    <script src="js/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>-->
<!-- Bootstrap WYSIHTML5
    <script src="js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>-->
<!-- iCheck -->
<script src="../../js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
<!-- calendar -->
<script src="../../js/plugins/fullcalendar/fullcalendar.js"
        type="text/javascript"></script>

<!-- Director App -->
<script src="../../js/Director/app.js" type="text/javascript"></script>

<!-- Director dashboard demo (This is only for demo purposes) -->
<script src="../../js/Director/dashboard.js" type="text/javascript"></script>

<!-- Director for demo purposes -->
<script type="text/javascript">
    $(function() {
        "use strict";
        //BAR CHART
        var data = {
            labels : [ "January", "February", "March", "April", "May",
                "June", "July" ],
            datasets : [ {
                label : "My First dataset",
                fillColor : "rgba(220,220,220,0.2)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                pointHighlightFill : "#fff",
                pointHighlightStroke : "rgba(220,220,220,1)",
                data : [ 65, 59, 80, 81, 56, 55, 40 ]
            }, {
                label : "My Second dataset",
                fillColor : "rgba(151,187,205,0.2)",
                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                pointStrokeColor : "#fff",
                pointHighlightFill : "#fff",
                pointHighlightStroke : "rgba(151,187,205,1)",
                data : [ 28, 48, 40, 19, 86, 27, 90 ]
            } ]
        };
        new Chart(document.getElementById("linechart").getContext("2d"))
                .Line(data, {
                    responsive : true,
                    maintainAspectRatio : false
                });

    });
    // Chart.defaults.global.responsive = true;
</script>
</body>
</html>