package com.starsky.meteor.controller.message;

import com.alibaba.fastjson.JSONObject;
import com.starsky.meteor.bean.message.UserInfo;
import com.starsky.meteor.bean.message.chatMessagePack;
import com.starsky.meteor.customexception.SafetyCheck;

import java.util.ArrayList;

public class ACKPackage {
    private String nextCheck = "asdasd";
    private int code = 0;
    private int state = 0;

    private int safetyCode;

    public ACKPackage(int safetyCode) {
        this.safetyCode = safetyCode;
    }

    public String getEncapsulationJSON(String userId, ArrayList messageList) {
        ArrayList messageEntities = new ArrayList<>();
        try {
            if (safetyCode == 0) {
                throw new SafetyCheck();
            }
            messageEntities = messageList;
            if (messageEntities.size() >= 10) {
                state = 1;
            }
            code = 1;
        } catch (SafetyCheck safetyCheck) {
        }
        UserInfo userInfo = new UserInfo(userId, nextCheck);
        chatMessagePack chatMessagePack = new chatMessagePack(code, state, userInfo, messageEntities);
        String s = JSONObject.toJSONString(chatMessagePack);
        return s;
    }
}
