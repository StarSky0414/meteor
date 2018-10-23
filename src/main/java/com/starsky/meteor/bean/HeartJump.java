package com.starsky.meteor.bean;

public class HeartJump {
    private String userId;
    private String localMessageNum;

    public HeartJump(String userId, String localMessageNum) {
        this.userId = userId;
        this.localMessageNum = localMessageNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocalMessageNum() {
        return localMessageNum;
    }

    public void setLocalMessageNum(String localMessageNum) {
        this.localMessageNum = localMessageNum;
    }
}
