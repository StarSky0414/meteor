package com.starsky.meteor.bean.message;

import com.starsky.meteor.db.op.MessageEntity;

import java.util.ArrayList;

public class chatMessagePack implements MessageBean {

    private int code;
    private int state;
    private UserInfo userInfo;
    private ArrayList<MessageEntity> messageList;

    public chatMessagePack(int code, int state, UserInfo userInfo, ArrayList<MessageEntity> messageList) {
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

    public ArrayList<MessageEntity> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<MessageEntity> messageList) {
        this.messageList = messageList;
    }
}
