package com.starsky.meteor.db.provider;

import com.starsky.meteor.bean.message.MessageList;
import com.starsky.meteor.bean.message.chatMessagePack;
import com.starsky.meteor.customexception.db.SelectListNone;
import com.starsky.meteor.db.DBBase;
import com.starsky.meteor.db.op.MessageEntity;
import com.starsky.meteor.db.op.UserFollowEntity;
import com.starsky.meteor.db.op.UserInfoEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageProvider {

    private final DBBase dbBase;

    public MessageProvider() {
        dbBase = DBBase.getDBBase();
    }

//    public ArrayList<MessageEntity> messageList(String userId,int messageStartId,int messageEndId) throws SelectListNone {
//        ArrayList<MessageEntity> messageLists = new ArrayList<>();
//        List<MessageEntity> messageEntities = queryMessage(userId,messageStartId,messageEndId);
//        for (MessageEntity m :
//                messageEntities) {
////            String sendUserId = m.getSendUserId();
////            String followNickname = getFollowNickname(userId, sendUserId);
////            String userHeadLink = getUserHeadLink(userId);
////            SendUserInfo sendUserInfo = new SendUserInfo(userId,userHeadLink, followNickname);
//
////            MessageList messageList = new MessageList(String.valueOf(m.getId()), m.getSendUserId(), m.getReceiveUserId(),
////                    m.getMessageContent(), m.getType(), m.getVoiceTime(), m.getTime());
//            messageLists.add(m);
//        }
//        return messageLists;
//    }
//
//    public void  createChatMessagePack(){
//        chatMessagePack chatMessagePack = new chatMessagePack();
//    }



    public List<MessageEntity> queryMessage(String receiveUserId,int messageStartId) throws SelectListNone {
        String sql = "select * from message where receive_user_id=? and id > ? limit 0,10;";
        ArrayList<Object> parameterArrayList = new ArrayList<>();
        parameterArrayList.add(receiveUserId);
        parameterArrayList.add(messageStartId);
        List<MessageEntity> query = dbBase.query(sql, parameterArrayList, MessageEntity.class);
        return query;
    }

    public List<MessageEntity> queryMessageAll(String userId,int messageStartId) throws SelectListNone {
        String sql = "select * from message where ( receive_user_id=? or send_user_id=? ) and id > ?  limit 0,10;";
        ArrayList<Object> parameterArrayList = new ArrayList<>();
        parameterArrayList.add(userId);
        parameterArrayList.add(userId);
        parameterArrayList.add(messageStartId);
        List<MessageEntity> query = dbBase.query(sql, parameterArrayList, MessageEntity.class);
        return query;
    }

    public String getFollowNickname(String userId, String friendId) throws SelectListNone {
        String sql = "select * from user_follow where user_id=? and friend_id= ?;";
        ArrayList<Object> parameterArrayList = new ArrayList<>();
        parameterArrayList.add(userId);
        parameterArrayList.add(friendId);
        List<UserFollowEntity> query = dbBase.query(sql, parameterArrayList, UserFollowEntity.class);
        String nickname = query.get(0).getNickname();
        return nickname;
    }

    public String getUserHeadLink(String userId) throws SelectListNone {
        String sql = "select * from user_info where _id=:userId ;";
        HashMap<String, Object> parameterHashMap = new HashMap<>();
        parameterHashMap.put("userId", userId);
        List<UserInfoEntity> query = dbBase.query(sql, parameterHashMap, UserInfoEntity.class);
        String userHeadLink = query.get(0).getUserHeadLink();
        return userHeadLink;
    }
}
