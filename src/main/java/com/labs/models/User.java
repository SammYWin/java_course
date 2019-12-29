package com.labs.models;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name="Id_user")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id_user;
    @Column(name="firstName", length=64)
    private String firstName;
    @Column(name="lastName", length=64)
    private String lastName;
    @Column(name="email", length=128)
    private String email;
    @Column(name="date_of_Birth", length=32)
    private String date_of_Birth;
    @Column(name="gender", length=8)
    private String gender;
    @ManyToOne(fetch = FetchType.LAZY,optional=true)
    @JoinTable(name = "hotel_reviews", joinColumns = @JoinColumn(name = "Id_user"), inverseJoinColumns = @JoinColumn(name = "Id_hotel"))
    private Hotel hotel;


    public User() {}

    public User(String firstName, String lastName, String email, String date_of_Birth, String gender)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.date_of_Birth=date_of_Birth;
        this.gender=gender;
    }

    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int id_user) {
        Id_user = id_user;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_Birth() {
        return date_of_Birth;
    }

    public void setDate_of_Birth(String date_of_Birth) {
        this.date_of_Birth = date_of_Birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "user:\n"+
                "Id_user: "+this.getId_user()+"\n"+
                "firstName: "+this.getFirstName()+"\n"+
                "lastName: "+this.getLastName()+"\n"+
                "Email: "+this.getEmail()+"\n"+
                "Date_of_Birth: "+this.getDate_of_Birth()+"\n"+
                "Gender: "+this.getGender()+"\n";
    }
}
