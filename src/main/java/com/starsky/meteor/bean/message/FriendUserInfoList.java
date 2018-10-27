package com.starsky.meteor.bean.message;

public class FriendUserInfoList {
    private String userId;
    private String nickName;
    private String headLink;

    public FriendUserInfoList() {
    }

    public FriendUserInfoList(String userId, String nickName, String headLink) {
        this.userId = userId;
        this.nickName = nickName;
        this.headLink = headLink;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadLink() {
        return headLink;
    }

    public void setHeadLink(String headLink) {
        this.headLink = headLink;
    }
}
