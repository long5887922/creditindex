<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta
            content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
            name='viewport'/>
    <meta name="description" content="Developed By M Abdur Rokib Promy"/>
    <meta name="keywords"
          content="Admin, Bootstrap 3, Template, Theme, Responsive"/>
    <link href="${ctx}/bootstrap/css/bootstrap.css" type="text/css"
          rel="stylesheet">
    <link
            href="https://cdn.bootcss.com/bootstrap-table/1.11.0/bootstrap-table.min.css"
            rel="stylesheet">
    <script src="${cxt}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/daterangepicker/daterangepicker.js"
            type="text/javascript"></script>
    <script
            src="https://cdn.bootcss.com/bootstrap-table/1.8.1/bootstrap-table-all.min.js"></script>
    <script
            src="https://cdn.bootcss.com/bootstrap-table/1.8.1/locale/bootstrap-table-zh-CN.js"></script>
    <script src="${cxt}/js/plugins/chart.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/utils.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/iCheck/icheck.min.js"
            type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="${cxt}/js/Echarts/indexUtil.js" type="text/javascript"></script>
    <![endif]-->
</head>
<body>
<div style="width:99%;">
    <div align="left">
        <span>信贷指数</span>
        <select id="selectTest" name="select"onchange="ch2()">
            <option value="01" selected>等权</option>
            <option value="02">加权</option>
        </select>
    </div>

    <div style="width: 45%;float:left;">
        <img src="../../img/lineAndShap.jpg" width="560px" height="400px">
    </div>
    <div style="width: 52%;float:left;margin-top:10px;" align="right">
        <div align="left"><label>指数值</label></div>
        <table class="table" id="table">
            <thead>
            <tr>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th></th>
                <c:forEach items="${list}" var="t">
                    <th>${t}</th>
                </c:forEach>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list2}" var="idri" varStatus="t">
                <tr>
                    <td class="text-center">
                            ${idri.username}
                    </td>
                    <td>
                        <a href='#' onclick='openLineWindon("${idri.id}","${idri.startTime}","${idri.endTime}")'><span
                                class='glyphicon glyphicon-signal'></span></a>
                    </td>
                    <c:forEach items="${bodyList}" var="beans">
                        <c:if test="${beans.inducode eq idri.id}">
                            <td>
                                    ${beans.idri}
                            </td>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table class="table" id="weighting" style="display:none" border="1">
            <thead>
            <tr>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th></th>
                <c:forEach items="${list}" var="t">
                    <th>${t}</th>
                </c:forEach>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list2}" var="idri" varStatus="t">
                <tr>
                    <td class="text-center">
                            ${idri.username}
                    </td>
                    <td>
                        <a href='#' onclick='openLineWindon("${idri.id}","${idri.startTime}","${idri.endTime}")'><span
                                class='glyphicon glyphicon-signal'></span></a>
                    </td>
                    <c:forEach items="${weighting}" var="weight">
                        <c:if test="${weight.inducode eq idri.id}">
                            <td>
                                    ${weight.idri}
                            </td>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div style="width: 45%;">
        <form id="download">
            <div>
                <div>
                    <div style="width:20%;height:30px;float:left;margin-left:600px;">
                        <%@include file="IndustryRanking/IndustryRanking.jsp"%>
                    </div>
                </div>
                <span>指数介绍</span>
                <br>
            </div>
            <div>
			<textarea id="TextArea1" cols="50" rows="10" name="creditRisk"
                      style="color: #9e9e9e;width: 560px;height: 180px;">
        行业信贷风险指数(Industry Credit Risk Index)衡量并描述了国内10个大类行业的综合债务违约风险的一套信用风险指数体系。
        指数以全体A股上市企业为样本，依据证监会行业分类标准，基于算数平均法、债务加权法等2种方法
            </textarea>
                <br> <br> <br> <br> <br> <br>
                <div>
                    <span>下载:</span> <a href="#" onclick="addPDF()">编制方法.pdf</a>
                </div>
            </div>

        </form>
    </div>
    <div id="showLine" data-backdrop="static" class="modal col-md-6 col-md-offset-3"
         style="height: 354px;background: #fff; margin-top: 70px; margin-bottom: 50px;" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-header" style="padding: 0px;">
            <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        <div class="modal-body">
            <div class="form-group" id="lineChartParent">
                <canvas id="canvas" height="98px"></canvas>
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#showLine").on("hidden.bs.modal", function () {
            $('#canvas').remove();
        });
    });
    $('#selectTest').change(function () {
        w = $('#selectTest').val();
        if (w == '02') {
            $('#weighting').bootstrapTable();
            $("#weighting").show();
            $("#table").hide();
        }
        if (w == '01') {
            $("#weighting").hide();
            $("#table").show();
        }
    });
    $('#table').bootstrapTable();
    function openLineWindon(id, startTime, endTime) {
        $('#lineChartParent').append('<canvas id="canvas" height="98px"></canvas>');
        var config;
        var newTest = '等权';
        $.ajax({
            url: '${ctx}/um/tradeLineChart',
            type: 'post',
            cache: false,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({
                id: id,
                creditorType: $('#selectTest').val(),
                startTime: startTime,
                endTime: endTime
            }),
            dataType: 'json',
            success: function (data) {
                console.log(data);

                config = {
                    type: 'line',
                    data: data,
                    options: {
                        responsive: true,
                        title: {
                            display: true,
                            text: newTest
                        },
                        tooltips: {
                            mode: 'index',
                            intersect: false
                        },
                        hover: {
                            mode: 'nearest',
                            intersect: false
                        }
                    }
                };
                var ctx = document.getElementById("canvas").getContext("2d");
                window.myLine = new Chart(ctx, config);
            }
        });
        $('#showLine').modal('show');
    }
    function addPDF() {
        $.ajax({
            url: '${ctx}/mp/downloadPDF',
            type: 'post',
            data: $('#download').serialize(),
            dataType: 'json',
            success: function (data) {
                console.log(data);
                alert("文档已下载至：E:/指数介绍.pdf");
            }, error: function (data) {
                alert("文件导出失败");
            }
        });
    }
</script>
</body>
</html>