<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../css/userVip.css">
    <link rel="stylesheet" type="text/css" href="../css/jquery.page.css">
</head>

<body>
    <div class="normal">
        <div class="main_title">用户管理</div>
        <div class="main_body">
            <div class="nav_title autoH color_909090">
                <label>用户管理</label><span class="jiantou"></span>
                <label class="color_0e6fb6">会员</label>
            </div>
            <!-- 右侧内容 -->
            <div class="content">
                <div class="c_main">
                    <table cellspacing="0" cellpadding="0" id="currData">
                        <tr class="thead">
                            <td class="col_15">序号</td>
                            <td class="col_25">昵称</td>
                            <td class="col_25">邮箱账号</td>
                            <td class="col_20">注册时间</td>
                        </tr>
                    </table>
                    <!-- 分页 -->
                    <div class="Page navigation">
                        <div class="pagination">
                        </div>
                        <input id="page" type="text" style="width:60px;height:25px;border: 1px solid #ddd;border-radius:5px;">
                        <input id="selPage" type="button" value="确定" class="ok">
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/userVip.js"></script>
<script type="text/javascript">
//关闭右侧
$(".main_title").on("click", function() {
    $('#aa', window.parent.document).attr("src", "");
})
</script>

</html>