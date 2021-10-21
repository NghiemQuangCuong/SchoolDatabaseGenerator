package com.company;

import com.company.classes.ExamGenerator;
import com.company.classes.MarkGenerator;
import com.company.classes.StudentGenerator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;

public class Main {

    private static final int maxClassRoom = 7;
    private static final int studentPerClassRoom = 5;

    public static void main(String[] args) throws Exception {
        String absolutePath = FileSystems.getDefault().getPath("")
                .normalize().toAbsolutePath().toString();
        FileOutputStream fos = new FileOutputStream(absolutePath + "/src/resources/exam.sql");
        DataOutputStream dos = new DataOutputStream(fos);

//        ExamGenerator generator =
//                new ExamGenerator(1L, 1, 1, 1, 7);

//
        fos.write(new String("/* Insert student */\n").getBytes(StandardCharsets.UTF_8));
        writeStudent(fos);
        fos.write(new String("/* Insert Mark */\n").getBytes(StandardCharsets.UTF_8));
        writeMark(fos);
        fos.close();
        dos.close();
    }
    private static void writeStudent(FileOutputStream fos) {
        StudentGenerator generator
                = new StudentGenerator(1L, 1, maxClassRoom, studentPerClassRoom);

        try {
            fos.write(generator.generate().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeMark(FileOutputStream fos) {
        MarkGenerator generator
                = new MarkGenerator(1L, 1, 98, 1, maxClassRoom * studentPerClassRoom);
        generator.generate().forEach(statement -> {
            try {
                fos.write(statement.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
