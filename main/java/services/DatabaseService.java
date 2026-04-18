package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/knk_2026";
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/knk_2026";
    private static final String USER = "postgres";
    private static final String PASSWORD = "";

    private static Connection initConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static Connection getConnection(){
        if(connection == null){
            connection = initConnection();
        }
        return connection;
    }
}
