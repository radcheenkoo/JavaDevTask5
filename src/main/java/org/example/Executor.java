package org.example;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public void closeConnection(){
        try{
            this.connection.close();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }
}
