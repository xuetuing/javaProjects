package com.huawei.seckill.common.enums;

public enum SeckillStateEnum {

    MUCH(2, "to much requests, pls wait."),
    SUCCESS(1, "seckill sucess!"),
    END(0, "seckill end."),
    REPEAT_KILL(-1, "seckill repeate."),
    INNER_ERROR(-2, "system inner error."),
    DATA_REWRITE(-3, "data rewrite.");

    private Integer state;
    private String info;

    SeckillStateEnum(Integer state, String info) {
        this.state = state;
        this.info = info;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static SeckillStateEnum stateOf(int index){
        for(SeckillStateEnum state : values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
