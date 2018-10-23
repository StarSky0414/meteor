package com.starsky.meteor.bean;

public class HeartJumpACK {

    //无消息
    public final int ORDER_STATE_NO_MESSAGE=0x00;
    //有消息
    public final int ORDER_STATE_MESSAGE=0x01;


    String userId;
    String orderState;

    public HeartJumpACK(String userId, String orderState) {
        this.userId = userId;
        this.orderState = orderState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
}
