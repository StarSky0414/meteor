package com.starsky.meteor.bean.message;

public class ReceiveUserInfo {

    private String userId;
    private String userHeadLink;
    private String nickname;

    public ReceiveUserInfo(String userId, String userHeadLink, String nickname) {
        this.userId = userId;
        this.userHeadLink = userHeadLink;
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserHeadLink() {
        return userHeadLink;
    }

    public void setUserHeadLink(String userHeadLink) {
        this.userHeadLink = userHeadLink;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
