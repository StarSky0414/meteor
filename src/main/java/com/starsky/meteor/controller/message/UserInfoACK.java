package com.starsky.meteor.controller.message;

import com.alibaba.fastjson.JSONObject;
import com.starsky.meteor.bean.message.UserInfo;
import com.starsky.meteor.bean.message.chatMessagePack;
import com.starsky.meteor.customexception.SafetyCheck;
import com.starsky.meteor.customexception.db.SelectListNone;
import com.starsky.meteor.db.op.MessageEntity;
import com.starsky.meteor.db.provider.UserInfoProvider;

import java.util.ArrayList;

public class UserInfoACK {

    private String nextCheck = "asdasd";
    private int code=0;
    private int state=0;


    public void getFriendUserInfo(String userId){
        UserInfoProvider userInfoProvider = new UserInfoProvider();

        int saftyCode = 0;
        ArrayList messageEntities = null;
        try {
            messageEntities = (ArrayList) userInfoProvider.queryFriendUserInfo(userId);
            saftyCode = 1;
        } catch (SelectListNone selectListNone) {
            System.out.println("getChatMessagePackJSON  获取信息异常");
        }
        ACKPackage ackPackage = new ACKPackage(saftyCode);
        String encapsulationJSON = ackPackage.getEncapsulationJSON(userId, messageEntities);
        System.out.println(encapsulationJSON);
    }

}
