package com.starsky.meteor.bean.message;

public class MessageList {
    private String messageId;
    private String sendUserId;
    private ReceiveUserInfo receiveUserInfo;
    private String messageContent;
    private String type;
    private String voiceTime;
    private String time;

    public MessageList(String messageId, String sendUserId, ReceiveUserInfo receiveUserInfo, String messageContent, String type, String voiceTime, String time) {
        this.messageId = messageId;
        this.sendUserId = sendUserId;
        this.receiveUserInfo = receiveUserInfo;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public ReceiveUserInfo getReceiveUserInfo() {
        return receiveUserInfo;
    }

    public void setReceiveUserInfo(ReceiveUserInfo receiveUserInfo) {
        this.receiveUserInfo = receiveUserInfo;
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
