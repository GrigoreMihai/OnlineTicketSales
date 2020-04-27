package models;

import models.user.User;

public class UserCompany extends User {

    private Company company;

    public UserCompany(int id, String username, String password, Company company) {
        super(id, username, password);
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }





}
