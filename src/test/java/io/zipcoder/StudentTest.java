package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void TestGetExamScores() {
        // Given
        Double[] examScores1 = {95.0, 80.0};
        Double[] examScores2 = {};
        Student student1 = new Student("Trey", "Anastasio", examScores1);
        Student student2 = new Student("Trey", "Anastasio", examScores2);
        String expected1 = "Exam Scores: \n  Exam 1 -> 95.0\n  Exam 2 -> 80.0";
        String expected2 = "Exam Scores: \n";

        // When
        String actual1 = student1.getExamScores();
        String actual2 = student2.getExamScores();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void TestGetNumberOfExamsTaken() {
        // Given
        Double[] examScores1 = {95.0, 80.0, 75.0, 80.0};
        Double[] examScores2 = {};
        Student student1 = new Student("Trey", "Anastasio", examScores1);
        Student student2 = new Student("Trey", "Anastasio", examScores2);
        Integer expected1 = 4;
        Integer expected2 = 0;

        // When
        Integer actual1 = student1.getNumberOfExamsTaken();
        Integer actual2 = student2.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, expected2);
    }

    @Test
    public void TestAddExamScoreTest() {
        // Given
        Double[] examScores1 = {95.0, 80.0, 75.0, 80.0};
        Double[] examScores2 = {};
        Student student1 = new Student("Trey", "Anastasio", examScores1);
        Student student2 = new Student("Trey", "Anastasio", examScores2);
        Double scoreToAdd = 70.0;
        Double[] expected1 = {95.0, 80.0, 75.0, 80.0, scoreToAdd};
        Double[] expected2 = {scoreToAdd};

        // When
        student1.addExamScore(scoreToAdd);
        student2.addExamScore(scoreToAdd);

        // Then
        Assert.assertArrayEquals(expected1, student1.getExamScoresArray());
        Assert.assertArrayEquals(expected2, student2.getExamScoresArray());
    }

    @Test
    public void setExamGradeTest() {
        //Given
        Double[] examScores = {83.0, 79.0, 91.0};
        Student newStudent = new Student("Mike", "Gordon", examScores);
        int examToSet = 3;
        Double newScore = 89.0;
        Double[] expected = {83.0, 79.0, 89.0};

        //When
        newStudent.setExamScore(examToSet, newScore);
        Double[] actual = newStudent.getExamScoresArray();

        //Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoresTest() {
        //Given
        Double[] examScores = {72.0, 88.0, 98.0, 91.0};
        Double[] examScores2 = {76.0};
        Student student1 = new Student("Trey", "Anastasio", examScores);
        Student student2 = new Student("Mike", "Gordon", examScores2);
        Double expected1 = 87.25;
        Double expected2 = 76.0;

        //When
        Double actual1 = student1.getAverageExamScore();
        Double actual2 = student2.getAverageExamScore();

        //Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void toStringTest() {
        //Given
        Double[] examScores = {70.0, 80.0, 90.0};
        Student newStudent = new Student("Trey", "Anastasio", examScores);
        String expected = "Student Name: Trey Anastasio\n> Average Score: 80.0\n> Exam Scores: \n  Exam 1 -> 70.0\n  Exam 2 -> 80.0\n  Exam 3 -> 90.0";

        //When
        String actual = newStudent.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

}
