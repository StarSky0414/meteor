package com.starsky.meteor.bean.message;

public class UserInfo implements MessageBean{
    private String userId;
    private String nextCheck;

    public UserInfo(String userId, String nextCheck) {
        this.userId = userId;
        this.nextCheck = nextCheck;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNextCheck() {
        return nextCheck;
    }

    public void setNextCheck(String nextCheck) {
        this.nextCheck = nextCheck;
    }
}
