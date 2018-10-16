package com.starsky.meteor.bean;


//{"code":200,"msg":"203","obj":"6755"}
public class SMSRespodsBean {
    int code;
    String msg;
    String obj;

    public SMSRespodsBean(int code, String msg, String obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getObj() {
        return obj;
    }
}
