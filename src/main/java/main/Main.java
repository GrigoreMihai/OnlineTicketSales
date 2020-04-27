package main;

import com.mysql.cj.log.Log;
import models.Card;
import models.Company;
import models.Event;
import models.Location;
import models.user.User;
import repositories.*;
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
        loginService.register(new User(7,"Bill","password"));
        System.out.println(loginService.login(user) ? "succesfull login (expected)" : "wrong password");
        System.out.println(loginService.login(user2) ? "succesfull login" : "wrong password (expected)");

        //test event file read and write
        Location loc1 = new Location(1,"here",700,5);
        Card c1 = new Card(1,"0777 7777  7777 7777");
        Company comp1 = new Company(1, "best company", "83484287",0,c1);

        Location loc2 = new Location(2,"there",750,5);
        Card c2 = new Card(7,"0777 7777  7555 7777");
        Company comp2 = new Company(2, "Best events", "524322",10,c2);

        Location loc5 = new Location(5,"sea side",800,5);
        Card c5 = new Card(5,"0777 5557  7777 7777");
        Company comp5 = new Company(5, "best company", "542345542243",7,c5);

        EventRepository events =  EventRepository.build(EventRepository.Type.FILE);
        events.addEvent(new Event (1,"Concert", loc1,comp1,7000));
        events.addEvent(new Event (7,"Teatru",loc2,comp2, 775));
        events.addEvent(new Event (5,"Stand up comedy",loc5, comp5 , 5 ) );

        System.out.println( events.listAll().get().size() >=3 ? "parsing through events file (expected)" : "not parsing through file" );
        Optional<Event> event = events.findEventByEventname("Concert");
        if ( event.isPresent()) {
            Event e = event.get();
            if (e.getName().equals("Concert") ) {
                System.out.println("Found event");
            }
        }
        // test company file read and write
        CompanyRepository companies = CompanyRepository.build(CompanyRepository.Type.FILE);
        companies.add(comp1);
        companies.add(comp2);
        companies.add(comp5);
        System.out.println( companies.listAll().get().size() >=3 ? "parsing through companies file (expected)" : "not parsing through file" );

        Optional<Company> company = companies.findCompanyByCompanyname("Best events");
        if ( company.isPresent()) {
            Company e = company.get();
            if (e.getName().equals("Best events") ) {
                System.out.println("Found company");
            }
        }
        //test locations file read and write
        LocationRepository locations = LocationRepository.build(LocationRepository.Type.FILE);
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc5);
        System.out.println( "Listing all locations" );
        locations.listAll().stream().forEach( l ->{
            System.out.println(l.toString());
        });

        Optional<Location> location = locations.findLocationByLocationName("sea side");
        if ( location.isPresent()) {
            Location e = location.get();
            if (e.getName().equals("sea side") ) {
                System.out.println("Found location (expected)");
            }
        }
    }
}