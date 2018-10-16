package com.starsky.meteor.db.provider;

import com.starsky.meteor.db.HibernateFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class UserInfoProvider {
    private final Session session;
    Transaction transaction;
    public UserInfoProvider(){
        session = HibernateFactory.getSession();
        transaction = session.beginTransaction();
    }

    public void CreateUserInfo(String userPhone){
        String hql="insert into user_info (user_phone) values (?);";
        NativeQuery sqlQuery = session.createSQLQuery(hql);
//        sqlQuery.addEntity("userPhone",userPhone);
        sqlQuery.setString(0,userPhone);

        sqlQuery.executeUpdate();
        transaction.commit();
    }
}
