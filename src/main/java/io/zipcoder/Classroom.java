package io.zipcoder;

import java.util.*;

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

    public Student[] getStudentsByScore() {
        Comparator<Student> compareStudent = Comparator.comparing(Student::getAverageExamScore).reversed().thenComparing(Student::getLastName);
        Student[] sortedStudent = getStudents();
        Arrays.sort(sortedStudent, compareStudent);
        return sortedStudent;
    }

    public Map<Student, String> getGradeBook() {

        Map<Student, String> gradeBook = new HashMap<>();
        Student[] sortedGrades = getStudentsByScore();
        Double percentile;
        Double classSize = (double) sortedGrades.length;

        for (int i = 0; i < sortedGrades.length; i++){
            percentile = (((classSize - i) / classSize) * 100.0);
            if (percentile >= 90){
                gradeBook.put(sortedGrades[i], "A");
            }
            else if(percentile >= 71){
                gradeBook.put(sortedGrades[i], "B");
            }
            else if(percentile >= 50){
                gradeBook.put(sortedGrades[i], "C");
            }
            else if(percentile >= 11){
                gradeBook.put(sortedGrades[i], "D");
            }
            else{
                gradeBook.put(sortedGrades[i], "F");
            }
        }
        return gradeBook;
    }
}
