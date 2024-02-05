package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Calculator implements Serializable {
    public static double getAverageGrade(Student student) {
        List<Grade> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }

        return (double) sum / grades.size();
    }

    public static double getMedianGrade(Student student) {
        List<Grade> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }

        List<Grade> sortedGrades = new ArrayList<>(grades);
        Collections.sort(sortedGrades, new Comparator<Grade>() {
            @Override
            public int compare(Grade grade1, Grade grade2) {
                return Integer.compare(grade1.getGrade(), grade2.getGrade());
            }
        });


        int size = sortedGrades.size();
        int middle = size / 2;

        if (size % 2 == 0) {
            int grade1 = sortedGrades.get(middle - 1).getGrade();
            int grade2 = sortedGrades.get(middle).getGrade();
            return (double) (grade1 + grade2) / 2;
        } else {
            return sortedGrades.get(middle).getGrade();
        }
    }
}
