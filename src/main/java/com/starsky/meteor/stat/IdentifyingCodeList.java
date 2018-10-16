package com.starsky.meteor.stat;

import com.starsky.meteor.db.provider.UserInfoProvider;
import org.hibernate.exception.ConstraintViolationException;

import java.util.ArrayList;

public class IdentifyingCodeList {
    private static IdentifyingCodeList identifyingCodeList;
    private static ArrayList<IdentifyingCodeBean> userIdentifying;
    private static final long outTime=300;

    static {
        userIdentifying=new ArrayList<>();
        identifyingCodeList=new IdentifyingCodeList();
    }
    private IdentifyingCodeList(){}

    public static IdentifyingCodeList getIdentifyingCodeList(){
        if (identifyingCodeList!=null){
            identifyingCodeList=new IdentifyingCodeList();
        }
        return identifyingCodeList;
    }

    public synchronized void addIdentifyingCodeList(String phoneNumber,String code){
        IdentifyingCodeBean identifyingCodeBean = new IdentifyingCodeBean(phoneNumber, code);
        userIdentifying.add(identifyingCodeBean);
    }

    public boolean findUserIdentifyingCode(String userPhone , String code){
        for (IdentifyingCodeBean identifyingCodeBean : userIdentifying){
            if (identifyingCodeBean.getPhoneNumber().equals(userPhone)){
                long nowTime = System.currentTimeMillis() / 1000;
                System.out.println("nowTime"+nowTime);
                if (getEndTime(identifyingCodeBean.getTime())>=nowTime){
                    if ( identifyingCodeBean.getCode().equals(code)) {
                        try {
                            UserInfoProvider userInfoProvider = new UserInfoProvider();
                            userInfoProvider.CreateUserInfo(userPhone);
                        }catch (ConstraintViolationException e){
                            System.out.println("已填写过验证码");
                        }
                        return true;
                    }
                }else {
                    int indexOfStart = userIdentifying.indexOf(identifyingCodeBean)+1;
                    System.out.println("indexOfStart"+indexOfStart);
                    int indexOfEnd = userIdentifying.size();
                    System.out.println("indexOfEnd");
                    userIdentifying= new ArrayList<IdentifyingCodeBean>(userIdentifying.subList(indexOfStart,indexOfEnd)) ;
                }
                System.out.println("==================="+userIdentifying.size());
            }
            System.out.println(userIdentifying.size());

        }
        return false;
    }

    private long getEndTime(long startTime){
        long endTime=startTime+outTime;
        System.out.println(endTime);
        return endTime;
    }
}
