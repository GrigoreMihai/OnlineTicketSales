package main;

import models.User.User;
import repositories.UserRepository;
import service.LoginService;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = UserRepository.build(UserRepository.Type.ARRAY);
        User user = new User();
        user.setUsername("bill");
        user.setPassword("12345");
        repository.addUser(user);
        LoginService loginService = new LoginService();
        System.out.println(loginService.login(user));

    }
}
