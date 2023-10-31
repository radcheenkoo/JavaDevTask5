package org.example;


import org.example.models.LongestProject;
import org.example.models.MaxProjectCountClient;
import org.example.models.MaxSalaryWorker;
import org.example.models.YoungestEldestWorkers;



import java.util.List;


public class DatabaseQueryService {

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
