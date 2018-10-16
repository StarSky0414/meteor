package com.starsky.meteor.stat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class IdentifyingCodeListTest {

    private static IdentifyingCodeList userIdentifying = IdentifyingCodeList.getIdentifyingCodeList();
    @Test
    void addIdentifyingCodeList() {
        userIdentifying.addIdentifyingCodeList("123","aaa");
        userIdentifying.addIdentifyingCodeList("123","aaa");
        userIdentifying.addIdentifyingCodeList("123","aaa");
        userIdentifying.addIdentifyingCodeList("123","aaa");
        userIdentifying.addIdentifyingCodeList("123123","aaa");
        userIdentifying.addIdentifyingCodeList("23123","aaa");
        userIdentifying.addIdentifyingCodeList("123","aaa");

        boolean userIdentifyingCode = userIdentifying.findUserIdentifyingCode("123", "aaa");
        System.out.println(userIdentifyingCode);
        userIdentifyingCode = userIdentifying.findUserIdentifyingCode("23123", "aaa");
        System.out.println(userIdentifyingCode);
    }

    @Test
    void findUserIdentifyingCode() {
    }
}