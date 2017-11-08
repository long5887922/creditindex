<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'/>
    <meta name="description" content="Developed By M Abdur Rokib Promy"/>
    <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive"/>
    <link href="${ctx}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/bootstrap/css/bootstrap-table.min.css" rel="stylesheet">
    <script src="${cxt}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript">
    </script>
    <script src="${cxt}/bootstrap/js/bootstrap-table-all.min.js"></script>
    <script src="${cxt}/bootstrap/js/bootstrap-table-zh-CN.js"></script>
    <script src="${cxt}/js/plugins/chart.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/utils.js" type="text/javascript"></script>
    <script src="${cxt}/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="${cxt}/js/Echarts/indexUtil.js" type="text/javascript"></script>
    <![endif]-->
</head>
<body>
<div style="width:99%;">
    <div align="left" style="margin-left:10px;;margin-top:10px;">
        <span style="font-size: 20px;" id="index"><strong>信贷指数:</strong></span>
        <select id="selectTest" name="select" onchange="ch2()"style="width:150px;height: 32px;font-size: 16px;">
            <option value="01" selected>等权</option>
            <option value="02">加权</option>
        </select>
    </div>
    <div style="width: 45%;margin-left:10px;margin-top:10px;">
        <div>
            <div>
                <div style="width:100%;height:20px;float:left;margin-left:660px;">
                    <div style="height: 395px;width: 573px; border-bottom:solid 1px #34394A; border-left:solid 1px #34394A; border-right:solid 1px #34394A; border-top:solid 1px #34394A">
                        <div align="left"><label id="lable" style="font-size: 20px;"><strong>指数值</strong></label></div>

                        <table class="table" id="table" style="border:none;">
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
                                        <a href='#'
                                           onclick='openLineWindon("${idri.id}","${idri.startTime}","${idri.endTime}")'>
                                            <img src="../../img/app/chart.png">
                                        </a>
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
                        <table class="table" id="weight" style="display:none">
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
                                        <a href='#'
                                           onclick='openLineWindon("${idri.id}","${idri.startTime}","${idri.endTime}")'>
                                            <img src="../../img/app/chart.png">
                                        </a>
                                    </td>
                                    <c:forEach items="${weighting}" var="w">
                                        <c:if test="${w.inducode eq idri.id}">
                                            <td>
                                                    ${w.idri}
                                            </td>
                                        </c:if>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div style="width: 625px;height: 393px; border-bottom:solid 1px #34394A; border-left:solid 1px #34394A; border-right:solid 1px #34394A; border-top:solid 1px #34394A">
            <div style="width:620px;height: 370px;">
                <img id="changeJPG" src="../../img/lineAndShap.jpg" width="620px" height="370px">
            </div>
        </div>
    </div>

    <div style="width: 45%;">
        <form id="download">
            <div style="margin-left:10px;">
                <div>
                    <div style="width:20%;height:30px;float:left;margin-left:650px;">
                        <%@include file="IndustryRanking/IndustryRanking.jsp" %>
                    </div>
                </div>

                <br>
            </div>
            <div style="width: 625px;height: 300px;margin-left:10px;border-bottom:solid 1px #34394A; border-left:solid 1px #34394A; border-right:solid 1px #34394A; border-top:solid 1px #34394A">
                <span id="spa" style="font-size: 20px;"><strong>指数介绍</strong></span>
			<textarea id="TextArea1" cols="60" rows="10" name="creditRisk" a
                      style="background:transparent;border-style:none; color: #222;width: 600px;resize: none;">
     行业信贷风险指数（Industry Credit Risk Index）衡量并描述了国内8个大类行业的综合债务违约风险的一套信用风险指数体系。指数以全体A股上市企业为样本，依据证监会行业分类标准，基于算数平均法、债务加权法等2种方法，进行自下而上的指数计算，让使用者从不同角度和侧重追踪和分析各行业的信用违约风险水平与趋势，为国内信贷和债券市场提供了一个“风向标”和“指示器”。
   行业信贷风险指数的数据采集均来自公开市场交易、上市企业季报、年报等公开数据。指数成分样本的筛选和权重的计算循序《行业信贷风险指数的编制方法》，后经指数评审委员会的最后确认而形成。个体预期违约概率经流动性指标模型、Merton违约概率模型、“壳”价值修正模型等的计算得出，并按相应指数计算公式计算出最终指数。
            </textarea>
                <div>
                    <%--<span>下载:</span> <a href="#" onclick="addPDF()">编制方法.pdf</a>--%>
                    <%--<a href="http://localhost:8282/mp/Download">下载:行业违约风险指数编制方法</a><br>--%>
                        <a href="/img/IDRICM.pdf">下载:行业违约风险指数编制方法</a><%--“http://localhost:8282”此域名可省，工程自行提供--%>
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

    var code;
    $(function () {
        $("#showLine").on("hidden.bs.modal", function () {
            $('#canvas').remove();
        });
        code = window.localStorage.getItem("theme");

        skin(code, true);
    });
    function skin(code, clientFlag) {
        w = $('#selectTest').val();
        $("#table th tr td").attr({bordr: 0});
        if (code == "black") {
            document.body.style.backgroundColor = "#1E2131";
            $("#table tr td").css({color: "#999"});
            $("#table th").css({color: "#8dbff3"});

            $("#weight tr td").css({color: "#999"});
            $("#weight th").css({color: "#8dbff3"});
            $("#weight th").css({backgroundColor: "#34394A"});
            $("#showLine").css({backgroundColor: "#34394A"});
            $("#lable").css({color: "#fff"});
            $("#index").css({color: "#fff"});
            $("#spa").css({color: "#fff"});
            $("#down").css({color: "#fff"});
            $("#TextArea1").css({backgroundColor: "#1E2131"});
            $("#selectTest").css({backgroundColor: "#34394A"});
            $("#TextArea1").css({color: "#999"});
            $("#selectTest").css({color: "#999"});
            if (w == "02") {
                $("#changeJPG").attr("src", "../../img/lineAndShapWeightBlack.jpg");
            } else {
                $("#changeJPG").attr("src", "../../img/lineAndShapBlack.jpg");
            }
        } else if (code == "white") {
            // document.body.style.backgroundColor="#ff9999";
            $("#table tr td").css({color: "#333"})
            $("#table th").css({color: "#222"});
            $("#weighting tr td").css({color: "#333"})
            $("#weight th").css({color: "#222"});
            $("#lable").css({color: "#222"});
            $("#spa").css({color: "#222"});
            $("#down").css({color: "#222"});
            $("#index").css({color: "#222"});
            if (w == "02") {
                $("#changeJPG").attr("src", "../../img/lineAndShapWeighting.jpg");
            } else {
                $("#changeJPG").attr("src", "../../img/lineAndShap.jpg");
            }
        }
    }
    $('#selectTest').change(function () {
        code = window.localStorage.getItem("theme");

        w = $('#selectTest').val();
        if (w == '02') {
            $("#weight").show();
            $("#table").hide();

            if (code == "black") {
                //alert("111");
                $("#changeJPG").attr("src", "../../img/lineAndShapWeightBlack.jpg");
            } else {
                $("#changeJPG").attr("src", "../../img/lineAndShapWeighting.jpg");
                // alert("2222");
            }
        } else {
            $("#weight").hide();
            $("#table").show();
            if (code == "black") {
                // alert("333");
                $("#changeJPG").attr("src", "../../img/lineAndShapBlack.jpg");
            } else {
                //alert("4444");
                $("#changeJPG").attr("src", "../../img/lineAndShap.jpg");
            }
        }
    });
    $('#weight').bootstrapTable();
    $('#table').bootstrapTable();
    function openLineWindon(id, startTime, endTime) {
        $('#lineChartParent').append('<canvas id="canvas" height="98px"></canvas>');
        var config;
        var newTest;
        w = $('#selectTest').val();
        if (w == '02') {
            newTest = '加权';
        }
        if (w == '01') {
            newTest = '等权';
        }

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
   /* function addPDF() {
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
    }*/
</script>
</body>
</html>