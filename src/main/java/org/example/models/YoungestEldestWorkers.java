package org.example.models;

public class YoungestEldestWorkers {
    private String name;
    private String dateOfEmployment;

    public YoungestEldestWorkers(String name, String dateOfEmployment) {
        this.name = name;
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getName() {
        return name;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }
}
