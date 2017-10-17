<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    String basePath =request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path+"/";
%>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=basePath%>bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="<%=basePath%>bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.0/bootstrap-table.min.css" rel="stylesheet">

    <script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.8.1/bootstrap-table-all.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.8.1/locale/bootstrap-table-zh-CN.js"></script>
    <style>
        .table th, .table td {
            text-align: center;
            height:38px;
        }
        .td{
            font-size: 14px;
            font-weight: 400;
            font-style: normal;
            text-decoration: none;
            font-family: 微软雅黑;
            color: rgb(0, 0, 0);

            box-sizing: border-box;
            overflow: hidden;
            vertical-align: middle !important;
            text-align: center;
            height: 60px;
        }
    </style>
</head>
<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<div class="container">
    <div class="row">
        <div class="row">
            <div class="col-md-10">
                <ul class="list-group">
                    <a class="list-group-item"> 行业信贷违约风险指数>管理员维护 </a>
                </ul>
            </div>
            <form id="">
                <div class="col-md-10" >
                    <div>
                        <ul class="list-group">
                            <a class="list-group-item" style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">管理员维护</a>
                        </ul>
                        <table width="100%" height="44" border="0">
                            <tr>
                                <td width="273" align="left"></td>
                                <td width="353" align="right" ><a id="AddChannelTemplatePage" href="#" >添加管理员</a></td>
                            </tr>
                         </table>
                        <table id="table"></table>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="addModal" class="modal col-md-6 col-md-offset-3" style="background: #fff; margin-top: 30px; margin-bottom: 50px;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header" style="padding: 0px;">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h5 id="myModalLabel">添加管理员</h5>
    </div>
    <form id="addUserManager" action="">
        <div class="modal-body">
            <div class="form-group">
                <div class="form-group">
                    <label>用户名</label>
                    <input type="text" id="name" name="name" class="form-control" placeholder="请输入用户名">
                </div>
               <div>
                   权限：
               </div>
                <div class="checkbox">
                    <ul id="lists">
                        <li><label><input type="checkbox" value="1"/>GARCH模型</label></li>
                        <li><label><input type="checkbox" value="2"/>Merton模型</label></li>
                        <li><label><input type="checkbox" value="3"/>去壳模型</label></li>
                        <li><label><input type="checkbox" value="4"/>ConishFisher模型</label></li>
                        <li><label><input type="checkbox" value="5"/>流动性检验模型</label></li>
                    </ul>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary"  Text="添加" onclick="add()" >添加</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    /*列表*/
    $('#table').bootstrapTable({
        url : "${pageContent.request.contentPath}/json/table/list.json",
        method : 'get',
        dataType : 'json',
        striped : true,
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 5,
        pagination : true,
        columns : [{
            field : 'username',
            title : '用戶名'
        }, {
            field : 'garch',
            title : 'GARCH模型'
        }, {
            field : 'merton',
            title : 'Merton模型'
        }, {
            field : 'quke',
            title : '去壳模型'
        }, {
            field : 'cf',
            title : 'CF模型'
        }, {
            field : 'liudong',
            title : '流动性模型'
        }, {
            field : 'caozup',
            title : '操作',
            formatter :function(value,row,index){
                return "<a href='#'onclick='toUpdateManager()'>修改</a>|<a href='#'onclick='del()'>删除</a>"
            }
        }]
    });
    /*打开添加窗口*/
    $('#AddChannelTemplatePage').click(function () {
        $('#addModal').modal('show');
        $("#lists :checkbox").attr("checked", false);

    });
    /*添加成功后隐藏窗口并刷新主页面*/
    function add(){
        alert("添加成功");
        $('#addModal').modal('hide');
        window.location.reload();
    }
    /*显示弹出的修改页面*/
    function toUpdateManager(){
        alert('1');
        $('updateModal').modal('show');
    }
    /*function updateManager(){
        alert("修改成功");
        $('#updateModal').modal('hide');
        window.location.reload();
    }*/

</script>
</html>