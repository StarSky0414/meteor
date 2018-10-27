package com.starsky.meteor.customexception;

public class SafetyCheck extends Exception {
    public SafetyCheck() {
        System.out.println("用户信息安全校验失败");
    }
}
