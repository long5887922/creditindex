<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cxt" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html>
<html>
<script src="${cxt}/js/Echarts/echarts.min.js" type="text/javascript"></script>
<head>
    <meta charset="utf-8">
    <title>风险指数排序</title>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

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
        xAxis: {
            data: ["房地产业","制造业","建筑业","交通业","批发零售","电，热","采矿业","信息传输"]
        },
        //Y轴
        yAxis: {},
        //具体数据
        series: [{
            name: '行业排名',
            type: 'line',//'bar'表示直方图
            data: [5, 20, 36, 10, 10, 20,1,8],
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
</script>
</body>
</html>