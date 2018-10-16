package com.starsky.meteor.db.provider;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoProviderTest {

    @Test
    void createUserInfo() {
        UserInfoProvider userInfoProvider = new UserInfoProvider();
        try {
            userInfoProvider.CreateUserInfo("123123");
        }catch (ConstraintViolationException e){
            System.out.println("插入冲突");
        }
    }
}