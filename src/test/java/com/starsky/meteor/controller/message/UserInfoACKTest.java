package com.starsky.meteor.controller.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoACKTest {

    @Test
    void getFriendUserInfo() {
        UserInfoACK userInfoACK = new UserInfoACK();
        userInfoACK.getFriendUserInfo("1");
    }
}