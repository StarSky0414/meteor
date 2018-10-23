package com.starsky.meteor.controller.login;

import com.starsky.meteor.customexception.NoUserInfo;
import com.starsky.meteor.db.op.UserInfoEntity;
import com.starsky.meteor.db.provider.UserInfoProvider;

public class UserInfoController {

    private UserInfoProvider userInfoProvider;

    public boolean userInfoUpdate(String userPhoneNumber, String userNickName, String userPassword){
        userInfoProvider = new UserInfoProvider();
        userInfoProvider.updateUserInfo(userNickName,userPassword,userPhoneNumber);
        if (userInfoCheck(userPhoneNumber,userNickName,userPassword)) {
            System.out.println("验证通过");
            return true;
        }else {
            System.out.println("验证失败");
            return false;
        }

    }

    /**
     * 用于校验录入信息是否正确
     * @return  true 正确  /  false 不正确
     * @param userPhoneNumber  用户电话号码
     * @param userNickName  用户昵称
     * @param userPassword  用户密码  未加密
     */
    private boolean userInfoCheck(String userPhoneNumber, String userNickName, String userPassword){
        try {
            UserInfoEntity userInfoEntity = userInfoProvider.queryUserInfo(userPhoneNumber);
            if (userInfoEntity.getUserNickname().equals(userNickName) && userInfoEntity.getUserPassword().equals(userPassword)) {
                return true;
            } else {
                return false;
            }
        }catch (NoUserInfo e){
            return false;
        }
    }
}
