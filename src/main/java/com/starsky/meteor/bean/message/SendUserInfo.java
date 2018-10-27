package com.starsky.meteor.bean.message;

import org.hibernate.transform.ResultTransformer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendUserInfo implements MessageBean ,ResultTransformer {

    private String userId;
    private String userHeadLink;
    private String nickname;

    public SendUserInfo(String userId, String userHeadLink, String nickname) {
        this.userId = userId;
        this.userHeadLink = userHeadLink;
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserHeadLink() {
        return userHeadLink;
    }

    public void setUserHeadLink(String userHeadLink) {
        this.userHeadLink = userHeadLink;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        return Arrays.asList( tuple );
    }

    @Override
    public List transformList(List list) {
        return list;
    }
}
