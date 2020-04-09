package models;

import java.sql.Date;
import java.time.Duration;

public class Event {

    private int id;

    private String name;

    private Date startDate;

    private Date endDate;

    private Location location;

    public Event(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location=" + location +
                ", Company=" + Company +
                ", price=" + price +
                '}';
    }

    public Event(int id, String name, Date startDate, Date endDate, Location location, models.Company company, long price) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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
        this.price = this.location.getRentPricePerDay() * Duration.between( this.getEndDate().toInstant(), this.getStartDate().toInstant() ).toDays() ;
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Location getLocation() {
        return location;
    }

    void setLocation(Location location) {
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
