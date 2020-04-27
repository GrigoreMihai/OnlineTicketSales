package repositories;

import models.user.User;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetUserRepository implements UserRepository {
    Set<User> users = new TreeSet<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
