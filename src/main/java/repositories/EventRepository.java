package repositories;

import models.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository {

    void addEvent(Event Event);
    Optional<List<Event>> listAll ();
    Optional<Event> findEventByEventname(String Eventname);

    static EventRepository build(Type type) {
        switch (type) {
            case FILE: return new FileEventRepository();
            case ARRAY:return new ArrayEventRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        FILE, ARRAY
    }
}
