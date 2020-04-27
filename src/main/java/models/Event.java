package models;

import java.sql.Date;
import java.time.Duration;

public class Event {

    private int id;

    private String name;

    private Location location;

    public Event(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", Company=" + Company +
                ", price=" + price +
                '}';
    }

    public Event(int id, String name, Location location, models.Company company, long price) {
        this.id = id;
        this.name = name;
        this.location = location;
        Company = company;
        this.price = price;
    }

    public Company getCompany() {
        return Company;
    }

    void setCompany(Company Company) {
        this.Company = Company;
    }

    private Company Company;

    private long price;

    void computePrice () {
        this.price = this.location.getRentPricePerDay() * this.location.getDays();
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
