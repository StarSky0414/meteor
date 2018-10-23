package com.starsky.meteor.customexception;

public class NoUserInfo extends Exception{

    public NoUserInfo(){
        System.out.println("用户信息不存在");
//        super(message);
    }
}
