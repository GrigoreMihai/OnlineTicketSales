package repositories;

import exceptions.InexistentFileExeception;
import models.Event;

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

public class FileEventRepository implements EventRepository {
    private final String file = "EVENTS.csv";
    private File EventsFile = new File("EVENTS.csv");
    @Override
    public void addEvent(Event event) {
        try{
            if(!EventsFile.exists()){
                System.out.println("Made new file");
                EventsFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(EventsFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println(event.toString());
            bufferedWriter.write(event.getId()+"," + event.getName()+","+ event.getPrice() + ","+ event.getCompany().toString() +"\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Event> findEventByEventname(String eventName) {
        Path path = Paths.get(file);
        Event event = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileExeception();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(",");
                if (attr[1].equals(eventName)) {
                    event = new Event();
                    event.setId(parseInt(attr[0]));
                    event.setName(attr[1]);

                    event.setPrice(parseInt(attr[2]));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(event);
    }
    @Override
    public Optional<List<Event>> listAll() {
        Path path = Paths.get(file);
        List<Event> events = new ArrayList<>();


        try {
            if (!Files.exists(path)) {
                throw new InexistentFileExeception();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(",");
                Event event = new Event();
                event.setId(parseInt(attr[0]));
                event.setName(attr[1]);
                event.setPrice(parseInt(attr[2]));
                events.add(event);
                break;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(events);
    }
}

