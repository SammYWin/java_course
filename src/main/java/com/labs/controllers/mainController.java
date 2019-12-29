package com.labs.controllers;

import com.labs.models.Hotel;
import com.labs.models.HotelReview;
import com.labs.models.User;
import com.labs.services.dbService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class mainController {
    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/users_list")
    public String usersList(Model model) throws IOException {
        dbService dbS=new dbService();
        List<User> us=dbS.findAllUsersOrdered("firstName");
        model.addAttribute("User", us);
        return  "usersList";
    }

    @GetMapping("/add_user")
    public String addUser() throws IOException {
        return  "addUser";
    }

    @GetMapping("/edit_user")
    public String editUser(@RequestParam(value="id", defaultValue="1") int id, Model model) throws IOException {
        dbService dbS=new dbService();
        User us=dbS.findUserById(id);
        model.addAttribute("User", us);
        return  "editUser";
    }

    @GetMapping("/hotels_list")
    public String hotelsList(Model model) throws IOException {
        dbService dbS=new dbService();
        List<Hotel> ht=dbS.findAllHotels();
        model.addAttribute("Hotel", ht);
        return  "hotelsList";
    }

    @GetMapping("/add_hotel")
    public String addHotel() throws IOException {
        return  "addHotel";
    }

    @GetMapping("/edit_hotel")
    public String editHotel(@RequestParam(value="id", defaultValue="1") int id, Model model) throws IOException {
        dbService dbS=new dbService();
        Hotel ht=dbS.findHotelById(id);
        model.addAttribute("Hotel", ht);
        return  "editHotel";
    }

    @GetMapping("/reviews_list")
    public String rewviewsList(Model model) throws IOException {
        dbService dbS=new dbService();
        List<HotelReview> hr=dbS.findAllHotelReviews();
        model.addAttribute("HotelReview", hr);
        return  "reviewsList";
    }

    @GetMapping("/add_review")
    public String addReveiw() throws IOException {
        return  "addReview";
    }

    @GetMapping("/edit_review")
    public String editReview(@RequestParam(value="id", defaultValue="1") int id, Model model) throws IOException {
        dbService dbS=new dbService();
        HotelReview hr=dbS.findHotelReviewById(id);
        model.addAttribute("HotelReview", hr);
        return  "editReview";
    }
}
