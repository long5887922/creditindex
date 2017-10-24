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
<form id="equalWeight">
<div class="modal-footer">
    <button class="btn btn-primary"  Text="等权" onclick="isobar(1)" name="">等权</button>
    <button class="btn" data-dismiss="modal"  Text="债务加权" onclick="weighted(2)" >债务加权</button>
</div>
<div style="width:40%;">
    <canvas id="canvas"></canvas>
</div>
</form>
<div style="left: 300px;">
    <form id="credit">
        <div style="left: 300px;">
            <textarea id="TextArea1" cols="50" rows="10" name="creditRisk">
                行业信贷风险指数(Industry Credit Risk Index)衡量并描述了国内10个大类行业的综合债务违约风险的一套信用风险指数体系。
                指数以全体A股上市企业为样本，依据证监会行业分类标准，基于算数平均法、债务加权法等2种方法
            </textarea>
        </div>
        <div>
            <%--<a href="#" onclick="addPDF()">编制方法.pdf</a>--%>
                <a href="/Download" >编制方法.pdf</a>
        </div>
    </form>
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