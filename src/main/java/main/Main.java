package main;

import com.mysql.cj.log.Log;
import models.Card;
import models.Company;
import models.Event;
import models.Location;
import models.user.User;
import repositories.EventRepository;
import repositories.UserRepository;
import service.LoginService;

import java.sql.Date;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //test user file and login
        User user = new User();
        user.setUsername("john");
        user.setPassword("1234567");
        LoginService loginService = new LoginService(LoginService.Type.FILE);
        User user2 = new User(1,"john","wrong");
        loginService.register(user);
        System.out.println(loginService.login(user) ? "succesfull login" : "wrong password");
        System.out.println(loginService.login(user2) ? "succesfull login" : "wrong password (expected)");

        //test event file read and write
        Location loc1 = new Location(1,"here",700,5);
        Card c1 = new Card(1,"0777 7777  7777 7777");
        Company comp1 = new Company(1, "best company", "fdsdsfdfs",0,c1);
        EventRepository events =  EventRepository.build(EventRepository.Type.FILE);
        events.addEvent(new Event (1,"Concert", loc1,comp1,7000));
        events.addEvent(new Event (7,"Teatru",loc1,comp1, 775));
        events.addEvent(new Event (5,"Stand up comedy",loc1, comp1 , 5 ) );
        events.listAll().stream().forEach( e -> {
            System.out.println(e.toString());
        });



    }
}
