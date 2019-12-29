package com.labs.dao;
import com.labs.models.HotelReview;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.labs.utils.Hibernate;
import java.util.List;

public class HotelReviewDao {

    public static HotelReview findById(int id)
    {
        return Hibernate.getSessionFactory().openSession().get(HotelReview.class,id);
    }

    public static void save(HotelReview hr)
    {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(hr);
        transaction.commit();
        session.close();
    }

    public static void update(HotelReview hr) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(hr);
        transaction.commit();
        session.close();
    }

    public static void delete(HotelReview hr) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        HotelReview tmpReview = session.load(HotelReview.class, hr.getId_hotel_review());
        if(tmpReview != null) {
            session.delete(tmpReview);
        }
        transaction.commit();
        session.close();
    }
    public static List<HotelReview> findAll() {
        return  (List<HotelReview>)  Hibernate.getSessionFactory().openSession().createQuery("From HotelReview").list();
    }
}
