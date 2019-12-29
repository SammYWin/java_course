package com.labs.dao;
import com.labs.models.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.labs.utils.Hibernate;
import java.util.List;
public class HotelDao {

    public static Hotel findById(int id) {
        return Hibernate.getSessionFactory().openSession().get(Hotel.class, id);
    }

    public static void save(Hotel ht) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ht);
        transaction.commit();
        session.close();
    }

    public static void update(Hotel ht) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(ht);
        transaction.commit();
        session.close();
    }

    public static void delete(Hotel ht) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Hotel tmpHotel = session.load(Hotel.class, ht.getId_hotel());
        if(tmpHotel != null) {
            session.delete(tmpHotel);
        }
        transaction.commit();
        session.close();
    }

    public static List<Hotel> findAll() {
        List<Hotel> hotels = (List<Hotel>) Hibernate.getSessionFactory().openSession().createQuery("From Hotel").list();
        return hotels;
    }
}
