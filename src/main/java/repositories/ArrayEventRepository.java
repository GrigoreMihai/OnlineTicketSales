package repositories;



import models.Event;

import java.util.Optional;

public class ArrayEventRepository implements EventRepository {

    private Event[] Events = new Event[10];
    private int n;

    @Override
    public void addEvent(Event Event) {
        Events[n] = Event;
        n++;
    }

    @Override
    public Optional<Event> findEventByEventname(String Eventname) {
        for (int i = 0; i<n; i++) {
            if (Events[i].getName().equals(Eventname)) {
                return Optional.of(Events[i]);
            }
        }
        return Optional.empty();
    }
}
