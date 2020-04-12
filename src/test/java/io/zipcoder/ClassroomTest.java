package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void testClassroom() {
        //Given
        Student newStudent1 = new Student("Trey", "Anastasio", null);
        Student newStudent2 = new Student("Mike", "Gordon", null);

        Student[] student = {newStudent1, newStudent2};
        Classroom newSchoolYear = new Classroom(student);

        //When
        int expected = 2;
        int actual = newSchoolYear.students.length;

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetStudents() {
        //Given
        Student newStudent1 = new Student("Trey", "Anastasio", null);
        Student newStudent2 = new Student("Mike", "Gordon", null);

        Student[] student = {newStudent1, newStudent2};
        Classroom newSchoolYear = new Classroom(student);

        //When
        Student[] expected = student;
        Student[] actual = newSchoolYear.getStudents();

        //Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddStudent() {
        //Given
        Classroom newSchoolYear = new Classroom(10);
        Student newStudent = new Student("Jon", "Fishman", null);

        //When
        newSchoolYear.addStudent(newStudent);
        Integer expected = 1;
        Integer actual = newSchoolYear.students.length;

        //Then
        Assert.assertEquals(expected, actual);
    }

}

