package group_03.models;

import java.sql.ResultSet;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static Student getFromResultSet(ResultSet res){
        try{
            int id = res.getInt("id");
            String name = res.getString("name");
            int age = res.getInt("age");

            return new Student(id, name, age);
        }catch (Exception e){
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
