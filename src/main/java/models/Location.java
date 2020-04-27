package models;

import java.sql.Date;

public class Location {


    private int id;

    private String name;

    private int capacity;

    private int rentPricePerDay;

    private int days;

    public Location(int id,String name, int capacity, int rentPricePerDay) {
        this.name = name;
        this.capacity = capacity;
        this.rentPricePerDay = rentPricePerDay;

    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRentPricePerDay() {
        return rentPricePerDay;
    }

    public void setRentPricePerDay(int rentPricePerDay) {
        this.rentPricePerDay = rentPricePerDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", rentPricePerDay=" + rentPricePerDay +
                ", days=" + days +
                '}';
    }
}
