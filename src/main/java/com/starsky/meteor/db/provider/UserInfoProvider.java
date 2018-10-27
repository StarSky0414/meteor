package com.starsky.meteor.db.provider;

import com.starsky.meteor.bean.message.FriendUserInfoList;
import com.starsky.meteor.customexception.NoUserInfo;
import com.starsky.meteor.customexception.db.SelectListNone;
import com.starsky.meteor.db.DBBase;
import com.starsky.meteor.db.HibernateFactory;
import com.starsky.meteor.db.op.UserInfoEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserInfoProvider {

    private final DBBase dbBase;

    public UserInfoProvider(){
        dbBase = DBBase.getDBBase();
    }

    public void CreateUserInfo(String userPhone){
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String sql="insert into user_info (user_phone) values (?);";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setString(0,userPhone);
        try {
            sqlQuery.executeUpdate();
        }catch (Exception e){
            System.out.println("发生异常");
        }finally {
            transaction.commit();
            session.close();
        }
    }

    public void updateUserInfo(String nickName, String password, String phoneNumber){
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String sql="update  UserInfoEntity user_info set  user_info.userNickname=:userNickname,user_info.userPassword=:userPassword where user_info.userPhone=:userPhone";
        Query sqlQuery = session.createQuery(sql);
        sqlQuery.setString("userNickname",nickName);
        sqlQuery.setString("userPassword",password);
        sqlQuery.setString("userPhone",phoneNumber);
        try {
            sqlQuery.executeUpdate();
        }catch (Exception e){
            System.out.println("发生异常");
        }finally {
            transaction.commit();
            session.close();
        }

//        session.getTransaction().commit();
    }

    public UserInfoEntity queryUserInfo(String phoneNumber) throws NoUserInfo {
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String sql="select * from user_info where user_phone= :user_phone ";
        NativeQuery sqlQuery = session.createSQLQuery(sql).addEntity(UserInfoEntity.class);
        sqlQuery.setParameter("user_phone",phoneNumber);
        List<UserInfoEntity> list = sqlQuery.list();
        System.out.println(list.get(0).getUserNickname());
        transaction.commit();
        session.close();
        if (list.size()==0){
            throw new NoUserInfo();
        }
        return list.get(0);
    }

    public List queryFriendUserInfo(String userId) throws SelectListNone {
        String sql = "select friend_id,user_head_link,user_follow.nickname from user_follow , user_info where user_id= ? and friend_id=user_info.id;";
        ArrayList<Object> parameterArrayList = new ArrayList<>();
        parameterArrayList.add(userId);
        List<FriendUserInfoList> query = dbBase.query(sql, parameterArrayList, FriendUserInfoList.class);
        return query;
    }
}
