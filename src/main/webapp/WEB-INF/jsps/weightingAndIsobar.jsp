<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cxt" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport' />
<meta name="description" content="Developed By M Abdur Rokib Promy" />
<meta name="keywords"
	content="Admin, Bootstrap 3, Template, Theme, Responsive" />
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
    <![endif]-->
</head>
<body>
	<form id="equalWeight">
		<div class="modal-footer">
			<button class="btn btn-primary" Text="等权" onclick="isobar(1)" name="">等权</button>
			<button class="btn" data-dismiss="modal" Text="债务加权"
				onclick="weighted(2)">债务加权</button>
		</div>
		<div style="width: 40%;">
			<canvas id="canvas"></canvas>
		</div>
	</form>
	<table id="table">
		<thead>
			<tr>
				<th>空白 </th>
			<c:forEach items="${list}" var="t">
				<th>${t}</th>
			</c:forEach>
				<th>操作 </th>
			</tr>
		</thead>
	</table>
	<div style="left: 300px;">
		<form id="download">
			<div style="left: 300px;">
				<div>
					<span style="font-size: 22px; font-family: Arial, Helvetica">指数介绍</span>
				</div>
				<textarea id="TextArea1" cols="50" rows="10" name="creditRisk"
					style="color: #9e9e9e"  readonly="readonly">
        行业信贷风险指数(Industry Credit Risk Index)衡量并描述了国内10个大类行业的综合债务违约风险的一套信用风险指数体系。
        指数以全体A股上市企业为样本，依据证监会行业分类标准，基于算数平均法、债务加权法等2种方法
            </textarea>
			</div>
			<div>
				<span>下载:</span> <a href="#" onclick="addPDF()">编制方法.pdf</a>
			</div>
		</form>
	</div>
	<br>
	<br>
	<script>
		$('#table')
				.bootstrapTable(
						{
							url : "${ctx}/json/table/list.json",
							method : 'get',
							dataType : 'json',
							/* showHeader:false,*/
							striped : true,
							pageNumber : 1, //初始化加载第一页，默认第一页
							pageSize : 5,
							pageList : [ 5 ],
							pagination : true,
							columns : [
									{
										field : 'username'
									},
									{
										field : 'garch',
										formatter : function(value, row, index) {
											if ('1' == row.garch) {
												return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
											} else {
												return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
											}
										}
									},
									{
										field : 'merton',
										formatter : function(value, row, index) {
											if ('1' == row.merton) {
												return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
											} else {
												return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
											}
										}
									},
									{
										field : 'quke',
										formatter : function(value, row, index) {
											if ('1' == row.quke) {
												return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
											} else {
												return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
											}
										}
									},
									{
										field : 'cf',
										formatter : function(value, row, index) {
											if ('1' == row.cf) {
												return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
											} else {
												return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
											}
										}
									},
									{
										field : 'liudong',
										formatter : function(value, row, index) {
											if ('1' == row.liudong) {
												return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
											} else {

												return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
											}
										}
									},
									{
										field : 'caozup',
										formatter : function(value, row, index) {
											return "<a href='#'onclick='toUpdateManager("
													+ row.id
													+ ")'>修改</a>|<a href='#'onclick='del("
													+ row.id + ")'>删除</a>"
										}
									} ],
							responseHandler : function(res) {

								return res;
							}
						});
		var config;
		var colorNames;
		var colorName;
		var newColor;
		var newDataset;
		var newTest = '行业信贷风险指数';
		$(function() {
			$.ajax({
				url : '${ctx}/mp/selectData',
				type : 'post',
				dataType : 'json',
				success : function(data) {
					console.log(data);
					config = {
						type : 'line',
						data : data,
						options : {
							responsive : true,
							title : {
								display : true,
								text : newTest
							},
							tooltips : {
								mode : 'index',
								intersect : false
							},
							hover : {
								mode : 'nearest',
								intersect : true
							}
						}
					};
					var ctx = document.getElementById("canvas")
							.getContext("2d");
					window.myLine = new Chart(ctx, config);
				}
			});
		});
		function addPDF() {
			$.ajax({
				url : '${ctx}/mp/downloadPDF',
				type : 'post',
				data : $('#download').serialize(),
				dataType : 'json',
				success : function(data) {
					console.log(data);
					alert("文件已生成:E:/指数介绍.pdf");
				}
			});
		}
	</script>
</body>
</html>