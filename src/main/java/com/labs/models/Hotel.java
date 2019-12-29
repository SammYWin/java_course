package com.labs.models;
import javax.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @Column(name="Id_hotel")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id_hotel;
    @Column(name="name", length=128)
    private String name;
    @Column(name="brief_description", length=256)
    private String brief_description;
    @Column(name="country", length=128)
    private String country;
    @Column(name="city", length=128)
    private String city;
    @Column(name="number_of_stars")
    private int number_of_stars;
    @Column(name="website", length=128)
    private String website;
    @ManyToOne(fetch = FetchType.LAZY,optional=true)
    @JoinTable(name = "hotel_reviews", joinColumns = @JoinColumn(name = "Id_hotel"), inverseJoinColumns = @JoinColumn(name = "Id_user"))
    private User user;

    public Hotel(){}
    public Hotel(String name, String brief_description, String country, String city, int number_of_stars, String website)
    {
        this.name=name;
        this.brief_description=brief_description;
        this.country=country;
        this.city=city;
        this.number_of_stars=number_of_stars;
        this.website=website;
    }

    public int getId_hotel() {
        return Id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        Id_hotel = id_hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief_description() {
        return brief_description;
    }

    public void setBrief_description(String brief_description) {
        this.brief_description = brief_description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber_of_stars() {
        return number_of_stars;
    }

    public void setNumber_of_stars(int number_of_stars) {
        this.number_of_stars = number_of_stars;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "hotel:\n"+
                "Id_hotel: "+this.Id_hotel+"\n"+
                "Name: "+this.getName()+"\n"+
                "Brief_description: "+this.getBrief_description()+"\n"+
                "Country: " +this.getCountry()+"\n"+
                "City: "+this.getCity()+"\n"+
                "Number_of_stars: "+this.getNumber_of_stars()+"\n"+
                "Website: "+this.getWebsite()+"\n";
    }
}
