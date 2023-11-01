package org.example.modelForDatabasePopulateService;

import java.sql.Date;

public class ProjectInsertModel {
    private int id;
    private int clientId;
    private Date startDate;
    private  Date finishDate;

    public ProjectInsertModel(int id, int clientId, Date startDate, Date finishDate) {
        this.id = id;
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }
}
