package com.labs.dao;
import com.labs.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.labs.utils.Hibernate;

import java.util.List;

public class UserDao {

    public static User findById(int id)
    {
        return Hibernate.getSessionFactory().openSession().get(User.class,id);
    }

    public static void save(User us)
    {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(us);
        transaction.commit();
        session.close();
    }

    public static void update(User us) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(us);
        transaction.commit();
        session.close();
    }

    public static void delete(User us) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User tmpUser = session.load(User.class, us.getId_user());
        if(tmpUser != null) {
            session.delete(tmpUser);
        }
        transaction.commit();
        session.close();
    }

    public static List<User> findAll() {
        return (List<User>) Hibernate.getSessionFactory().openSession().createQuery("FROM User").list();
    }

    public static List<User> getAllOrdered(String order) {
        return (List<User>) Hibernate.getSessionFactory().openSession().createQuery("FROM User ORDER BY "+order).list();
    }
}
