package com.labs.controllers.REST;
import com.labs.models.Hotel;
import com.labs.models.HotelReview;
import com.labs.models.User;
import org.springframework.web.bind.annotation.*;
import com.labs.services.dbService;
import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class reviewController {

    @RequestMapping( value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<HotelReview> getReviews() {
        dbService dbS = new dbService();
        return  dbS.findAllHotelReviews();
    }

    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    public HotelReview getReview(@RequestParam(value="id", defaultValue="1") int id) {
        dbService dbS = new dbService();
        return  dbS.findHotelReviewById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postReview(
            @RequestParam(value = "date_of_user_visit",  defaultValue = "00.00.0000") String date_of_user_visit,
            @RequestParam(value = "rating", defaultValue = "0") String rating,
            @RequestParam(value = "review_text", defaultValue = "defText") String review_text,
            @RequestParam(value = "user_id", defaultValue = "1") int user_id,
            @RequestParam(value = "hotel_id", defaultValue = "1") int hotel_id
    ) {
        dbService dbS = new dbService();
        User us_id = dbS.findUserById(user_id);
        Hotel ht_id = dbS.findHotelById(hotel_id);
        HotelReview hr = new HotelReview(date_of_user_visit, rating, review_text, us_id, ht_id);
        dbS.saveHotelReview(hr);
        return "Post succeed!";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String putReview(
            @RequestParam(value = "id",  defaultValue = "1") int id,
            @RequestParam(value = "date_of_user_visit",  defaultValue = "00.00.0000") String date_of_user_visit,
            @RequestParam(value = "rating", defaultValue = "0") String rating,
            @RequestParam(value = "review_text", defaultValue = "defText") String review_text,
            @RequestParam(value = "user_id", defaultValue = "1") int user_id,
            @RequestParam(value = "hotel_id", defaultValue = "1") int hotel_id
    ) {
        dbService dbS = new dbService();
        HotelReview hr = dbS.findHotelReviewById(id);
        if(hr != null) {
            if(!date_of_user_visit.equals("00.00.0000"))
                hr.setDate_of_user_visit(date_of_user_visit);
            if(!rating.equals("0"))
                hr.setRating(rating);
            if(!review_text.equals("defText"))
                hr.setReview_text(review_text);

            dbS.updateHotelReview(hr);
        }else {
                return "Review not found!";
        }
        return "Put succeed!";
    }

    @RequestMapping( method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteReview(@RequestParam(value="id", defaultValue="1") int id) {
        dbService dbS = new dbService();
        dbS.deleteHotelReview(dbS.findHotelReviewById(id));
        return "Delete succeed!";
    }
}
