package group_01.java_04;

import services.DatabaseService;

import java.sql.*;

public class Detyra01 {
    public static void main(String[] args){
        // url, user, password -> table
//        String url = "jdbc:mysql://localhost:3306/knk_2026";

        try{
            Connection conn = DatabaseService.getConnection();
            if(conn == null){
                System.out.println("Connection is not valid!");
                return;
            }
//            Statement dhe PreparedStatement
            Statement stm = conn.createStatement();
//            stm.executeQuery(""); // Perdoret kur kemi lexim
//            stm.execute(""); //
            String sql = "INSERT INTO students (name, age) VALUES ('Filan Fisteku', 20)";
            stm.execute(sql);

            String updateSql = "UPDATE students SET age = 22 WHERE ID > 4";
            stm.execute(updateSql);

            String deleteSql = "DELETE from students where id < 4";
            stm.execute(deleteSql);

            String readStudentsSql = "SELECT * FROM students";
            ResultSet results = stm.executeQuery(readStudentsSql);

            while(results.next()){
                int id = results.getInt("id");
                String name = results.getString("name");
                int age = results.getInt("age");

                System.out.println("Id: " + id+", Name: " + name +", Age:" + age);
            }

            conn.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
