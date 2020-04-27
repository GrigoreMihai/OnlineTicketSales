package service;

import models.user.User;

import java.io.*;
import java.nio.file.*;
import java.sql.Timestamp;

public class Watcher {
    private File logFile = new File("LOGS.csv");
    private void write(String logThis) {
        try {
            if (!logFile.exists()) {
                System.out.println("made a new file");
                logFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(logFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(logThis);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Watcher() {
        final Path path = FileSystems.getDefault().getPath("./");
        System.out.println(path);
        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
            final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            while (true) {
                final WatchKey wk = watchService.take();
                for (WatchEvent<?> event : wk.pollEvents()) {
                    final Path changed = (Path) event.context();
                    System.out.println(changed);
                    //switch was better
                    if (changed.endsWith("USERS.csv")) {
                        write("USERS FILE" + ", " + new Timestamp(System.currentTimeMillis()) + "\n" );
                    }
                    if (changed.endsWith("COMPANIES.csv")) {
                        write("COMPANIES FILE" + ", " + new Timestamp(System.currentTimeMillis()) + "\n" );
                    }
                    if (changed.endsWith("EVENTS.csv")) {
                        write("EVENTS FILE" + ", " + new Timestamp(System.currentTimeMillis()) + "\n" );
                    }
                    if (changed.endsWith("TICKETS.csv")) {
                        write("TICKETS FILE" + ", " + new Timestamp(System.currentTimeMillis()) + "\n" );
                    }
                    if (changed.endsWith("CARDS.csv")) {
                        write("CARDS FILE" + ", " + new Timestamp(System.currentTimeMillis()) + "\n" );
                    }
                    if (changed.endsWith("LOCATIONS.csv")) {
                        write("LOCATIONS FILE" + ", " + new Timestamp(System.currentTimeMillis()) + "\n" );
                    }

                }

                boolean valid = wk.reset();
                if (!valid) {
                    System.out.println("Key has been unregisterede");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}