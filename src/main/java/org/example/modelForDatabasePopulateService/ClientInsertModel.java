package org.example.modelForDatabasePopulateService;

public class ClientInsertModel {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClientInsertModel(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
