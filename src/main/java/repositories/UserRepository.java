package repositories;

import models.user.User;

import java.util.Optional;

public interface UserRepository {

    void addUser(User user);
    Optional<User> findUserByUsername(String username);

    static UserRepository build(Type type) {
        switch (type) {
           // case FILE: return new FileUserRepository();
            case ARRAY:return new ArrayUserRepository();
            case SET : return new TreeSetUserRepository();
        }
        throw new RuntimeException("No such type");
    }

    enum Type {
        FILE, ARRAY, SET,
    }
}
