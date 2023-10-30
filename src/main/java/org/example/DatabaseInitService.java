package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

public class DatabaseInitService {
    private static Connection connection = Database.getInstance().getConnection();
    private static Executor executeQuery;
    public static void main(String[] args){

        executeQuery = new Executor(connection);

        try(BufferedReader reader = new BufferedReader(new FileReader("sql/init_db.sql"))) {

            StringBuffer sb = new StringBuffer();
            reader.lines().forEach(sb::append);

            List<String> commands = Arrays.asList(sb.toString().split(";"));
            commands.forEach(command ->{
                executeQuery.executeQuery(command);
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        executeQuery.closeConnection();
    }
}
