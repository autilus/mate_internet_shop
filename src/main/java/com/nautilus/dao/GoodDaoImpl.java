package com.nautilus.dao;

import com.nautilus.model.Good;
import com.nautilus.model.User;
import com.nautilus.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GoodDaoImpl implements GoodDao {
    private static String FIND_ID_BY_NAME_QUERY = "select id from Good u where u.name=:name";
    private static String FIND_ALL_QUERY = "select * from User";

    @Override
    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public Long findIdByName(String name) {
        return (Long) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery(FIND_ID_BY_NAME_QUERY)
                .setParameter("name", name)
                .getResultList().get(0);
    }

    @Override
    public void save(Good good) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.save(good);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Good good) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.update(good);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Good good) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(good);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Good> findAll() {
        List<Good> goods = (List<Good>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery(FIND_ALL_QUERY).list();
        return goods;
    }
}
