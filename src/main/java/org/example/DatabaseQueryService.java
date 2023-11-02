package org.example;

import org.example.modelsForDatabaseQueryService.LongestProject;
import org.example.modelsForDatabaseQueryService.MaxProjectCountClient;
import org.example.modelsForDatabaseQueryService.MaxSalaryWorker;
import org.example.modelsForDatabaseQueryService.YoungestEldestWorkers;
import org.example.sqlFileReader.ReadSqlFile;



import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseQueryService {

    Connection connection = Database.getInstance().getConnection();
    private static Executor executor = new Executor();
    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        for (LongestProject project: databaseQueryService.findLongestProject()) {
            System.out.println(project.getId() + " " + project.getAmountOfMonths());
        }
        System.out.println();

        for (MaxSalaryWorker project: databaseQueryService.findMaxSalaryWorker()) {
            System.out.println(project.getName() + " " + project.getSalary());
        }
        System.out.println();

        for (MaxProjectCountClient project: databaseQueryService.findMaxProject()) {
            System.out.println(project.getName() + " " + project.getProjectCount());
        }
        System.out.println();

        for (YoungestEldestWorkers project: databaseQueryService.findYoungestEldestWorkers()) {
            System.out.println(project.getName() + " " + project.getDateOfEmployment());
        }

    }
    public List<LongestProject> findLongestProject() {
        List<LongestProject> list = new ArrayList<>();

        try {
            ReadSqlFile readSqlFile = new ReadSqlFile();
            String query = readSqlFile.readFileContent("sql/find_longest_project.sql");

            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int monthsDifference = resultSet.getInt("months_difference");
                    LongestProject longestProject = new LongestProject(id,monthsDifference);
                    list.add(longestProject);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }



    public List<MaxProjectCountClient> findMaxProject() {
        List<MaxProjectCountClient> list = new ArrayList<>();

        try {
            ReadSqlFile readSqlFile = new ReadSqlFile();
            String query = readSqlFile.readFileContent("sql/find_max_projects_client.sql");

            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String clientName = resultSet.getString("client_name");
                    int numProjects = resultSet.getInt("num_projects");
                    MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(clientName,numProjects);
                    list.add(maxProjectCountClient);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    public List<MaxSalaryWorker> findMaxSalaryWorker() {

        List<MaxSalaryWorker> list = new ArrayList<>();

        try {
            ReadSqlFile readSqlFile = new ReadSqlFile();
            String query = readSqlFile.readFileContent("sql/find_max_salary_worker.sql");

            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String workerName = resultSet.getString("name");
                    int salary = resultSet.getInt("salary");
                    MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(workerName, salary);
                    list.add(maxSalaryWorker);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> list = new ArrayList<>();

        try {
            ReadSqlFile readSqlFile = new ReadSqlFile();
            String query = readSqlFile.readFileContent("sql/find_youngest_eldest_workers.sql");

            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String workerName = resultSet.getString("name");
                    Date birthday = resultSet.getDate("birthday");
                    YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers(workerName,birthday);
                    list.add(youngestEldestWorkers);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
