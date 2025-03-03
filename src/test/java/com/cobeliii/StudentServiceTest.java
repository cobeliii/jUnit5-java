package com.cobeliii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    private StudentService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new StudentService();
    }

    @Test
    public void itShouldAddStudent() {
        Student student = new Student("Nilson", 23);
        underTest.addStudent(student);

        assertTrue(underTest.getStudents().contains(student));
    }

    @Test
    public void itShouldNotAddStudentWhenNameIsNull() {
        Student student = new Student(null, 23);
        Assertions.assertFalse(underTest.addStudent(student));
    }

    @Test
    public void itShouldNotAddStudentWhenNameIsEmpty() {
        Student student = new Student("", 23);
        assertFalse(underTest.addStudent(student));
    }

    @Test
    public void itShouldReturnAllStudents() {
        List<Student> list = new ArrayList<>();
        Student nilson = new Student("Nilson", 23);
        Student newton = new Student("Newton", 23);
        list.add(nilson);
        list.add(newton);
        underTest.addStudent(nilson);
        underTest.addStudent(newton);
        Assertions.assertEquals(list, underTest.getStudents());
    }

    @Test
    public void itShouldReturnFalseWhenStudentAlreadyExists() {
        Student nilson = new Student("Nilson", 23);
        Student newton = nilson;
        underTest.addStudent(nilson);
        Assertions.assertFalse(underTest.addStudent(newton));
    }

   @Test
   public void itShouldGetStudentById(){
        Student nilson = new Student("Nilson", 23);
        underTest.addStudent(nilson);
        Student newton = new Student("Newton", 23);
        underTest.addStudent(newton);
        Student result = underTest.getStudentById(nilson.getId());
        Assertions.assertEquals(nilson, result);
   }

   @Test
   public void itShouldReturnStudentWhenStudentWithIdExists(){
        Student nilson = new Student("Nilson", 23);
        underTest.addStudent(nilson);

        assertEquals(nilson, underTest.getStudentById(nilson.getId()));
   }

   @Test
   public void itShouldReturnNullWhenStudentDoesNotExist() {
        Assertions.assertNull(underTest.getStudentById(3));
   }

   @Test
   public void itShouldDeleteStudent() {
        Student nilson = new Student("Nilson", 23);
        underTest.addStudent(nilson);
        assertTrue(underTest.deleteStudent(nilson.getId()));
   }

   @Test
   public void itShouldNotDeleteStudentAndReturnFalseWhenStudentDoesNotExist() {
        Assertions.assertFalse(underTest.deleteStudent(3));
   }

   @Test
   public void itShouldNotUpdateStudentWhenStudentIsNull() {
        Student nilson = new Student("Nilson", 23);
        assertFalse(underTest.updateStudent(2, nilson));
   }

    @Test
    public void itShouldUpdateStudent() {
        Student nilson = new Student("Nilson", 23);
        underTest.addStudent(nilson);
        assertTrue(underTest.updateStudent(nilson.getId(), new Student("Newton", 25)));
    }
}
