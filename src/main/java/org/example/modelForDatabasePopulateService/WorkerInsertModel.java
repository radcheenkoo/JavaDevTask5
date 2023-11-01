package org.example.modelForDatabasePopulateService;

import java.sql.Date;

public class WorkerInsertModel {
    private int id;
    private String name;
    private Date birthday;
    private String level;
    private int salary;

    public WorkerInsertModel(int id, String name, Date birthday, String level, int salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getLevel() {
        return level;
    }

    public int getSalary() {
        return salary;
    }
}
