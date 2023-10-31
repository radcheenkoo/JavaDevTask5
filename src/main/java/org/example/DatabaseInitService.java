package org.example;

import org.example.sqlFileReader.ReadSqlFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseInitService {
    private static Connection connection = Database.getInstance().getConnection();
    private static Executor executeQuery;
    public static void main(String[] args) {

        executeQuery = new Executor();
        executeQuery.setConnection(connection);

        ReadSqlFile readSqlFile = new ReadSqlFile();

        List<String> commands = new ArrayList<>();
        try {
            commands = Arrays.asList(readSqlFile.readFileContent("sql/init_db.sql").toString().split(";"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        commands.forEach(command ->{
           executeQuery.executeCreate(command);
        });



        executeQuery.closeConnection();
    }
}
