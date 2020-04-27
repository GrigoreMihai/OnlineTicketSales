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
        user.setUsername("bill");
        user.setPassword("12345");
        LoginService loginService = new LoginService(LoginService.Type.FILE);
        loginService.register(user);
        System.out.println(loginService.login(user));




    }
}
