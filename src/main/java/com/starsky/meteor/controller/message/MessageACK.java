package com.starsky.meteor.controller.message;

import com.alibaba.fastjson.JSONObject;
import com.starsky.meteor.bean.message.UserInfo;
import com.starsky.meteor.bean.message.chatMessagePack;
import com.starsky.meteor.customexception.SafetyCheck;
import com.starsky.meteor.customexception.db.SelectListNone;
import com.starsky.meteor.db.op.MessageEntity;
import com.starsky.meteor.db.provider.MessageProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息同步
 * <p>
 * 未解决：
 * 消息步长硬编码
 * 消息范围
 * 下次校验码
 */
public class MessageACK {
    private int messageStartId = 0;
    private String nextCheck = "asdasd";
    private int code = 0;
    private int state = 0;

    MessageACK(int safetyCode) {
        this.code = safetyCode;
    }

    //获取自己接收的消息
    private ArrayList<MessageEntity> encapsulationMessageList(String userId, int messageStartId) throws SelectListNone {
        ArrayList<MessageEntity> messageLists = new ArrayList<>();
        MessageProvider messageProvider = new MessageProvider();
        List<MessageEntity> messageEntities = messageProvider.queryMessage(userId, messageStartId);
        for (MessageEntity m : messageEntities) {
            messageLists.add(m);
        }
        return messageLists;
    }

    //同步所有关于自己的消息
    private ArrayList<MessageEntity> encapsulationMessageAllList(String userId, int messageStartId) throws SelectListNone {
        ArrayList<MessageEntity> messageLists = new ArrayList<>();
        MessageProvider messageProvider = new MessageProvider();
        List<MessageEntity> messageEntities = messageProvider.queryMessageAll(userId, messageStartId);
        for (MessageEntity m : messageEntities) {
            messageLists.add(m);
        }
        return messageLists;
    }

    //获取自己消息的json
    public void getChatMessagePackJSON(String userId) {
        int saftyCode = 0;
        ArrayList<MessageEntity> messageEntities = null;
        try {
            messageEntities = encapsulationMessageList(userId, messageStartId);
            saftyCode = 1;
        } catch (SelectListNone selectListNone) {
            System.out.println("getChatMessagePackJSON  获取信息异常");
        }
        ACKPackage ackPackage = new ACKPackage(saftyCode);
        String encapsulationJSON = ackPackage.getEncapsulationJSON(userId, messageEntities);
        System.out.println(encapsulationJSON);
    }

    //获取同步消息的json
    public void synchroChatMessageAllPackJSON(String userId) {
        int saftyCode = 0;
        ArrayList<MessageEntity> messageEntities = null;
        try {
            messageEntities = encapsulationMessageAllList(userId, messageStartId);
            saftyCode = 1;
        } catch (SelectListNone selectListNone) {
            System.out.println("getChatMessagePackJSON  获取信息异常");
        }
        ACKPackage ackPackage = new ACKPackage(saftyCode);
        String encapsulationJSON = ackPackage.getEncapsulationJSON(userId, messageEntities);
        System.out.println(encapsulationJSON);
    }


}
