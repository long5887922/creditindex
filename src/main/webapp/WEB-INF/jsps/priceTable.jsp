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
    <![endif]-->
    <style>
        .table th, .table td {
            text-align: center;
            height:38px;
        }
    </style>
</head>
<body>
<div>
    <table id="table">
        <thead>
        <tr>
            <th></th>
            <th></th>
            <c:forEach items="${list}" var="t">
                <th>${t}</th>
            </c:forEach>

        </tr>
        </thead>
    </table>
</div>
<script>
    $('#table')
            .bootstrapTable(
            {
                url: "${ctx}/um/list9.json",
                method: 'get',
                dataType: 'json',
                /* showHeader:false,*/
                striped: true,
                pageNumber: 1, //初始化加载第一页，默认第一页
                pageSize: 5,
                pageList: [5],
                pagination: true,
                columns: [
                    {
                        field: 'username'
                    },
                    {
                        formatter: function (value, row, index) {

                            var ul="<a href='#'onclick='toUpdateManager("+row.username+")'><span class='glyphicon glyphicon-signal'></span></a>"
                            return ul;
                        }
                    },
                    {
                        field: 'garch',
                        formatter: function (value, row, index) {
                            if ('1' == row.garch) {
                                return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                            } else {
                                return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                            }
                        }
                    },
                    {
                        field: 'merton',
                        formatter: function (value, row, index) {
                            if ('1' == row.merton) {
                                return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                            } else {
                                return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                            }
                        }
                    },
                    {
                        field: 'quke',
                        formatter: function (value, row, index) {
                            if ('1' == row.quke) {
                                return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                            } else {
                                return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                            }
                        }
                    },
                    {
                        field: 'cf',
                        formatter: function (value, row, index) {
                            if ('1' == row.cf) {
                                return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                            } else {
                                return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                            }
                        }
                    },
                    {
                        field: 'liudong',
                        formatter: function (value, row, index) {
                            if ('1' == row.liudong) {
                                return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                            } else {

                                return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                            }
                        }
                    }
                    ],
              /*  responseHandler: function (res) {

                    return res;
                }*/
            });
    function toUpdateManager(name){

        alert(name);
    }
</script>
</body>
</html>