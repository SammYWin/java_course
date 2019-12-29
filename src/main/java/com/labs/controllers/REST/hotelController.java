package com.labs.controllers.REST;
import com.labs.models.Hotel;
import org.springframework.web.bind.annotation.*;
import com.labs.services.dbService;
import java.util.List;

@RestController
@RequestMapping(value = "/hotels")
public class hotelController {

    @RequestMapping( value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Hotel> getHotels() {
        dbService dbS = new dbService();
        return  dbS.findAllHotels();
    }

    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    public Hotel getHotel(@RequestParam(value="id", defaultValue="1") int id) {
        dbService dbS = new dbService();
        return  dbS.findHotelById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postHotel(@RequestBody Hotel ht) {
        dbService dbS = new dbService();
        dbS.saveHotel(ht);
        return "Post succeed!";
    }
//    public String postHotel(
//            @RequestParam(value = "name",  defaultValue = "defName") String name,
//            @RequestParam(value = "brief_description", defaultValue = "defDescription") String brief_description,
//            @RequestParam(value = "country", defaultValue = "defCountry") String country,
//            @RequestParam(value = "city", defaultValue = "defCity") String city,
//            @RequestParam(value = "number_of_stars", defaultValue = "3") int number_of_stars,
//            @RequestParam(value = "website", defaultValue = "www.her_pospish.ru") String website
//    ) {
//        dbService dbS = new dbService();
//        Hotel ht = new Hotel(name, brief_description, country, city, number_of_stars, website);
//        dbS.saveHotel(ht);
//        return "Post succeed!";
//    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String putHotel( @RequestBody Hotel ht) {
        dbService dbS = new dbService();
        dbS.updateHotel(ht);
        return "Put succeed!";
    }
//    public String putHotel(
//            @RequestParam(value = "id",  defaultValue = "1") int id,
//            @RequestParam(value = "name",  defaultValue = "defName") String name,
//            @RequestParam(value = "brief_description", defaultValue = "defDescription") String brief_description,
//            @RequestParam(value = "country", defaultValue = "defCountry") String country,
//            @RequestParam(value = "city", defaultValue = "defCity") String city,
//            @RequestParam(value = "number_of_stars", defaultValue = "0") int number_of_stars,
//            @RequestParam(value = "website", defaultValue = "www.her_pospish.ru") String website
//    ) {
//        dbService dbS = new dbService();
//        Hotel ht = dbS.findHotelById(id);
//        if(ht != null) {
//            if(!name.equals("defName"))
//                ht.setName(name);
//            if(!brief_description.equals("defDescription"))
//                ht.setBrief_description(brief_description);
//            if(!country.equals("defCountry"))
//                ht.setCountry(country);
//            if(!city.equals("defCity"))
//                ht.setCity(city);
//            if(number_of_stars != 0)
//                ht.setNumber_of_stars(number_of_stars);
//            if(!website.equals("www.her_pospish.ru"))
//                ht.setWebsite(website);
//
//            dbS.updateHotel(ht);
//        }else {
//            ht = new Hotel(name, brief_description, country, city, number_of_stars, website);
//            dbS.saveHotel(ht);
//        }
//        return "Put succeed!";
//    }

    @RequestMapping( method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteHotel(@RequestParam(value="id", defaultValue="1") int id) {
        dbService dbS = new dbService();
        dbS.deleteHotel(dbS.findHotelById(id));
        return "Delete succeed!";
    }
}
