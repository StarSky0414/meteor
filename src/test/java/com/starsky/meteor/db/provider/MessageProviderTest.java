package com.starsky.meteor.db.provider;

import com.alibaba.fastjson.JSONObject;
import com.starsky.meteor.bean.message.MessageList;
import com.starsky.meteor.customexception.db.SelectListNone;
import com.starsky.meteor.db.op.MessageEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {



    @Test
    void queryMessage() {
        MessageProvider messageProvider = new MessageProvider();
        List<MessageEntity> messageEntities = null;
        try {
             messageEntities= messageProvider.queryMessage("2",0);
        } catch (SelectListNone selectListNone) {
            selectListNone.printStackTrace();
        }
        for (MessageEntity messageEntity: messageEntities) {
            System.out.println(messageEntity.getType());
            System.out.println(messageEntity.getMessageContent());
            System.out.println(messageEntity.getTime());
            System.out.println();
        }
    }

    @Test
    void getFollowNickname() {
        MessageProvider messageProvider = new MessageProvider();
        try {
            String followNickname = messageProvider.getFollowNickname("1", "2");
            System.out.println(followNickname);
        } catch (SelectListNone selectListNone) {
            selectListNone.printStackTrace();
        }
    }

    @Test
    void getUserHeadLink() {
        MessageProvider messageProvider = new MessageProvider();
        try {
            String userHeadLink = messageProvider.getUserHeadLink("1");
            System.out.println(userHeadLink

            );
        } catch (SelectListNone selectListNone) {
            selectListNone.printStackTrace();
        }
    }

    @Test
    void messageList() {
        String userId="1";
        int messageStartId = 0;

        MessageProvider messageProvider = new MessageProvider();
//        try {
////            ArrayList<MessageEntity> messageLists = messageProvider.messageList(userId, messageStartId, messageEndId);
////            JSONObject jsonObject = new JSONObject();
////            jsonObject.put("messageLists",messageLists);
////            System.out.println(jsonObject.toJSONString());
//        } catch (SelectListNone selectListNone) {
//            selectListNone.printStackTrace();
//        }
    }
}