package com.starsky.meteor.db.op;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_chat_message", schema = "meteor", catalog = "")
public class UserChatMessageEntity {
    private int id;
    private String sendUserId;
    private String receiveUserId;
    private String messageContent;
    private String type;
    private String voiceTime;
    private Timestamp time;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "send_user_id", nullable = false, length = 20)
    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    @Basic
    @Column(name = "receive_user_id", nullable = true, length = 20)
    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    @Basic
    @Column(name = "message_content", nullable = true, length = -1)
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "voiceTime", nullable = true, length = -1)
    public String getVoiceTime() {
        return voiceTime;
    }

    public void setVoiceTime(String voiceTime) {
        this.voiceTime = voiceTime;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChatMessageEntity that = (UserChatMessageEntity) o;
        return id == that.id &&
                Objects.equals(sendUserId, that.sendUserId) &&
                Objects.equals(receiveUserId, that.receiveUserId) &&
                Objects.equals(messageContent, that.messageContent) &&
                Objects.equals(type, that.type) &&
                Objects.equals(voiceTime, that.voiceTime) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, sendUserId, receiveUserId, messageContent, type, voiceTime, time);
    }
}
