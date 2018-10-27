package com.starsky.meteor.customexception.db;

public class FieldAlreadyExists extends Exception {

    public FieldAlreadyExists() {
        System.out.println("字段已存在");
    }
}
