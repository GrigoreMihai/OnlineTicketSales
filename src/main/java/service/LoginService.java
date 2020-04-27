package service;

import models.user.User;
import repositories.UserRepository;

import java.util.Optional;

public class LoginService {

    private UserRepository userRepository;

    public LoginService() {
        userRepository = UserRepository.build(UserRepository.Type.ARRAY);
    }

    public boolean login(User user) {
        Optional<User> result = userRepository.findUserByUsername(user.getUsername());

        if (result.isPresent()) {
            User u = result.get();
            if (u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }

        return false;
    }

    public void register(User user) {
        userRepository.addUser(user);
    }
}