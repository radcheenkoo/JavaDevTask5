package org.example.models;

public class MaxProjectCountClient {
    private String name;
    private String projectCount;

    public MaxProjectCountClient(String name, String projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public String getProjectCount() {
        return projectCount;
    }
}
