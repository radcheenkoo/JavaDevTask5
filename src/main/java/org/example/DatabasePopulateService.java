package org.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabasePopulateService {
    private static Connection connection = Database.getInstance().getConnection();
    private static String insertIntoWorker = "INSERT INTO worker(id,name,birthday,level,salary) VALUES(?, ?, ?, ?, ?);";
    private static String insertIntoClient = "INSERT INTO client (id,name) VALUES(?,?);";
    private static String insertIntoProject = "INSERT INTO project(id,client_id, start_date, finish_date) VALUES(?, ?, ?, ?)";
    private static String insertIntoProjectWorker = "INSERT INTO project_worker(project_id, worker_id) VALUES(?, ?);";
    public static void main(String[] args) {

        executeInsertIntoWorker(1, "John Doe", Date.valueOf("1990-05-15"), "Trainee", 800);
        executeInsertIntoWorker(2, "Jane Smith", Date.valueOf("1985-03-20"), "Junior", 1200);
        executeInsertIntoWorker(3, "Robert Johnson", Date.valueOf("1992-08-10"), "Middle", 2500);
        executeInsertIntoWorker(4, "Emily Davis", Date.valueOf("1988-02-28"), "Middle", 2800);
        executeInsertIntoWorker(5, "Michael Wilson", Date.valueOf("1983-11-15"), "Senior", 6000);
        executeInsertIntoWorker(6, "Sarah Brown", Date.valueOf("1995-07-03"), "Trainee", 900);
        executeInsertIntoWorker(7, "David Lee", Date.valueOf("1991-09-25"), "Junior", 1300);
        executeInsertIntoWorker(8, "Lisa Anderson", Date.valueOf("1987-04-12"), "Middle", 2700);
        executeInsertIntoWorker(9, "William Clark", Date.valueOf("1984-06-19"), "Senior", 6200);
        executeInsertIntoWorker(10, "Olivia Hall", Date.valueOf("1994-12-05"), "Middle", 2600);




        executeInsertIntoClient(1,"Alice");
        executeInsertIntoClient(2,"Bob");
        executeInsertIntoClient(3,"Eve");
        executeInsertIntoClient(4,"Charlie");
        executeInsertIntoClient(5,"Daniel");



        executeInsertIntoProject(1, 1, Date.valueOf("2023-01-15"), Date.valueOf("2024-03-20"));
        executeInsertIntoProject(2,1, Date.valueOf("2023-05-10"), Date.valueOf("2024-02-28"));
        executeInsertIntoProject(3, 2, Date.valueOf("2023-07-20"), Date.valueOf("2024-01-10"));
        executeInsertIntoProject(4, 2, Date.valueOf("2023-03-01"), Date.valueOf("2023-08-15"));
        executeInsertIntoProject(5, 3, Date.valueOf("2023-06-05"), Date.valueOf("2024-06-04"));
        executeInsertIntoProject(6, 3, Date.valueOf("2023-02-10"), Date.valueOf("2023-12-31"));
        executeInsertIntoProject(7, 4, Date.valueOf("2023-09-01"), Date.valueOf("2024-09-30"));
        executeInsertIntoProject(8, 4, Date.valueOf("2023-04-15"), Date.valueOf("2023-11-30"));
        executeInsertIntoProject(9, 5, Date.valueOf("2023-08-20"), Date.valueOf("2024-07-15"));
        executeInsertIntoProject(10, 5, Date.valueOf("2023-11-01"), Date.valueOf("2024-03-31"));



        executeInsertIntoProjectWorker(1, 1);
        executeInsertIntoProjectWorker(1, 2);
        executeInsertIntoProjectWorker(1, 3);
        executeInsertIntoProjectWorker(2, 4);
        executeInsertIntoProjectWorker(2, 5);
        executeInsertIntoProjectWorker(3, 6);
        executeInsertIntoProjectWorker(3, 7);
        executeInsertIntoProjectWorker(4, 8);
        executeInsertIntoProjectWorker(4, 9);
        executeInsertIntoProjectWorker(5, 10);
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
