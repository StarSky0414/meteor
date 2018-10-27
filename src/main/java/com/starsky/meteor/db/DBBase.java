package com.starsky.meteor.db;


import com.starsky.meteor.customexception.db.FieldAlreadyExists;
import com.starsky.meteor.customexception.db.SelectListNone;
import com.starsky.meteor.db.op.DBBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 重新封装数据库基本
 */
public class DBBase implements ResultTransformer {

    volatile private static DBBase dbBase;
    private static Session session;
    private static Transaction transaction;


    private DBBase() {
    }

    private void init() {
        session = HibernateFactory.getSession();
        transaction = session.beginTransaction();
    }

    private void clear() {
        if (session != null) {
            session.close();
        }
    }

    public static DBBase getDBBase() {
        if (dbBase == null) {
            dbBase = new DBBase();
        }
        return dbBase;
    }


    public List query(String sql, HashMap<String, Object> parameter, Class aClass) throws SelectListNone {
        init();
        NativeQuery sqlQuery = session.createSQLQuery(sql).addEntity(aClass);
        for (HashMap.Entry<String, Object> entry : parameter.entrySet()) {
            sqlQuery.setParameter(entry.getKey(), entry.getValue());
        }
        List list = sqlQuery.list();
        clear();
        if (list == null && list.size() == 0) {
            throw new SelectListNone();
        }
        return list;
    }

    public List query(String sql, List parameter, Class aClass) throws SelectListNone {
        init();
        Query sqlQuery = session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(aClass));
        for (int i=0 ;i<parameter.size();i++){
            sqlQuery.setParameter(i,parameter.get(i));
        }
        List list = sqlQuery.list();
        clear();
        if (list == null && list.size() == 0) {
            throw new SelectListNone();
        }
        return list;
    }

    public int update(String hql, HashMap<String, Object> parameter) {
        init();
        Query query = session.createSQLQuery(hql);
        for (HashMap.Entry<String, Object> entry : parameter.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        int i = query.executeUpdate();
        transaction.commit();
        clear();
        System.out.println(i);
        return i;
    }

    public int insert(String sql, HashMap<String, Object> parameter) throws FieldAlreadyExists {
        init();
        Query query = session.createSQLQuery(sql);
        for (HashMap.Entry<String, Object> entry : parameter.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        int i=0;
        try {

            i = query.executeUpdate();
        }catch (ConstraintViolationException e){
            throw  new FieldAlreadyExists();
        }
        transaction.commit();
        clear();
        System.out.println(i);
        return i;
    }

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        Map result = new HashMap(tuple.length);
        for ( int i=0; i<tuple.length; i++ ) {
            String alias = aliases[i];
            if ( alias!=null ) {
                result.put( alias, tuple[i] );
            }
        }

        return result;
    }

    @Override
    public List transformList(List list) {
        return Arrays.asList( list );
    }
}
