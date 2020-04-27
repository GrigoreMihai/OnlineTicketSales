package service;

import models.user.User;
import repositories.ArrayUserRepository;
import repositories.TreeSetUserRepository;
import repositories.UserRepository;

import java.util.Optional;

public class LoginService {

    private UserRepository userRepository;

    public LoginService(Type type) {
        switch (type) {
            case FILE:  {
                this.userRepository = UserRepository.build(UserRepository.Type.FILE);
                break;
            }
            case ARRAY :  {
                this.userRepository = UserRepository.build(UserRepository.Type.ARRAY);
                break;
            }
            case SET :  {
                this.userRepository = UserRepository.build(UserRepository.Type.SET);
                break;
            }
        }
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
    public enum Type {
        FILE, ARRAY, SET,
    }
}