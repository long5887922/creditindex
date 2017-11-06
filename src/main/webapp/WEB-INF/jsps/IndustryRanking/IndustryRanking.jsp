<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

    <table  border="1">
        <tr>
            <td>
                <select  class="easyui-combobox"  id="mySelect"  name="s1"onchange="ch3()">
                    <option value="day"selected>行业内排名</option>
                    <option value="yer">同比</option>
                    <option value="months">环比</option>
                </select>
            </td>
        </tr>
    </table>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    loadData();
    // 基于准备好的dom，初始化echarts实例
    function loadData(){
        var myChart = echarts.init(document.getElementById('main'));
        var s1 = document.getElementsByName("s1")[0];
        var timetype = s1.value;
        var s2 = document.getElementsByName("select")[0];
        var weighttype = s2.value;
        var linkUrl = "/idri/queryIndexdateNew?Yoyg="+timetype+"&weighttype="+weighttype;
        // 指定图表的配置项和数据
        var option = {
            title: {//标题
                text: '八个行业信贷风险指数排名'
            },
            toolbox:{
                show:true,
                feature:{
                    dataView:{
                        show:true
                    },
                    restore:{//还原到初始状态
                        show:true
                    },
                    dataZoom:{
                        show:true
                    },
                    saveAsImage:{//存为图片
                        show:true
                    },
                    magicType:{//动态类型切换
                        //show:true
                        type:['line','bar']
                    }
                }
            },
            tooltip: {
                trigger:'axis'//显示鼠标的到达区域的值
            },
            //图例
            legend: {
                data:['行业排名']
            },
            //X轴
            xAxis: [
                {
                    type: 'category',
                    data: (function(){
                        var arr=[];
                        $.ajax({
                            type : "post",
                            async : false, //表示同步执行
                            url : linkUrl,
                            data : {},
                            dataType : "json", //返回数据形式为json
                            success : function(json) {
                                if (json) {
                                    for(var i=0;i<json.length;i++){
                                        console.log(json[i].context);
                                        arr.push(json[i].inducode);
                                    }
                                }
                            },
                            error : function(errorMsg) {
                                alert("不好意思,图表请求数据失败啦!");
                                myChart.hideLoading();
                            }
                        })
                        return arr;
                    })()
                }
            ],
            //Y轴
            yAxis: {
                type: 'value'
            },
            //具体数据
            series: [{
                name: '行业信贷违约指数',
                type: 'bar',//'bar'表示直方图; line 折线图
                data: (function(){
                    var arr=[];
                    $.ajax({
                        type : "post",
                        async : false, //同步执行
                        url : linkUrl,
                        data : {},
                        dataType : "json", //返回数据形式为json
                        success : function(json) {
                            if (json) {
                                for(var i=0;i<json.length;i++){
                                    console.log(json[i].context);
                                    arr.push(json[i].idri);
                                }
                            }
                        },
                        error : function(errorMsg) {
                            alert("不好意思,图表请求数据失败啦!");
                            myChart.hideLoading();
                        }
                    })
                    return arr;
                })(),
                markPoint:{
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine:{
                    data:[
                        {type: 'average',name: '平均值'}
                    ]
                }
            }]

        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }

</script>
</body>
</html>