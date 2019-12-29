package com.labs.models;
import javax.persistence.*;

@Entity
@Table(name = "hotel_reviews")
public class HotelReview {
    @Id
    @Column(name="Id_hotel_review")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id_hotel_review;
    @Column(name="date_of_user_visit", length=32)
    private String date_of_user_visit;
    @Column(name="rating", length=6)
    private String rating;
    @Column(name="review_text", length=256)
    private String review_text;
    @ManyToOne
    @JoinColumn(name= "Id_user")
    private User Id_user;
    @ManyToOne
    @JoinColumn(name= "Id_hotel")
    private Hotel Id_hotel;

    public HotelReview() {
    }
    public HotelReview(String date_of_user_visit, String rating, String review_text, User Id_user, Hotel Id_hotel)
    {
        this.date_of_user_visit=date_of_user_visit;
        this.rating=rating;
        this.review_text=review_text;
        this.Id_user = Id_user;
        this.Id_hotel = Id_hotel;
    }

    public int getId_hotel_review() {
        return Id_hotel_review;
    }

    public void setId_hotel_review(int id_hotel_review) {
        Id_hotel_review = id_hotel_review;
    }

    public void setDate_of_user_visit(String date_of_user_visit) {
        this.date_of_user_visit = date_of_user_visit;
    }

    public String getDate_of_user_visit() {
        return date_of_user_visit;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "hotel_review:\n"+
                "Id_hotel_review: "+this.getId_hotel_review()+"\n"+
                "Date_of_user_visit: " +this.getDate_of_user_visit()+"\n"+
                "Rating: "+this.getRating()+"\n"+
                "Review_text: "+this.getReview_text()+"\n";
    }
}
