package models;

import java.sql.Date;

public class Location {
    private String name;

    private int capacity;

    private int rentPricePerDay;

    private Date startRent;

    private Date endRent;

    public Location(String name, int capacity, int rentPricePerDay, Date startRent, Date endRent) {
        this.name = name;
        this.capacity = capacity;
        this.rentPricePerDay = rentPricePerDay;
        this.startRent = startRent;
        this.endRent = endRent;
    }

    public int getCapacity() {
        return capacity;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRentPricePerDay() {
        return rentPricePerDay;
    }

    void setRentPricePerDay(int rentPricePerDay) {
        this.rentPricePerDay = rentPricePerDay;
    }

    public Date getStartRent() {
        return startRent;
    }

    public void setStartRent(Date startRent) {
        this.startRent = startRent;
    }

    public Date getEndRent() {
        return endRent;
    }

    public void setEndRent(Date endRent) {
        this.endRent = endRent;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
