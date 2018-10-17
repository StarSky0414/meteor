package com.starsky.meteor.db.provider;

import com.starsky.meteor.db.HibernateFactory;
import com.starsky.meteor.db.op.UserInfoEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class UserInfoProvider {
    private final Session session;
    Transaction transaction;
    public UserInfoProvider(){
        session = HibernateFactory.getSession();
        transaction = session.beginTransaction();
    }

    public void CreateUserInfo(String userPhone){
        String sql="insert into user_info (user_phone) values (?);";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setString(0,userPhone);
        sqlQuery.executeUpdate();
//        transaction.commit();
    }

    public void updateUserInfo(String nickName, String password, String phoneNumber){
        String sql="update  UserInfoEntity user_info set  user_info.userNickname=:userNickname,user_info.userPassword=:userPassword where user_info.userPhone=:userPhone";
        Query sqlQuery = session.createQuery(sql);
        sqlQuery.setString("userNickname",nickName);
        sqlQuery.setString("userPassword",password);
        sqlQuery.setString("userPhone",phoneNumber);
        sqlQuery.executeUpdate();
        transaction.commit();
//        session.getTransaction().commit();
    }

    public UserInfoEntity queryUserInfo(String phoneNumber) throws IndexOutOfBoundsException{
        Session session = HibernateFactory.getSession();
        transaction = session.beginTransaction();
        String sql="select * from user_info where user_phone= :user_phone ";
        NativeQuery sqlQuery = session.createSQLQuery(sql).addEntity(UserInfoEntity.class);
        sqlQuery.setParameter("user_phone",phoneNumber);
        List<UserInfoEntity> list = sqlQuery.list();
        System.out.println(list.get(0).getUserNickname());
        transaction.commit();
        return list.get(0);
    }
}
