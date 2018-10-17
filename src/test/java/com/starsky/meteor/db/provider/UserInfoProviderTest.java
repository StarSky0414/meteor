package com.starsky.meteor.db.provider;

import com.starsky.meteor.db.op.UserInfoEntity;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;

class UserInfoProviderTest {

    UserInfoProvider userInfoProvider = new UserInfoProvider();

    @Test
    void testCreateUserInfo() {
        try {
            userInfoProvider.CreateUserInfo("123123");
        }catch (ConstraintViolationException e){
            System.out.println("插入冲突");
        }
    }

    @Test
    void testUpdateUserInfo(){
        userInfoProvider.updateUserInfo("bbb","aaa","123");
    }

    @Test
    void testQueryUserInfo(){
        UserInfoEntity userInfoEntity = userInfoProvider.queryUserInfo("123");
        System.out.println(userInfoEntity.getId());
        System.out.println(userInfoEntity.getUserNickname());
        System.out.println(userInfoEntity.getUserPhone());
        System.out.println(userInfoEntity.getUserPassword());
    }
}