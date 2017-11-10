<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cxt" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html>
<html>

<script src="${cxt}/js/Echarts/echarts.min.js" type="text/javascript"></script>
<script src="${cxt}/js/Echarts/indexUtil.js" type="text/javascript"></script>
<head>
    <meta charset="utf-8">
    <title>风险指数排序</title>
</head>
<body>
<div style="width:760px;height:300px;border-bottom:solid 1px #34394A; border-left:solid 1px #34394A; border-right:solid 1px #34394A; border-top:solid 1px #34394A;">
    <div id="toolbar" style="width: 120px;height:32px;float: right;position: relative;">
        <table border="1">
            <tr>
                <td>
                    <select class="easyui-combobox" id="mySelect" name="s1" onchange="ch3()"
                            style="width:150px;height: 32px;font-size: 16px;background-color:#34394A;color:#999">
                        <option value="day" selected>最近交易日</option>
                        <option value="yer">同比</option>
                        <option value="months">环比</option>
                    </select>
                </td>
            </tr>
        </table>
    </div>

    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 700px;height:280px;">
    </div>
</div>
<script type="text/javascript">
    var theme;
    $(function () {
        theme = window.localStorage.getItem("theme");

        loadData(theme);
    });

    // 基于准备好的dom，初始化echarts实例
    function loadData(code) {

        var myChart = echarts.init(document.getElementById('main'));
        var s1 = document.getElementsByName("s1")[0];
        var timetype = s1.value;
        var s2 = document.getElementsByName("select")[0];
        var weighttype = s2.value;
        var linkUrl = "/idri/queryIndexdateNew?Yoyg=" + timetype + "&weighttype=" + weighttype;
        // 指定图表的配置项和数据
        var option;
        if(code=='black'){
            option  = {
                title: {//标题
                    text: '八个行业信贷风险指数排名',
                    textStyle: {
                        //文字颜色
                        color:'#fff',
//                    //字体风格,'normal','italic','oblique'
                        fontStyle: 'normal',
//                    //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
//                    fontWeight:'bold',
//                    //字体系列
                        fontFamily: 'sans-serif',
//                    //字体大小
                        fontSize: 20
                    }
                },
                tooltip: {
                    trigger: 'axis'//显示鼠标的到达区域的值
                },
                //图例
                legend: {
                    data: ['行业排名']
                },
                //X轴
                xAxis: [{
                    type: 'category',
                    data: (function () {
                        var arr = [];
                        $.ajax({
                            type: "post",
                            async: false, //表示同步执行
                            url: linkUrl,
                            data: {},
                            dataType: "json", //返回数据形式为json
                            success: function (json) {
                                if (json) {
                                    for (var i = 0; i < json.length; i++) {
                                        console.log(json[i].context);
                                        arr.push(json[i].inducode);
                                    }
                                }
                            },
                            error: function (errorMsg) {
                                alert("不好意思,图表请求数据失败啦!");
                                myChart.hideLoading();
                            }
                        })
                        return arr;
                    })(),
                    axisLabel: {//设置X轴的颜色
                        show: true,
                        textStyle: {
                            show: true,
                            color: '#fff'
                        }
                    }
                }
                ],
                //Y轴
                yAxis: {
                    type: 'value',
                    axisLine: {
                        lineStyle: {
                            color:'#fff'
                        }
                    }
                },
                //具体数据
                series: [{
                    name: '行业信贷违约指数',
                    type: 'bar',//'bar'表示直方图; line 折线图
                    itemStyle:{//设置柱形图的颜色
                        normal:{
                            color:'#2B99FF'
                        }
                    },
                    data: (function () {
                        var arr = [];
                        $.ajax({
                            type: "post",
                            async: false, //同步执行
                            url: linkUrl,
                            data: {},
                            dataType: "json", //返回数据形式为json
                            success: function (json) {
                                if (json) {
                                    for (var i = 0; i < json.length; i++) {
                                        console.log(json[i].context);
                                        arr.push(json[i].idri);
                                    }
                                }
                            },
                            error: function (errorMsg) {
                                alert("不好意思,图表请求数据失败啦!");
                                myChart.hideLoading();
                            }
                        })
                        return arr;
                    })(),
                    markPoint: {
                        data: [
                            {type: 'max', name: '最大值'},
                            {type: 'min', name: '最小值'}
                        ]
                    },
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                }]

            };
        }if (code == "white"){
            $("#mySelect").css({color: "#333"});
            $("#mySelect").css({backgroundColor: "white"});
            option  = {
                title: {//标题
                    text: '八个行业信贷风险指数排名',
                    textStyle: {
                        //文字颜色
                        color:'#333',
//                    //字体风格,'normal','italic','oblique'
                        fontStyle: 'normal',
//                    //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
//                    fontWeight:'bold',
//                    //字体系列
                        fontFamily: 'sans-serif',
//                    //字体大小
                        fontSize: 20
                    }
                },
                tooltip: {
                    trigger: 'axis'//显示鼠标的到达区域的值
                },
                //图例
                legend: {
                    data: ['行业排名']
                },
                //X轴
                xAxis: [{
                    type: 'category',
                    data: (function () {
                        var arr = [];
                        $.ajax({
                            type: "post",
                            async: false, //表示同步执行
                            url: linkUrl,
                            data: {},
                            dataType: "json", //返回数据形式为json
                            success: function (json) {
                                if (json) {
                                    for (var i = 0; i < json.length; i++) {
                                        console.log(json[i].context);
                                        arr.push(json[i].inducode);
                                    }
                                }
                            },
                            error: function (errorMsg) {
                                alert("不好意思,图表请求数据失败啦!");
                                myChart.hideLoading();
                            }
                        })
                        return arr;
                    })(),
                    axisLabel: {//设置X轴的颜色
                        show: true,
                        textStyle: {
                            show: true,
                            color: '#333'
                        }
                    }
                }
                ],
                //Y轴
                yAxis: {
                    type: 'value',
                    axisLine: {
                        lineStyle: {
                            color:'#333'
                        }
                    }
                },
                //具体数据
                series: [{
                    name: '行业信贷违约指数',
                    type: 'bar',//'bar'表示直方图; line 折线图
                    itemStyle:{//设置柱形图的颜色
                        normal:{
                            color:'#2B99FF'
                        }
                    },
                    data: (function () {
                        var arr = [];
                        $.ajax({
                            type: "post",
                            async: false, //同步执行
                            url: linkUrl,
                            data: {},
                            dataType: "json", //返回数据形式为json
                            success: function (json) {
                                if (json) {
                                    for (var i = 0; i < json.length; i++) {
                                        console.log(json[i].context);
                                        arr.push(json[i].idri);
                                    }
                                }
                            },
                            error: function (errorMsg) {
                                alert("不好意思,图表请求数据失败啦!");
                                myChart.hideLoading();
                            }
                        })
                        return arr;
                    })(),
                    markPoint: {
                        data: [
                            {type: 'max', name: '最大值'},
                            {type: 'min', name: '最小值'}
                        ]
                    },
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                }]

            };
        }

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }

</script>
</body>
</html>