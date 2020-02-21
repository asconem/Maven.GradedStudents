package io.zipcoder;

public class Classroom {
    private Student[] students;
    private int capacity;

    public Classroom(int maxNumberOfStudents) {
        capacity = maxNumberOfStudents;
        students = new Student[capacity];
    }

    public Classroom(Student[] kids){
        students = new Student[kids.length];
        for (int i = 0; i < students.length; i++) {
            students[i] = kids[i];
        }
    }

    public Classroom() {
        students = new Student[30];
    }
}
