package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>();
        examScores.addAll(Arrays.asList(testScores));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public void addExamScore(Double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, Double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public Double[] getExamScoresArray() {
        Double[] scoresArray = new Double[this.examScores.size()];
        int index = 0;
        for(Double d: this.examScores) {
            scoresArray[index] = d;
            index++;
        }
        return scoresArray;
    }

    public String getExamScores() {
        String scores = "Exam Scores: \n";
        int count = 1;

        for (Double d : examScores) {
            String examScore = String.format("%1.0f", d);
            scores += "  Exam  " + count + " -> " + examScore + "\n";
            count++;
        }
        return scores;
    }


}
