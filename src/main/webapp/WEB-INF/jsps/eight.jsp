<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContent.request.contentPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <title>行业信贷风险指数</title>
    <meta charset="UTF-8"/>
    <script src="${cxt}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/Echarts/echarts.min.js" type="text/javascript"></script>
    <script src="${cxt}/js/Echarts/indexUtil.js" type="text/javascript"></script>
</head>
<body>
<div style="width:100%;">
    <div class="modal-body">
        <div><label id="lables" style="margin-left:318px;font-family:微软雅黑;font-size: 15px;color: #fff">等权</label></div>
        <div style="width:100%;">
            <div id="canvas" style="width: 1000px;height:480px;"></div>
        </div>
    </div>
</div>
<script>
    $(function () {
        openLineWindon();
    });
    function openLineWindon() {
        var myChart = echarts.init(document.getElementById('canvas'));
        $.ajax({
            url: '${ctx}/um/eightEchars',
            type: 'post',
            cache: false,
            contentType: "application/json; charset=utf-8",
            data: {},
            dataType: 'json',
            success: function (data) {
                option = {
                    title: {
                        text: '行业折线图'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: [

                        {
                            x: 'center',
                            data: [data.labels[0], data.labels[1], data.labels[2], data.labels[3]],
                            textStyle: {    //图例文字的样式
                                color: '#999'
                            }
                        },
                        {
                            x: 'center',
                            top: '3%',
                            data: [data.labels[4], data.labels[5], data.labels[6], data.labels[7]],
                            textStyle: {    //图例文字的样式
                                color: '#999'
                            }
                        }
                    ],
                    toolbox: {
                        left: 'right',
                        feature: {
                            dataZoom: {
                                yAxisIndex: 'none'
                            },
                            restore: {},
                            saveAsImage: {}
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '7%',
                        bottom: '7%',
                        containLabel: true
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: data.datasets[0].dateTime,
                        axisTick: {
                            alignWithLabel: true
                        },
                        // 控制网格线是否显示
                        splitLine: {
                            show: false,
                            //  改变轴线颜色
                            lineStyle: {
                                // 使用深浅的间隔色
                                color: '#999'
                            }
                        },
                        //  改变x轴颜色
                        axisLine: {
                            lineStyle: {
                                color: '#999'
//                            width:8,//这里是为了突出显示加上的，可以去掉
                            }
                        },
                        //  改变x轴字体颜色和大小
                        axisLabel: {
                            textStyle: {
                                color: '#999'
                            }
                        }
                    },

                    yAxis: {
                        type: 'value',
                        // 去除y轴上的刻度线
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            lineStyle: {
                                color: '#999'
                            }
                        },
                        splitLine: {
                            show: true,
                            //  改变轴线颜色
                            lineStyle: {
                                // 使用深浅的间隔色
                                color: ['#999']
                            }
                        },
                        axisLabel: {
                            textStyle: {
                                color: '#999'
                            }
                        }
                    },
                    series: [
                        {
                            itemStyle: {
                                normal: {
                                    color: '#9BD976'
                                }
                            },
                            name: [data.labels[0]],
                            type: 'line',
                            data: data.datasets[0].data
                        },
                        {
                            itemStyle: {
                                normal: {
                                    color: '#90CEFF'
                                }
                            },
                            name: [data.labels[1]],
                            type: 'line',
                            data: data.datasets[1].data
                        }, {
                            itemStyle: {
                                normal: {
                                    color: '#F2DB95'
                                }
                            },
                            name: [data.labels[2]],
                            type: 'line',
                            data: data.datasets[2].data
                        }, {
                            itemStyle: {
                                normal: {
                                    color: '#759CFF'
                                }
                            },
                            name: [data.labels[3]],
                            type: 'line',
                            data: data.datasets[3].data
                        }, {
                            itemStyle: {
                                normal: {
                                    color: '#62AE96'
                                }
                            },
                            name: [data.labels[4]],
                            type: 'line',
                            data: data.datasets[4].data
                        }, {
                            itemStyle: {
                                normal: {
                                    color: '#F1B080'
                                }
                            },
                            name: [data.labels[5]],
                            type: 'line',
                            data: data.datasets[5].data
                        }, {
                            itemStyle: {
                                normal: {
                                    color: '#BF7EF1'
                                }
                            },
                            name: [data.labels[6]],
                            type: 'line',
                            data: data.datasets[6].data
                        }, {
                            itemStyle: {
                                normal: {
                                    color: '#2B99FF'
                                }
                            },
                            name: [data.labels[7]],
                            type: 'line',
                            data: data.datasets[7].data
                        }
                    ]
                };
                myChart.setOption(option);
                $("#canvas").css('width', $("#canvas").width());
            }
        });
    }
</script>
</body>
</html>