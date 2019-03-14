package com.starsky.meteor.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MessageInfoACKRequestTest {

    @Test
    void getHeartJumpPack() {
        try {
            MessageInfoACKRequest messageInfoACKRequest = new MessageInfoACKRequest();
            messageInfoACKRequest.getHeartJumpPack("1","123");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}