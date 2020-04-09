package models;

public class Ticket {
    private int id;

    private String name;

    private int price;

    private Event event;

    public Ticket(int id, String name, int price, Event event) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
