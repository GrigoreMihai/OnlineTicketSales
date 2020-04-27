package main;

import com.mysql.cj.log.Log;
import models.Event;
import models.user.User;
import repositories.EventRepository;
import repositories.UserRepository;
import service.LoginService;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        user.setUsername("bwewqwl");
        user.setPassword("12345sdafsadf");
        LoginService loginService = new LoginService(LoginService.Type.FILE);
        User user2 = new User(1,"sdfasfda","asdfdsfa");
        loginService.register(user);
        loginService.register(user2);
        System.out.println(loginService.login(user));




    }
}
