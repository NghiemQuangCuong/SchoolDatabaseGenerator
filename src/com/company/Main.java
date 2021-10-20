package com.company;

import com.company.classes.ExamGenerator;
import com.company.classes.StudentGenerator;

public class Main {

    public static void main(String[] args) {
//        ExamGenerator generator =
//                new ExamGenerator(1L, 1, 1, 1, 7);

        StudentGenerator generator = new StudentGenerator(1L, 1, 7, 30);
        System.out.println(generator.generate());
    }
}
