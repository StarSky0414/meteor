package com.starsky.meteor.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateFactory {

    private Logger logger=LoggerFactory.getLogger(HibernateFactory.class);
    private static SessionFactory sessionFactory=null;

    private HibernateFactory(){
    }

    static {
        createHibernateSession();
    }

    private static void createHibernateSession(){
        Configuration configure = new Configuration().configure();
        sessionFactory = configure.buildSessionFactory();
//        sessionFactory = new Configuration().buildSessionFactory();
    }

    public static Session getSession(){
        if (sessionFactory==null){
            createHibernateSession();
        }
        return sessionFactory.getCurrentSession();
    }


    public static void closeSession(Session session){
        if (session!=null){
            session.close();
        }
    }

    public static void shutdown (){
        if (sessionFactory!=null){
            sessionFactory.close();
        }
    }

}
