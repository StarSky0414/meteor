package com.starsky.meteor.stat;

public class IdentifyingCodeBean {
    private long time=(System.currentTimeMillis() / 1000);
    private String phoneNumber;
    private String code;

    public IdentifyingCodeBean(String phoneNumber, String code) {
        this.phoneNumber = phoneNumber;
        this.code = code;
    }

    public long getTime() {
        return time;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
