package group_04.models;

import java.sql.ResultSet;

/*
    CREATE TABLE student(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(256),
    age int
    )
 */
public class Student {
    public static final String tableName = "student";
    private Integer id;
    private String name;
    private int age;

    public Student(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
