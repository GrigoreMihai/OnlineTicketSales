package main;

import models.Event;
import models.User.User;
import repositories.EventRepository;
import repositories.UserRepository;
import service.LoginService;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = UserRepository.build(UserRepository.Type.ARRAY);
        User user = new User();
        user.setUsername("bill");
        user.setPassword("12345");
        LoginService loginService = new LoginService();
        loginService.register(user);
        System.out.println(loginService.login(user));

        EventRepository repository1 = EventRepository.build(EventRepository.Type.ARRAY);
        Event ev= new Event(1,"test");
        repository1.addEvent(ev);
        System.out.println(repository1.findEventByEventname(ev.getName()) );


    }
}
