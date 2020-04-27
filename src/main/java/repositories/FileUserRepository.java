package repositories;

import exceptions.InexistentFileExeception;
import models.user.User;
import service.Watcher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileUserRepository implements UserRepository {

    private final String file = "USERS.csv";
    private File usersFile = new File("USERS.csv");
    @Override
    public void addUser(User user) {
        try{
            if(!usersFile.exists()){
                System.out.println("We had to make a new file.");
                usersFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(usersFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(user.getId()+","+user.getUsername()+","+user.getPassword()+"\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        Path path = Paths.get(file);
        User user = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileExeception();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(","); // 1,john,12345
                if (attr[1].equals(username)) {
                    user = new User();
                    user.setId(Integer.parseInt(attr[0]));
                    user.setUsername(attr[1]);
                    user.setPassword(attr[2]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }
}
