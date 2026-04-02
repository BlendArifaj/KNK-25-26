package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static Student getFromResultSet(ResultSet res) throws SQLException {
        int id = res.getInt("id");
        String name = res.getString("name");
        int age = res.getInt("age");

        return new Student(id, name, age);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
