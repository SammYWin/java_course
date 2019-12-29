package com.labs.services;
import com.labs.dao.HotelDao;
import com.labs.dao.HotelReviewDao;
import com.labs.dao.UserDao;
import com.labs.models.Hotel;
import com.labs.models.HotelReview;
import com.labs.models.User;

import java.util.List;

public class dbService {

    public dbService() {}

    public User findUserById(int id) { return UserDao.findById(id); }
    public List<User> findAllUsersOrdered(String order) { return UserDao.getAllOrdered(order); }
    public void saveUser(User us) { UserDao.save(us); }
    public void updateUser(User us) { UserDao.update(us); }
    public void deleteUser(User us) { UserDao.delete(us); }

    public Hotel findHotelById(int id) { return HotelDao.findById(id); }
    public List<Hotel> findAllHotels() { return HotelDao.findAll(); }
    public void saveHotel(Hotel ht) { HotelDao.save(ht); }
    public void updateHotel(Hotel ht) {HotelDao.update(ht); }
    public void deleteHotel(Hotel ht) { HotelDao.delete(ht); }

    public HotelReview findHotelReviewById(int id){ return HotelReviewDao.findById(id); }
    public List<HotelReview> findAllHotelReviews() { return HotelReviewDao.findAll(); }
    public void saveHotelReview(HotelReview htr) { HotelReviewDao.save(htr); }
    public void updateHotelReview(HotelReview htr) { HotelReviewDao.update(htr); }
    public void deleteHotelReview(HotelReview htr) { HotelReviewDao.delete(htr); }
}
