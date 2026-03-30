package group_04.java_04;

import services.DatabaseService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Detyra01 {
    public static void main(String[] args){

        try{
            Connection conn = DatabaseService.getConnection();
            if(conn == null){
                System.out.println("Connection is not valid!");
                return;
            }
            // Statement | PreparedStatement
            Statement stm = conn.createStatement();
            // stm.execute() -> boolean -> update|delete|create
            // stm.executeQuery() -> ResultSet -> read
            String createSql = "INSERT INTO students (name, age) VALUES ('Filan Fisteku', 20)";
            stm.execute(createSql);

            String updateSql = "UPDATE students SET age = 22 WHERE id > 3";
            stm.execute(updateSql);

            String deleteSql = "DELETE FROM students WHERE id = 4";
            stm.execute(deleteSql);

            String readSql = "SELECT * FROM students";
            ResultSet results = stm.executeQuery(readSql);
            // results.next() -> True | False
            while(results.next()){
                int id = results.getInt("id");
                String name = results.getString("name");
                int age = results.getInt("age");

                System.out.println("Id: " + id +", Name: " + name + ", Age: " + age);
            }
            conn.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
