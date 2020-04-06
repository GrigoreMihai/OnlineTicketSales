package models;

import java.sql.Date;
import java.time.Duration;

public class Event {

    private String name;

    private Date startDate;

    private Date endDate;

    private Location location;

    public OrganizerCompany getOrganizerCompany() {
        return organizerCompany;
    }

    void setOrganizerCompany(OrganizerCompany organizerCompany) {
        this.organizerCompany = organizerCompany;
    }

    private OrganizerCompany organizerCompany;

    private long price;

    void computePrice () {
        this.price = this.location.getRentPricePerDay() * Duration.between( this.getEndDate().toInstant(), this.getStartDate().toInstant() ).toDays() ;
    }

    public long getPrice() {
        return price;
    }

    String getName() {
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

}
