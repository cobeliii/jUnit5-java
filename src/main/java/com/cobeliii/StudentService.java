package com.cobeliii;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean addStudent(Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            return false;
        }

        if (!students.contains(student)) {
            students.add(student);
            return true;
        }else{
            System.out.println("Student already exists");
        }
        return false;
    }
    public boolean updateStudent(int id, Student updatedStudent) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            return true;
        }

        return false;

    }

    public boolean deleteStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
}
