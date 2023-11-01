package org.example;

import org.example.modelForDatabasePopulateService.ClientInsertModel;
import org.example.modelForDatabasePopulateService.ProjectInsertModel;
import org.example.modelForDatabasePopulateService.ProjectWorkerInsertModel;
import org.example.modelForDatabasePopulateService.WorkerInsertModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DatabasePopulateService {
    private static Connection connection = Database.getInstance().getConnection();
    private static String insertIntoWorker = "INSERT INTO worker(id,name,birthday,level,salary) VALUES(?, ?, ?, ?, ?);";
    private static String insertIntoClient = "INSERT INTO client (id,name) VALUES(?,?);";
    private static String insertIntoProject = "INSERT INTO project(id,client_id, start_date, finish_date) VALUES(?, ?, ?, ?)";
    private static String insertIntoProjectWorker = "INSERT INTO project_worker(project_id, worker_id) VALUES(?, ?);";


    private static List<WorkerInsertModel> workerInsertModelList = new ArrayList<>();
    private static List<ClientInsertModel> clientInsertModelList = new ArrayList<>();
    private static List<ProjectInsertModel> projectInsertModelList = new ArrayList<>();
    private static List<ProjectWorkerInsertModel> projectWorkerInsertModelList = new ArrayList<>();

    static {
        workerInsertModelList.add(new WorkerInsertModel(1, "John Doe", Date.valueOf("1990-05-15"), "Trainee", 800));
        workerInsertModelList.add(new WorkerInsertModel(2, "Jane Smith", Date.valueOf("1985-03-20"), "Junior", 1200));
        workerInsertModelList.add(new WorkerInsertModel(3, "Robert Johnson", Date.valueOf("1992-08-10"), "Middle", 2500));
        workerInsertModelList.add(new WorkerInsertModel(4, "Emily Davis", Date.valueOf("1988-02-28"), "Middle", 2800));
        workerInsertModelList.add(new WorkerInsertModel(5, "Michael Wilson", Date.valueOf("1983-11-15"), "Senior", 6000));
        workerInsertModelList.add(new WorkerInsertModel(6, "Sarah Brown", Date.valueOf("1995-07-03"), "Trainee", 900));
        workerInsertModelList.add(new WorkerInsertModel(7, "David Lee", Date.valueOf("1991-09-25"), "Junior", 1300));
        workerInsertModelList.add(new WorkerInsertModel(8, "Lisa Anderson", Date.valueOf("1987-04-12"), "Middle", 2700));
        workerInsertModelList.add(new WorkerInsertModel(9, "William Clark", Date.valueOf("1984-06-19"), "Senior", 6200));
        workerInsertModelList.add(new WorkerInsertModel(10, "Olivia Hall", Date.valueOf("1994-12-05"), "Middle", 2600));


        clientInsertModelList.add(new ClientInsertModel(1,"Alice"));
        clientInsertModelList.add(new ClientInsertModel(2,"Bob"));
        clientInsertModelList.add(new ClientInsertModel(3,"Eve"));
        clientInsertModelList.add(new ClientInsertModel(4,"Charlie"));
        clientInsertModelList.add(new ClientInsertModel(5,"Daniel"));


        projectInsertModelList.add(new ProjectInsertModel(1, 1, Date.valueOf("2023-01-15"), Date.valueOf("2024-03-20")));
        projectInsertModelList.add(new ProjectInsertModel(2,1, Date.valueOf("2023-05-10"), Date.valueOf("2024-02-28")));
        projectInsertModelList.add(new ProjectInsertModel(3, 2, Date.valueOf("2023-07-20"), Date.valueOf("2024-01-10")));
        projectInsertModelList.add(new ProjectInsertModel(4, 2, Date.valueOf("2023-03-01"), Date.valueOf("2023-08-15")));
        projectInsertModelList.add(new ProjectInsertModel(5, 3, Date.valueOf("2023-06-05"), Date.valueOf("2024-06-04")));
        projectInsertModelList.add(new ProjectInsertModel(6, 3, Date.valueOf("2023-02-10"), Date.valueOf("2023-12-31")));
        projectInsertModelList.add(new ProjectInsertModel(7, 4, Date.valueOf("2023-09-01"), Date.valueOf("2024-09-30")));
        projectInsertModelList.add(new ProjectInsertModel(8, 4, Date.valueOf("2023-04-15"), Date.valueOf("2023-11-30")));
        projectInsertModelList.add(new ProjectInsertModel(9, 5, Date.valueOf("2023-08-20"), Date.valueOf("2024-07-15")));
        projectInsertModelList.add(new ProjectInsertModel(10, 5, Date.valueOf("2023-11-01"), Date.valueOf("2024-03-31")));


        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(1, 1));
        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(1, 2));
        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(1, 3));
        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(2, 4));
        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(2, 5));
        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(3, 6));
        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(3, 7));
        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(4, 8));
        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(4, 9));
        projectWorkerInsertModelList.add(new ProjectWorkerInsertModel(5, 10));
    }



    public static void main(String[] args) {

        for (WorkerInsertModel worker: workerInsertModelList) {
            executeInsertIntoWorker(worker.getId(),worker.getName(),worker.getBirthday(),worker.getLevel(),worker.getSalary());
        }

        for (ClientInsertModel client: clientInsertModelList) {
            executeInsertIntoClient(client.getId(),client.getName());
        }

        for (ProjectInsertModel project: projectInsertModelList) {
            executeInsertIntoProject(project.getId(),project.getClientId(),project.getStartDate(),project.getFinishDate());
        }

        for (ProjectWorkerInsertModel projectWorker: projectWorkerInsertModelList) {
            executeInsertIntoProjectWorker(projectWorker.getProjectId(),projectWorker.getWorkerId());
        }
    }
    private static void executeInsertIntoWorker(int id, String name, Date birthday, String level, int salary){

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(insertIntoWorker);


            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setDate(3,birthday);
            preparedStatement.setString(4,level);
            preparedStatement.setInt(5,salary);

            preparedStatement.execute();


            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeInsertIntoClient(int id, String name){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertIntoClient);

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, name);

            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeInsertIntoProject(int id, int clientId, Date startDate, Date finishDate){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertIntoProject);

            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,clientId);
            preparedStatement.setDate(3,startDate);
            preparedStatement.setDate(4,finishDate);

            preparedStatement.execute();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void executeInsertIntoProjectWorker(int projectId,int workerId){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertIntoProjectWorker);

            preparedStatement.setInt(1,projectId);
            preparedStatement.setInt(2,workerId);

            preparedStatement.execute();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
