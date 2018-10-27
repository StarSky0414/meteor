package com.starsky.meteor.db;

import com.starsky.meteor.customexception.db.FieldAlreadyExists;
import com.starsky.meteor.customexception.db.SelectListNone;
import com.starsky.meteor.db.op.DBBean;
import com.starsky.meteor.db.op.UserInfoEntity;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DBBaseTest {

    @Test
    void query() {
        for (int i = 0; i <= 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<DBBean> userInfoEntity = null;
                    String userPhone = "1";
                    String sql = "select * from user_info where user_phone= :user_phone ";
                    HashMap<String, Object> stringStringHashMap = new HashMap<>();
                    stringStringHashMap.put("user_phone", userPhone);
                    DBBase dbBase = DBBase.getDBBase();
                    try {
                        userInfoEntity = dbBase.query(sql, stringStringHashMap, UserInfoEntity.class);
                    } catch (SelectListNone selectListNone) {
                        selectListNone.printStackTrace();
                    }
//                    UserInfoEntity query = (UserInfoEntity) (userInfoEntity.get(0));
//                    System.out.println(query.getUserNickname());
                }
            }).start();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    void insert() {
        String userPhone = "000";
        String hql = "insert into user_info (user_phone) values (:userPhone)";
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("userPhone", userPhone);
        DBBase dbBase = DBBase.getDBBase();
        try {
            dbBase.insert(hql, stringObjectHashMap);
        } catch (FieldAlreadyExists fieldAlreadyExists) {
            fieldAlreadyExists.printStackTrace();
        }
    }

    @Test
    void testUpdate() {
        for (int i = 0; i <= 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String userNickname = "asdasd";
                    String userPassword = "dddd";
                    String userPhone = "000";
                    String sql = "update user_info set user_nickname=:userNickname,user_password=:userPassword where user_phone=:userPhone";
                    HashMap<String, Object> stringObjectHashMap = new HashMap<>();
                    stringObjectHashMap.put("userNickname", userNickname);
                    stringObjectHashMap.put("userPassword", userPassword);
                    stringObjectHashMap.put("userPhone", userPhone);
                    DBBase dbBase = DBBase.getDBBase();
                    dbBase.update(sql, stringObjectHashMap);
                }
            }).start();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}