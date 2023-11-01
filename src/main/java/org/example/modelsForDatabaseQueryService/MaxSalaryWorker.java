package org.example.modelsForDatabaseQueryService;

public class MaxSalaryWorker {
    private String name;
    private String salary;

    public MaxSalaryWorker(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }
}
