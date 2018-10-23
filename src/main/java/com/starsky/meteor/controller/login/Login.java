package com.starsky.meteor.controller.login;

import com.alibaba.fastjson.JSONObject;
import com.starsky.meteor.bean.SMSRespodsBean;
import com.starsky.meteor.controller.externalrequest.BaseNetRequest;
import com.starsky.meteor.customexception.NoUserInfo;
import com.starsky.meteor.db.op.UserInfoEntity;
import com.starsky.meteor.db.provider.UserInfoProvider;

import java.util.HashMap;

public class Login {
    public boolean userLogin(String phoneNumber, String password){
        UserInfoProvider userInfoProvider = new UserInfoProvider();
        try {
            UserInfoEntity userInfoEntity = userInfoProvider.queryUserInfo(phoneNumber);
            if (password.equals(userInfoEntity.getUserPassword())){
                return true;
            }else {
                return false;
            }
        } catch (NoUserInfo noUserInfo) {
            noUserInfo.printStackTrace();
            return false;
        }
    }

    public String register(String phoneNumber){
        String url="https://api.netease.im/sms/sendcode.action";
        String appSecret="4afb70479eab";
        String nonce="4tgggergigwow323t23taa";
        String appKey="501c8306df33b7320eff22b6d489c98e";
        long CurTime = System.currentTimeMillis();
        String checkSum = CheckSum.getCheckSum(appSecret, nonce, Long.toString(CurTime));
        System.out.println(checkSum);

        HashMap<String, String> header = new HashMap<>();
        header.put("AppKey",appKey);
        header.put("CurTime",Long.toString(CurTime));
        header.put("CheckSum",checkSum);
        header.put("Nonce",nonce);
        header.put("Content-Type","application/x-www-form-urlencoded");
        BaseNetRequest baseNetRequest = new BaseNetRequest();

        HashMap<String, String> par = new HashMap<>();
        System.out.println(phoneNumber);
        par.put("mobile",phoneNumber);
        par.put("templateid","9404201");
        String respondsString = baseNetRequest.postModel(url, header, par);
        return registerFeedback(respondsString);
    }

    private String registerFeedback(String respodsMessage){
        String register="";
        SMSRespodsBean smsRespodsBean = JSONObject.parseObject(respodsMessage, SMSRespodsBean.class);
        if (smsRespodsBean.getCode()==200){
            register=smsRespodsBean.getObj();
        }
        return register;
    }

}
