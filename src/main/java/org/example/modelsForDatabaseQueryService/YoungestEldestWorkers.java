package org.example.modelsForDatabaseQueryService;

import java.sql.Date;

public class YoungestEldestWorkers {
    private String name;
    private Date birthday;

    public YoungestEldestWorkers(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfEmployment() {
        return birthday;
    }
}
