package org.example;

import org.example.Interface.ResultSetMapper;
import org.example.sqlFileReader.ReadSqlFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Executor  {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Optional<Integer> executeCreate(String query){
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
            return Optional.of(preparedStatement.executeUpdate());
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Не можливо виконати послідовність");
        }
    }

    public <T> List<T> executeSelectByCheck(String sqlFilePath, String column1, String column2, ResultSetMapper<T> mapper) {
        List<T> result = new ArrayList<>();

        try {
            ReadSqlFile readSqlFile = new ReadSqlFile();
            String query = readSqlFile.readFileContent(sqlFilePath);

            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    T item = mapper.map(resultSet.getString(column1), resultSet.getString(column2));
                    result.add(item);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void closeConnection(){
        try{
            this.connection.close();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }
}
