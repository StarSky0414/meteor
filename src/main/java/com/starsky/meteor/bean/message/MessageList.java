package com.starsky.meteor.bean.message;

import java.sql.Timestamp;

public class MessageList implements MessageBean {
    private String messageId;
    private String sendUserId;
    private String receiveUser;
    private String messageContent;
    private String type;
    private String voiceTime;
    private Timestamp time;

    public MessageList(String messageId, String sendUserId, String receiveUser, String messageContent, String type, String voiceTime, Timestamp time) {
        this.messageId = messageId;
        this.sendUserId = sendUserId;
        this.receiveUser = receiveUser;
        this.messageContent = messageContent;
        this.type = type;
        this.voiceTime = voiceTime;
        this.time = time;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getSendUserInfo() {
        return receiveUser;
    }

    public void setSendUserInfo(String sendUserInfo) {
        this.receiveUser = sendUserInfo;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVoiceTime() {
        return voiceTime;
    }

    public void setVoiceTime(String voiceTime) {
        this.voiceTime = voiceTime;
    }
}
