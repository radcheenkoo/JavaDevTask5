package org.example;


import org.example.Interface.ResultSetMapper;
import org.example.modelsForDatabaseQueryService.LongestProject;
import org.example.modelsForDatabaseQueryService.MaxProjectCountClient;
import org.example.modelsForDatabaseQueryService.MaxSalaryWorker;
import org.example.modelsForDatabaseQueryService.YoungestEldestWorkers;
import org.example.sqlFileReader.ReadSqlFile;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
//        System.out.println();
//
//        for (MaxSalaryWorker project: databaseQueryService.findMaxSalaryWorker()) {
//            System.out.println(project.getName() + " " + project.getSalary());
//        }
//        System.out.println();
//
//        for (MaxProjectCountClient project: databaseQueryService.findMaxProject()) {
//            System.out.println(project.getName() + " " + project.getProjectCount());
//        }
//        System.out.println();
//
//        for (YoungestEldestWorkers project: databaseQueryService.findYoungestEldestWorkers()) {
//            System.out.println(project.getName() + " " + project.getDateOfEmployment());
//        }

    }
    public List<LongestProject> findLongestProject() {
        return executor.executeSelectByCheck("sql/find_longest_project.sql",
                "id", "months_difference", LongestProject::new);
    }


    public List<MaxProjectCountClient> findMaxProject() {
        return executor.executeSelectByCheck("sql/find_max_projects_client.sql",
                "client_name", "num_projects", MaxProjectCountClient::new);
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        return executor.executeSelectByCheck("sql/find_max_salary_worker.sql",
                "name", "salary", MaxSalaryWorker::new);
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        return executor.executeSelectByCheck("sql/find_youngest_eldest_workers.sql",
                "name", "birthday", YoungestEldestWorkers::new);
    }

}
