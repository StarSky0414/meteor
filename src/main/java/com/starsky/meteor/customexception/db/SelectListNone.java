package com.starsky.meteor.customexception.db;

public class SelectListNone extends Exception{

    public SelectListNone() {
        System.out.println("查询结果为空");
    }
}
