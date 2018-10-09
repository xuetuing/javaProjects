<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./css/orderList.css">
</head>

<body>
    <div class="normal">
        <div class="main_title">订单管理</div>
        <div class="main_body">
            <div class="nav_title autoH color_909090">
                <label>订单管理</label>
            </div>
            <!-- 右侧内容 -->
            <div class="content">
                <!-- 选项组 -->
                <div class="options">
                    <div>
                        <label>订单号:</label>
                        <span><input class="find" type="text" name="" placeholder="请输入信息"></span>
                    </div>
                    <div>
                        <label>课程名称:</label>
                        <span><input class="find" type="text" name="" placeholder="请输入信息"></span>
                    </div>
                    <div>
                        <label>课程方向:</label>
                        <span>
							<select class="select" size="1" name="">
								<option selected value="">-请选择-</option>
								<option value="1">UID</option>
								<option value="2">JAVA</option>
								<option value="3">WEB</option>
							</select>
						</span>
                    </div>
                    <div>
                        <label>付款状态:</label>
                        <span>
							<select class="select" size="1" name="">
								<option selected value="">-请选择-</option>
								<option value="1">待付款</option>
								<option value="2">已付款</option>
							</select>
						</span>
                    </div>
                    <div class="search">搜索</div>
                </div>
                <div class="c_main">
                    <table cellspacing="0" cellpadding="0">
                        <tr class="thead">
                            <td class="col_10">订单号</td>
                            <td class="col_12">课程方向</td>
                            <td class="col_20">课程名称</td>
                            <td class="col_12">课程价格</td>
                            <td class="col_12">购买者</td>
                            <td class="col_10">购买时间</td>
                            <td>付款状态</td>
                        </tr>
                        <tr>
                            <td class="col_10">00456</td>
                            <td class="col_12">UID</td>
                            <td class="col_20">PS CC 2017启动界面实现方式</td>
                            <td class="col_12">¥35.00</td>
                            <td class="col_12">会飞的猪</td>
                            <td class="col_10">2017.8.21</td>
                            <td>已付款</td>
                        </tr>
                        <tr>
                            <td class="col_10">00457</td>
                            <td class="col_12">UID</td>
                            <td class="col_20">PS CC 2017启动界面实现方式</td>
                            <td class="col_12">¥39.00</td>
                            <td class="col_12">不会飞的猪</td>
                            <td class="col_10">2017.8.21</td>
                            <td>已付款</td>
                        </tr>
                    </table>
                    <!-- 分页 -->
                    <div class="Page navigation">
                        <ul class="pagination">
                            <li><span class="prev">上一页</span></li>
                            <li><span class="curr">1</span></li>
                            <li><span>2</span></li>
                            <li><span>3</span></li>
                            <li><span>4</span></li>
                            <li><span>5</span></li>
                            <li><span class="next">下一页</span></li>
                            <li><input type="text" class="page"><input type="button" value="确定" class="ok"></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript">
    //关闭右侧
    $(".main_title").on("click", function() {
        //iframe关闭
        $('#aa', window.parent.document).attr("src", "");
    })
</script>

</html>