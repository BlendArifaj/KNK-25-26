package models.dto;

import models.Student;

import java.util.ArrayList;

public class StudentResponseDto {
    private int id;
    private String name;
    private int age;
    private ArrayList<Integer> grades;

    public StudentResponseDto(int id, int age, String name, ArrayList<Integer> grades) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grades = grades;
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

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }
}
