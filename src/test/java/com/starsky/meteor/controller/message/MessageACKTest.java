package com.starsky.meteor.controller.message;

import com.starsky.meteor.bean.message.chatMessagePack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageACKTest {

    @Test
    void getChatMessagePackJSON() {
        MessageACK messageACK = new MessageACK(1);
        messageACK.getChatMessagePackJSON("1");
    }

    @Test
    void synchroChatMessageAllPackJSON() {
        MessageACK messageACK = new MessageACK(1);
        messageACK.synchroChatMessageAllPackJSON("1");
    }
}