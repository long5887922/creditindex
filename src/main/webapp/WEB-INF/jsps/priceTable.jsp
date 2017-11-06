<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'/>

    <META HTTP-EQUIV="pragma" CONTENT="no-cache">

    <link href="${ctx}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.0/bootstrap-table.min.css" rel="stylesheet">
    <script src="${cxt}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/chart.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/utils.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.8.1/bootstrap-table-all.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.8.1/locale/bootstrap-table-zh-CN.js"></script>
    <style>
        .table th, .table td {
            text-align: center;
            height: 38px;
        }
    </style>
</head>
<body>
<div>
    <div class="modal-footer">
        <select id="selectTest" name="select">
            <option value="01" selected>等权</option>
            <option value="02">加权</option>
        </select>
    </div>
    <table id="table">
        <thead>
        <tr>
            <th>行业名称</th>
            <th></th>
            <c:forEach items="${list}" var="t">
                <th>${t}</th>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list2}" var="idri" varStatus="t">
            <tr>
                <td>
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
    <table id="weighting" style="display:none">
        <thead>
        <tr>
            <th>行业名称</th>
            <th></th>
            <c:forEach  items="${list}" var="t">
                <th>${t}</th>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list2}" var="idri" varStatus="t">
            <tr>
                <td>
                        ${idri.username}
                </td>
                <td>
                    <a href='#'onclick='openLineWindon("${idri.id}","${idri.startTime}","${idri.endTime}")'><span class='glyphicon glyphicon-signal'></span></a>
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
<div id="showLine" data-backdrop="static" class="modal col-md-6 col-md-offset-3"
     style="height: 354px;background: #fff; margin-top: 30px; margin-bottom: 50px;" tabindex="-1" role="dialog"
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

</script>
</body>
</html>