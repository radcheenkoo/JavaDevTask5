package org.example.modelForDatabasePopulateService;

public class ProjectWorkerInsertModel {
    private int projectId;
    private int workerId;

    public ProjectWorkerInsertModel(int projectId, int workerId) {
        this.projectId = projectId;
        this.workerId = workerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getWorkerId() {
        return workerId;
    }
}
