package repositories;

import exceptions.InexistentFileExeception;
import models.Company;
import models.Location;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class FileLocationRepository implements LocationRepository {
    private final String file = "LOCATIONS.csv";
    private final File EventsFile = new File("LOCATIONS.csv");
    @Override
    public void add(Location l) {
        try{
            if(!EventsFile.exists()){
                System.out.println("Made new file");
                EventsFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(EventsFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(l.getId()+"," + l.getName()+","+ l.getCapacity() + "," + l.getRentPricePerDay() + "," +l.getRentPricePerDay() +"\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Location> findLocationByLocationName(String name) {
        Path path = Paths.get(file);
        Location c = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileExeception();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(",");
                if (attr[1].equals(name)) {
                    c = new Location();
                    c.setId(parseInt(attr[0]));
                    c.setName(attr[1]);
                    c.setCapacity(parseInt(attr[2]));
                    c.setRentPricePerDay(parseInt(attr[3]));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(c);
    }
    @Override
    public Optional<List<Location>> listAll() {
        Path path = Paths.get(file);
        List<Location> locations = new ArrayList<>();


        try {
            if (!Files.exists(path)) {
                throw new InexistentFileExeception();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(",");
                Location c = new Location();
                c.setId(parseInt(attr[0]));
                c.setName(attr[1]);
                c.setCapacity(parseInt(attr[2]));
                c.setRentPricePerDay(parseInt(attr[3]));
                locations.add(c);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(locations);
    }
}
