package com.starsky.meteor.bean.message;

public class chatMessagePack {

    private int code;
    private int state;
    private UserInfo userInfo;
    private MessageList[] messageList;

    public chatMessagePack(int code, int state, UserInfo userInfo, MessageList[] messageList) {
        this.code = code;
        this.state = state;
        this.userInfo = userInfo;
        this.messageList = messageList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public MessageList[] getMessageList() {
        return messageList;
    }

    public void setMessageList(MessageList[] messageList) {
        this.messageList = messageList;
    }
}
