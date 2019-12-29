package com.labs.controllers.REST;
import com.labs.models.User;
import org.springframework.web.bind.annotation.*;
import com.labs.services.dbService;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class userController {

    @RequestMapping( value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUser(@RequestParam(value="order", defaultValue="id") String order) {
        dbService dbS = new dbService();
        return  dbS.findAllUsersOrdered(order);
    }

    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@RequestParam(value="id", defaultValue="1") int id) {
        dbService dbS = new dbService();
        return  dbS.findUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postUser(@RequestBody User us) {
        dbService dbS = new dbService();
        dbS.saveUser(us);
        return "Post succeed!";
    }
//    public String postUser(
//            @RequestParam(value = "firstName",  defaultValue = "defFirstName") String firstName,
//            @RequestParam(value = "lastName", defaultValue = "defLastName") String lastName,
//            @RequestParam(value = "email", defaultValue = "def@mail.ru") String email,
//            @RequestParam(value = "date_of_Birth", defaultValue = "20.01.1998") String date_of_Birth,
//            @RequestParam(value = "gender", defaultValue = "male") String gender
//            ) {
//        dbService dbS = new dbService();
//        User us = new User(firstName, lastName, email, date_of_Birth, gender);
//        dbS.saveUser(us);
//        return "Post succeed!";
//    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String putUser( @RequestBody User us) {
        dbService dbS = new dbService();
        dbS.updateUser(us);
        return "Put succeed!";
    }
//    public String putUser(
//            @RequestParam(value = "id",  defaultValue = "1") int id,
//            @RequestParam(value = "firstName",  defaultValue = "defFirstName") String firstName,
//            @RequestParam(value = "lastName", defaultValue = "defLastName") String lastName,
//            @RequestParam(value = "email", defaultValue = "def@mail.ru") String email,
//            @RequestParam(value = "date_of_Birth", defaultValue = "00.00.0000") String date_of_Birth,
//            @RequestParam(value = "gender", defaultValue = "male") String gender
//    ) {
//        dbService dbS = new dbService();
//        User us = dbS.findUserById(id);
//        if(us != null) {
//            if(!firstName.equals("defFirstName"))
//                us.setFirstName(firstName);
//            if(!lastName.equals("defLastName"))
//                us.setLastName(lastName);
//            if(!email.equals("def@mail.ru"))
//                us.setEmail(email);
//            if(!date_of_Birth.equals("00.00.0000"))
//                us.setDate_of_Birth(date_of_Birth);
//            if(!gender.equals("not_specified"))
//                us.setGender(gender);
//
//            dbS.updateUser(us);
//        }else {
//            User newUser = new User(firstName, lastName, email, date_of_Birth, gender);
//            dbS.saveUser(newUser);
//        }
//        return "Put succeed!";
//    }

    @RequestMapping( method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@RequestParam(value="id", defaultValue="1") int id) {
        dbService dbS = new dbService();
        dbS.deleteUser(dbS.findUserById(id));
        return "Delete succeed!";
    }
}
