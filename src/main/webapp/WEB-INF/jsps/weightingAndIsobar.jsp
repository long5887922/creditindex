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
    <link href="${ctx}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <script src="${cxt}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/daterangepicker/daterangepicker.js"  type="text/javascript"></script>
    <script src="${cxt}/js/plugins/chart.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-black">
<div class="container">
    <div class="row">
        <form id="">
            <div class="col-md-5" >
                <div>
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
        $.ajax({
            url:'${ctx}/mp/selectData',
            type:'post',
            dataType:'json',
            success:function(data){
                console.log(data);
                new Chart(document.getElementById("linechart").getContext("2d"))
                        .Line(data, {
                        responsive : true,
                        datasetFill: false,
                        bezierCurve : false,
                        //Number - 点一点的像素宽度
                        pointDotStrokeWidth : 1,
                        //Number -每个点的半径以像素为单位
                        pointDotRadius : 2,
                            //Number - 刻度像素宽度
                            scaleLineWidth : 1,
                        maintainAspectRatio : false
            });
         }
    });

        v/*ar data = {
            labels : [ "January", "February", "March", "April", "May",
                "June", "July" ],
            datasets : [ {
                label: '11111',

                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                data : [ 65, 59, 80, 81, 56, 199, 300 ]
            },{
                label: '22222',

                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                data : [ 15, 69, 77, 81, 90, 100, 189 ]
            }]
        };*/
       /* new Chart(document.getElementById("linechart").getContext("2d"))
                .Line(data, {
                    //Boolean - 是否显示刻度
                    scaleOverlay : false,
                    //Number - 刻度像素宽度
                    scaleLineWidth : 1,
                    //刻度线颜色
                    scaleLineColor : "rgba(0,0,0,.1)",
                    //Boolean - 是否展示Y轴
                    scaleShowLabels : true,
                    //Number - xy轴字体大小
                    scaleFontSize : 11,
                    //String - 标签字体重量样式
                    scaleFontStyle : "normal",
                    //String -表标签的字体颜色
                    scaleFontColor : "#777",
                    ///Boolean - 网格线是否显示在图表上？
                    scaleShowGridLines : true,
                    //String - 网格线的颜色
                    scaleGridLineColor : "rgba(0,0,0,.05)",
                    //Number - 网格线宽度
                    scaleGridLineWidth : 1,
                    //Boolean - 是否为每个点显示一个点
                    pointDot : true,
                    //Number -每个点的半径以像素为单位
                    pointDotRadius : 1,
                    //Number - 点一点的像素宽度
                    pointDotStrokeWidth : 1,
                    //Boolean - 是否为数据集显示笔划
                    datasetStroke : false,
                    //Boolean - 是否激活图表
                    animation : true,
                    //Number - 动画步骤数
                    animationSteps : 100,
                    //String - 动画效果
                    animationEasing : "easeOutQuart",
                    //Function - 当动画完成
                    onAnimationComplete : null,
                    responsive : true,
                    /!*是否有区域填充*!/
                    datasetFill: false,
                    /!*是否是曲线*!/
                    bezierCurve : false,
                    maintainAspectRatio : false
                });*/
    });
    //Chart.defaults.global.responsive = true;
</script>
</body>
</html>