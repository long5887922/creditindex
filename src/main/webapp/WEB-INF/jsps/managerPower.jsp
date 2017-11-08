<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${ctx}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/bootstrap/css/bootstrap-table.min.css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx}/bootstrap/js/bootstrap-table-all.min.js"></script>
    <script src="${ctx}/bootstrap/js/bootstrap-table-zh-CN.js"></script>

    <style>
        .table th, .table td {
            text-align: center;
            height:38px;
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
                                <td width="353" align="right" ><a id="AddChannelTemplatePage" href="#" ><span class="glyphicon glyphicon-user"></span>添加管理员 </a></td>
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
                    <input type="text"  name="username" class="form-control" placeholder="请输入用户名">
                    <label>密码</label>
                    <input type="text"  name="password" class="form-control" placeholder="请输入密码">
                </div>
                <div>
                    权限：
                </div>
                <div class="checkbox" >
                    <ul id="lists">
                        <li><label><input name="garch" type="checkbox" value="1"/>GARCH模型</label></li>
                        <li><label><input name="merton" type="checkbox" value="2"/>Merton模型</label></li>
                        <li><label><input name="quke" type="checkbox" value="3"/>去壳模型</label></li>
                        <li><label><input name="cf" type="checkbox" value="4"/>ConishFisher模型</label></li>
                        <li><label><input name="liudong" type="checkbox" value="5"/>流动性检验模型</label></li>
                    </ul>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary"  Text="添加" onclick="addManager()" >添加</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
            </div>
        </div>
    </form>
</div>

<div id="updateModal" class="modal col-md-6 col-md-offset-3" style="background: #fff; margin-top: 30px; margin-bottom: 50px;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header" style="padding: 0px;">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h5 id="updateMyModalLabel">修改管理员</h5>
    </div>
    <form id="updateUserManager" action="">
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
                    <ul id="list2">
                        <li><label><input name="garch" type="checkbox" value="1"/>GARCH模型</label></li>
                        <li><label><input name="merton" type="checkbox" value="1"/>Merton模型</label></li>
                        <li><label><input name="quke" type="checkbox" value="1"/>去壳模型</label></li>
                        <li><label><input name="cf" type="checkbox" value="1"/>ConishFisher模型</label></li>
                        <li><label><input name="liudong" type="checkbox" value="1"/>流动性检验模型</label></li>
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
        url : "${ctx}/json/table/list.json",
        method : 'get',
        dataType : 'json',
        /* showHeader:false,*/
        striped : true,
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 5,
        pageList: [5],
        pagination : true,
        columns : [{
            field : 'username',
            title : '用戶名'
        }, {
            field : 'one',
            title : 'GARCH模型',
            formatter :function(value,row,index){
                if('1' == row.one){
                    return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                }else{
                    return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                }
            }
        }, {
            field : 'two',
            title : 'Merton模型',
            formatter :function(value,row,index){
                if('1' == row.two){
                    return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                }else{
                    return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                }
            }
        }, {
            field : 'three',
            title : '去壳模型',
            formatter :function(value,row,index){
                if('1' == row.three){
                    return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                }else{
                    return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                }
            }
        }, {
            field : 'four',
            title : 'CF模型',
            formatter :function(value,row,index){
                if('1' == row.four){
                    return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                }else{
                    return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                }
            }
        }, {
            field : 'five',
            title : '流动性模型',
            formatter :function(value,row,index){
                if('1' == row.five){
                    return '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>';
                }else{

                    return '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
                }
            }
        }, {
            field : 'caozup',
            title : '操作',
            formatter :function(value,row,index){
                var a=row.id+","+row.one;
                return "<a href='#'onclick='toUpdateManager("+row.id+","+row.one+")'>修改</a>|<a href='#'onclick='del("+row.id+")'>删除</a>"
            }
        }]
    });
    /*打开添加窗口*/
    $('#AddChannelTemplatePage').click(function () {
        $('#addModal').modal('show');
        $("#lists :checkbox").attr("checked", false);

    });
    /*添加成功后隐藏窗口并刷新主页面*/
    function addManager(){
        $.ajax({
            url:'${ctx}/mp/addManager',
            type:'post',
            data : $('#addUserManager').serialize(),
            dataType:'json',
            success:function(data){
                console.log(data);
                $('#addModal').modal('hide');
                window.location.reload();
            }
        });
    }
    /*显示弹出的修改页面*/
    function toUpdateManager(id,name){
        $('#updateModal').modal('show');
    }
</script>
</html>