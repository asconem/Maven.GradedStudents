package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students){
        this.students = students;

        /*students = new Student[kids.length];
        for (int i = 0; i < students.length; i++) {
            students[i] = kids[i];
        }*/
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        Double sumAll = 0.0;

        for(Student s: students) {
            sumAll += s.getAverageExamScore();
        }

        return sumAll / students.length;
    }

    public void addStudent(Student student) {
        Student[] newStudents = new Student[students.length+1];
        int index = 0;

        for (Student s : students) {
            newStudents[index] = s;
            index++;
        }

        newStudents[index] = student;
        this.students = newStudents;
    }

    public void removeStudent(String firstName, String lastName) {
        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        Student studentToRemove = null;

        for (Student s : studentList) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                studentToRemove = s;
            }
        }

        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            studentList.add(null);
        }

        students = studentList.toArray(students);
    }

    public Student[] getStudentByScore() {
        Arrays.sort(students);
        return students;
    }

    public Map<Student, String> getGradeBook() {
        return null;
    }
}
