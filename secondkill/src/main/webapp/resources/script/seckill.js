//详情页功能处理
var seckill = {
    //访问url
    URL: {
        now: function () {
            return "/seckill/now";
        },
        exposer: function (seckillId) {
            return "/seckill/" + seckillId + "/detail";
        },
        execution: function (seckillId, md5) {
            return "/seckill/" + seckillId + "/" + md5 + "/execution";
        }
    },
    //计时函数
    countdown: function (seckillId, startTime, endTime, nowTime) {
        //判断是否需要计时
        var seckillBox = $("#seckill-box");
        if (nowTime > endTime) {
            //秒杀结束
            seckillBox.hide().html("秒杀结束");
        } else if (startTime < nowTime) {
            //秒杀进行中，执行秒杀
            seckill.handleSeckillExecution(seckillId, seckillBox);
        } else {
            //秒杀未开始
            var killTime = new Date(startTime + 1000);
            seckillBox.countdown(killTime, function (event) {
                $(this).html(event.strftime("倒计时: %d天 %H时 %M分钟 %S秒"));
            }).on("finish.countdown", function () {//计时结束时的回调函数
                seckill.handleSeckillExecution(seckillId, seckillBox);
            });
        }
    },
    //执行秒杀
    handleSeckillExecution: function (seckillId, node) {
        //显示秒杀按钮
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
        //发送exposer请求，虽然前台倒计时结束，但是由于时间偏差，服务器端秒杀不一定开始
        //所以后台还要判断一次
        $.post(seckill.URL.exposer(seckillId), {}, function (result) {
            if (result && result["success"]){
                var data = result["data"];
                if(data["exposed"]){
                    //秒杀已经开始,执行秒杀
                    var md5 = data["md5"];
                    var killUrl = seckill.URL.execution(seckillId, md5);
                    $.post(killUrl, {}, function () {

                    });
                }else {
                   //重新走时间逻辑

                }
            }else {
                console.log("result" + result);
            }
        });

    },
    //判断phone格式
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        } else {
            return false;
        }
    },
    //详情页对象
    detail: {
        init: function (params) {
            //在cookie中获取获取killPhone，检查是否登录
            var killPhone = $.cookie("killPhone");
            console.log(killPhone);
            //判断phone非空以及格式
            if (!seckill.validatePhone(killPhone)) {
                //说明killlPhone为空，显示弹出层
                var killPhoneModal = $("#killPhoneModal");
                killPhoneModal.modal({
                    show: true,
                    backdrop: "static",
                    keyboard: false
                });
                //未提交按钮绑定事件
                $("#killPhoneBtn").click(function () {
                    //拿到输入的电话
                    var killPhoneKey = $("#killPhoneKey");
                    //判断输入电话的格式
                    if (seckill.validatePhone(killPhoneKey)) {
                        //如果格式正确则进行绑定
                        $.cookie("killPhone", killPhoneKey, {expires: 7, path: "/seckill"});
                        window.location.reload();
                    } else {
                        $("#killPhoneMessage").hide().html('<span style="color:red">手机号错误！</span>');
                    }
                });
            }
            //如果已经登录
            var seckillId = params["seckillId"];
            var startTime = params["startTime"];
            var endTime = params["endTime"];
            $.get(seckill.URL.now(), {}, function (result) {
                if (result && result["success"]) {
                    var nowTime = result["data"];
                    seckill.countdown(seckillId, startTime, endTime, nowTime);
                } else {
                    console.log("result:" + result);
                }
            });

        }
    }

};