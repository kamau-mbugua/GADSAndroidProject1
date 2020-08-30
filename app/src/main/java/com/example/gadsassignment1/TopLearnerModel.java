package com.example.gadsassignment1;

public class TopLearnerModel {
    private String  name,hours,country,badge;

    public TopLearnerModel() {
    }

    public TopLearnerModel(String name, String hours, String country, String badge) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badge = badge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }
}
