//用于实现秒杀交互逻辑
var seckill = {
    URL: {
        now: function () {
            return '/seckill/time/now';
        },
        exposer: function (seckillId) {
            return '/seckill/' + seckillId + '/exposer';
        },
        execution: function (seckillId, md5) {
            return '/seckill/' + seckillId + '/' + md5 + '/execution';
        }
    },
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        } else {
            return false;
        }
    },
    //执行秒杀函数
    handleSeckillKill: function (seckillId, node) {
        //获取秒杀地址，控制显示逻辑，执行秒杀
        node.hide()
            .html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
        $.post(seckill.URL.exposer(seckillId), {}, function (result) {
            if (result && result["success"]) {
                //提取exposer
                var exposer = result["data"];
                if (exposer["exposed"]) {
                    //秒杀已经开始
                    var md5 = exposer["md5"];
                    var killUrl = seckill.URL.execution(seckillId, md5);
                    $("#killBtn").one("click", function () {
                            //1.先禁用按钮，防止重复点击
                            $(this).addClass("disabled");
                        $.post(killUrl, {}, function (result) {
                            console.log(result["success"]);
                            console.log(result);
                            if(result && result["success"]){
                                var killResult = result["data"];
                                var stateInfo = killResult["stateInfo"];
                                console.log("stateInfo:" + stateInfo);
                                node.html('<span class="label label-success"> '+ stateInfo + '</span>');
                            }
                        });
                    });
                    node.show();
                } else {
                    //因为用户本地时间与后台不一致，重新开始计时逻辑
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end = exposer['end'];
                    seckill.countDown(seckillId, now, start, end);
                }
            } else {
                console.log("result:" + result);
            }
        });

    },
    //计时函数
    countDown: function (seckillId, nowTime, startTime, endTime) {
        var seckillBox = $("#seckill-box");
        //时间判断
        if (nowTime > endTime) {
            seckillBox.html("秒杀结束");
        } else if (nowTime < startTime) {
            //秒杀还没有开始，绑定计时事件
            var killTime = new Date(startTime + 1000);
            seckillBox.countdown(killTime, function (event) {
                $(this).html(event.strftime("秒杀倒计时：%D天 %H时 %M分 %S秒"));
            }).on("finish.countdown", function () { //倒计时结束回调函数
                //为防止倒计时误差，重新请求exposer,判断是否已经开始，来显示秒杀按钮或更正倒计时时间
                seckill.handleSeckillKill(seckillId, seckillBox);
            });
        } else {
            seckill.handleSeckillKill(seckillId, seckillBox);
        }
    },
    detail: {
        init: function (params) {
            //从cookie中拿到killPhone
            var killPhone = $.cookie("killPhone");
            console.log(killPhone);
            //判断是否登录
            if (!seckill.validatePhone(killPhone)) {
                //显示弹出层
                console.log("here here...");
                var killPhoneModal = $("#killPhoneModal");
                killPhoneModal.modal({
                    show : true, //显示弹出层
                    backdrop : 'static', //禁止位置关闭
                    keyboard : false //关闭键盘事件
                });
                //为提交按钮绑定click,对phone进行绑定
                $("#killPhoneBtn").click(function () {
                    //获取输入的phone
                    var killPhone = $("#killPhoneKey").val();
                    //判断phone的格式是否正确
                    if (seckill.validatePhone(killPhone)) {
                        //phone正确，进行绑定
                        $.cookie("killPhone", killPhone, {expires: 7, path: "/seckill"});
                        //刷新页面
                        window.location.reload();
                    } else {
                        $("#killPhoneMessage").hide().html('<label class="label-danger">手机号码错误！</label>').show(300);
                    }
                });
            }
            //已经登录，开始计时交互
            var seckillId = params["seckillId"];
            var startTime = params["startTime"];
            var endTime = params["endTime"];
            $.get(seckill.URL.now(), {}, function (result) {
                if (result && result["success"]) {
                    var nowTime = result["data"];
                    seckill.countDown(seckillId, nowTime, startTime, endTime);
                } else {
                    console.log("result:" + result);
                }
            });
        }
    }
};