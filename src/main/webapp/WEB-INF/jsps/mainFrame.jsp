<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${ctx}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
    <link href="${ctx}/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <style>
       /* .td20{width:20%; background:#ccc; }
        .td80{width:80%;background:#fafafa;}
        .table>tbody>tr>td {
            border-top: 1% solid #fff;
        }*/
       .div-inline{ display:inline}
    </style>
</head>
<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<div class="container">
    <div class="row">
        <div class="row">
            <div class="col-md-9">
                <ul class="list-group">
                    <a class="list-group-item"> 行业信贷违约风险指数>首页 </a>
                </ul>
            </div>
            <div class="col-md-9" >
                <div>
                    <ul class="list-group">
                        <a class="list-group-item" style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);"> 参数统览</a>
                    </ul>
                    <table align="left" border="0"cellpadding="0" cellspacing="0" style="table-layout:fixed">
                        <tr>
                            <td width="17%" align="center">
                                <div style="left: 389px; top: 212px; width: 118px; height: 60px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 10; transform: scaleX(1) scaleY(1);">
                                    <div  style=" width: 100%; height: 100%; left: 0px; top: 0px; overflow: hidden; box-sizing: border-box;">
                                        <div  style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; box-sizing: border-box; border-radius: 0px; background-color: rgb(204, 204, 204);"></div>
                                        <div style="width: 116px; height: 60px; position: absolute; left: 1px; z-index: 10;">
                                            <div style="font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0); left: 0px; top: 0px; width: 116px; height: 60px; position: relative; overflow-wrap: break-word; box-sizing: border-box; z-index: 1; line-height: 18px; overflow: hidden;">
                                                <div style="text-align: center; left: 0px; width: 116px; overflow: hidden; position: absolute; line-height: inherit; top: 50%; transform: translateY(-50%);">
                                                    <p style="margin: 0px; padding: 0px; width: 116px; transform: scale(1); transform-origin: left top 0px; text-overflow: clip; white-space: normal; text-align: center; text-decoration: none;">
                                                        <span>GARCH模型</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td align="center" width="25%">
                                <div>
                                    <div  style="left: 0px; top: 250px; width: 112px; height: 19px; padding: 1px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 19; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                        <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                            <div style="width: auto; height: auto; text-align: left;">
                                                <div style="width: auto; height: auto;">
                                                    <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                        年限计算临界值：
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style="left: 702px; top: 228px; width: 12px; height: 27px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 20; line-height: 26px; transform: scaleX(1) scaleY(1);">
                                    <div class="context"  style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 27px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 20px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);">
                                                    5
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style="left: 740px; top: 233px; width: 14px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 21; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label  style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    年
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="10%">
                                <div  style="left: 1785px; top: 233px; width: 98px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 37; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    最新修改时间：
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="40%">
                                <div style="left: 890px; top: 226px; width: 212px; height: 25px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 38; line-height: 24px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 24px;"><div style="width: auto; height: auto; text-align: left;">
                                        <div style="width: auto; height: auto;">
                                            <label style="white-space: nowrap; text-align: left; font-size: 18px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                2017年6月30日 &nbsp;19:33:12
                                            </label>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="17%" align="center">
                                <div style="left: 389px; top: 212px; width: 118px; height: 60px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 10; transform: scaleX(1) scaleY(1);">
                                    <div  style=" width: 100%; height: 100%; left: 0px; top: 0px; overflow: hidden; box-sizing: border-box;">
                                        <div  style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; box-sizing: border-box; border-radius: 0px; background-color: rgb(204, 204, 204);"></div>
                                        <div style="width: 116px; height: 60px; position: absolute; left: 1px; z-index: 10;">
                                            <div style="font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0); left: 0px; top: 0px; width: 116px; height: 60px; position: relative; overflow-wrap: break-word; box-sizing: border-box; z-index: 1; line-height: 18px; overflow: hidden;">
                                                <div style="text-align: center; left: 0px; width: 116px; overflow: hidden; position: absolute; line-height: inherit; top: 50%; transform: translateY(-50%);">
                                                    <p style="margin: 0px; padding: 0px; width: 116px; transform: scale(1); transform-origin: left top 0px; text-overflow: clip; white-space: normal; text-align: center; text-decoration: none;">
                                                        <span>Merton模型</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="25%" align="center">
                                <div>
                                    <div  style="left: 0px; top: 250px; width: 112px; height: 19px; padding: 1px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 19; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                        <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                            <div style="width: auto; height: auto; text-align: left;">
                                                <div style="width: auto; height: auto;">
                                                    <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                        非流动负债调整系数：
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style="left: 702px; top: 228px; width: 12px; height: 27px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 20; line-height: 26px; transform: scaleX(1) scaleY(1);">
                                    <div class="context"  style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 27px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 20px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);">
                                                    5
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style="left: 740px; top: 233px; width: 14px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 21; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label  style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    倍
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="10%">
                                <div  style="left: 1785px; top: 233px; width: 98px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 37; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    最新修改时间：
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="40%">
                                <div style="left: 890px; top: 226px; width: 212px; height: 25px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 38; line-height: 24px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 24px;"><div style="width: auto; height: auto; text-align: left;">
                                        <div style="width: auto; height: auto;">
                                            <label style="white-space: nowrap; text-align: left; font-size: 18px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                2017年6月30日 &nbsp;19:33:12
                                            </label>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="17%" align="center">
                                <div style="left: 389px; top: 212px; width: 118px; height: 60px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 10; transform: scaleX(1) scaleY(1);">
                                    <div  style=" width: 100%; height: 100%; left: 0px; top: 0px; overflow: hidden; box-sizing: border-box;">
                                        <div  style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; box-sizing: border-box; border-radius: 0px; background-color: rgb(204, 204, 204);"></div>
                                        <div style="width: 116px; height: 60px; position: absolute; left: 1px; z-index: 10;">
                                            <div style="font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0); left: 0px; top: 0px; width: 116px; height: 60px; position: relative; overflow-wrap: break-word; box-sizing: border-box; z-index: 1; line-height: 18px; overflow: hidden;">
                                                <div style="text-align: center; left: 0px; width: 116px; overflow: hidden; position: absolute; line-height: inherit; top: 50%; transform: translateY(-50%);">
                                                    <p style="margin: 0px; padding: 0px; width: 116px; transform: scale(1); transform-origin: left top 0px; text-overflow: clip; white-space: normal; text-align: center; text-decoration: none;">
                                                        <span>去壳模型</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="25%" align="center">
                                <div>
                                    <div  style="left: 0px; top: 250px; width: 112px; height: 19px; padding: 1px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 19; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                        <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                            <div style="width: auto; height: auto; text-align: left;">
                                                <div style="width: auto; height: auto;">
                                                    <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                        壳价值计算临界值：
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style="left: 702px; top: 228px; width: 12px; height: 27px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 20; line-height: 26px; transform: scaleX(1) scaleY(1);">
                                    <div class="context"  style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 27px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 20px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);">
                                                    5
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style=" top: 233px; width: 21px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 21; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label  style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    亿元
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="10%">
                                <div  style="left: 1785px; top: 233px; width: 98px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 37; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    最新修改时间：
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="40%">
                                <div style="left: 890px; top: 226px; width: 212px; height: 25px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 38; line-height: 24px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 24px;"><div style="width: auto; height: auto; text-align: left;">
                                        <div style="width: auto; height: auto;">
                                            <label style="white-space: nowrap; text-align: left; font-size: 18px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                2017年6月30日 &nbsp;19:33:12
                                            </label>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="17%" height="12%" align="center" rowspan="2">
                                <div style="left: 389px; top: 1px; width: 118px; height: 120px; padding: 30px;  visibility: visible; opacity: 1; z-index: 10; transform: scaleX(1) scaleY(1);">
                                    <div  style=" width: 100%; height: 100%; left: 0px; top: 0px; overflow: hidden; box-sizing: border-box;">
                                        <div  style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; box-sizing: border-box; border-radius: 0px; background-color: rgb(204, 204, 204);"></div>
                                        <div style="width: 116px; height: 60px; position: absolute; left: 1px; z-index: 10;">
                                            <div style="font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0); left: 0px; top: 0px; width: 116px; height: 60px; position: relative; overflow-wrap: break-word; box-sizing: border-box; z-index: 1; line-height: 18px; overflow: hidden;">
                                                <div style="text-align: center; left: 0px; width: 116px; overflow: hidden; position: absolute; line-height: inherit; top: 50%; transform: translateY(-50%);">
                                                    <p style="margin: 0px; padding: 0px; width: 116px; transform: scale(1); transform-origin: left top 0px; text-overflow: clip; white-space: normal; text-align: center; text-decoration: none;">
                                                        <span>CornishFisher模型</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="25%" align="center">
                                <div>
                                    <div  style="left: 0px; top: 250px; width: 112px; height: 19px; padding: 1px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 19; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                        <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                            <div style="width: auto; height: auto; text-align: left;">
                                                <div style="width: auto; height: auto;">
                                                    <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                        偏度函数计算后S值：
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style="left: 702px; top: 228px; width: 12px; height: 27px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 20; line-height: 26px; transform: scaleX(1) scaleY(1);">
                                    <div class="context"  style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 27px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 20px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);">
                                                    5
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style=" top: 233px; width: 21px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 21; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label  style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    亿元
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="10%">
                                <div  style="left: 1785px; top: 233px; width: 98px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 37; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    最新修改时间：
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="40%">
                                <div style="left: 890px; top: 226px; width: 212px; height: 25px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 38; line-height: 24px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 24px;"><div style="width: auto; height: auto; text-align: left;">
                                        <div style="width: auto; height: auto;">
                                            <label style="white-space: nowrap; text-align: left; font-size: 18px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                2017年6月30日 &nbsp;19:33:12
                                            </label>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <hr width=300 size=1 color=#5151A2 align=center noshade>
                        <tr>
                            <td width="25%" align="center">
                                <div>
                                    <div  style="left: 0px; top: 250px; width: 112px; height: 19px; padding: 1px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 19; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                        <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                            <div style="width: auto; height: auto; text-align: left;">
                                                <div style="width: auto; height: auto;">
                                                    <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                        峰度函数计算后K值：
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style="left: 702px; top: 228px; width: 12px; height: 27px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 20; line-height: 26px; transform: scaleX(1) scaleY(1);">
                                    <div class="context"  style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 27px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 20px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);">
                                                    70
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style=" top: 233px; width: 21px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 21; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label  style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    亿元
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="10%">
                                <div  style="left: 1785px; top: 233px; width: 98px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 37; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    最新修改时间：
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="40%">
                                <div style="left: 890px; top: 226px; width: 212px; height: 25px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 38; line-height: 24px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 24px;"><div style="width: auto; height: auto; text-align: left;">
                                        <div style="width: auto; height: auto;">
                                            <label style="white-space: nowrap; text-align: left; font-size: 18px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                2017年6月30日 &nbsp;19:33:12
                                            </label>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="17%" align="center">
                                <div style="left: 389px; top: 212px; width: 118px; height: 60px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 10; transform: scaleX(1) scaleY(1);">
                                    <div  style=" width: 100%; height: 100%; left: 0px; top: 0px; overflow: hidden; box-sizing: border-box;">
                                        <div  style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; box-sizing: border-box; border-radius: 0px; background-color: rgb(204, 204, 204);"></div>
                                        <div style="width: 116px; height: 60px; position: absolute; left: 1px; z-index: 10;">
                                            <div style="font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0); left: 0px; top: 0px; width: 116px; height: 60px; position: relative; overflow-wrap: break-word; box-sizing: border-box; z-index: 1; line-height: 18px; overflow: hidden;">
                                                <div style="text-align: center; left: 0px; width: 116px; overflow: hidden; position: absolute; line-height: inherit; top: 50%; transform: translateY(-50%);">
                                                    <p style="margin: 0px; padding: 0px; width: 116px; transform: scale(1); transform-origin: left top 0px; text-overflow: clip; white-space: normal; text-align: center; text-decoration: none;">
                                                        <span>流动性检验模型</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td align="center" width="25%">
                                <div>
                                    <div  style="left: 0px; top: 250px; width: 112px; height: 19px; padding: 1px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 19; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                        <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                            <div style="width: auto; height: auto; text-align: left;">
                                                <div style="width: auto; height: auto;">
                                                    <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                        流动性排名入池百分位：
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style="left: 702px; top: 228px; width: 12px; height: 27px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 20; line-height: 26px; transform: scaleX(1) scaleY(1);">
                                    <div class="context"  style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 27px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 20px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);">
                                                   90
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="8%" align="center">
                                <div style="left: 740px; top: 233px; width: 14px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 21; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label  style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    %
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="10%">
                                <div  style="left: 1785px; top: 233px; width: 98px; height: 19px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 37; line-height: 18px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 19px;">
                                        <div style="width: auto; height: auto; text-align: left;">
                                            <div style="width: auto; height: auto;">
                                                <label style="white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                    最新修改时间：
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td width="40%">
                                <div style="left: 890px; top: 226px; width: 212px; height: 25px; padding: 0px; pointer-events: auto; visibility: visible; opacity: 1; z-index: 38; line-height: 24px; transform: scaleX(1) scaleY(1);">
                                    <div class="context" style="background-color: rgba(0, 0, 0, 0); position: absolute; line-height: 24px;"><div style="width: auto; height: auto; text-align: left;">
                                        <div style="width: auto; height: auto;">
                                            <label style="white-space: nowrap; text-align: left; font-size: 18px; font-weight: 700; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(72, 85, 110);">
                                                2017年6月30日 &nbsp;19:33:12
                                            </label>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script language="JavaScript">
    /*$(document).ready(function () {
     $('ul.nav > li').click(function (e) {
     e.preventDefault();
     $('ul.nav > li').removeClass('active');
     $(this).addClass('active');
     });
     });*/
</script>
</html>