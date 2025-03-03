package com.cobeliii;

import java.util.Objects;

public class Student {
    private static int idInitializer = 100;
    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.id = idInitializer;
        this.name = name;
        this.age = age;
        idInitializer = idInitializer + 1;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
