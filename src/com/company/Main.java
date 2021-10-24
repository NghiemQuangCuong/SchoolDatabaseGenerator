package com.company;

import com.company.classes.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;

public class Main {

    private static final int STUDENT_PER_CLASS_ROOM = 100;
    private static final int NUMBER_OF_CLASSROOM = 30;
    private static final int TOTAL_EXAM_GENERATE_HAS_MARK = 5; // Max is 98.
    private static final int TOTAL_STUDENT_HAVE_MARK = 20; // Max is TOTAL_EXAM_GENERATE * STUDENT_PER_CLASS_ROOM * NUMBER_OF_CLASSROOM
    private static final Long TOTAL_TEACHER = 60L;

    public static void main(String[] args) throws Exception {
        String absolutePath = FileSystems.getDefault().getPath("")
                .normalize().toAbsolutePath().toString();
        FileOutputStream fos = new FileOutputStream(absolutePath + "/src/resources/exam.sql");
        DataOutputStream dos = new DataOutputStream(fos);

        writeSchoolYear(fos);
        writeClassType(fos);
        writeSubject(fos);
        writeClassRoom(fos);
        writeTeacher(fos);
        writeTeacherClassRoom(fos);
        writeExam(fos);
        writeStudent(fos);
        writeMark(fos);

        fos.close();
        dos.close();

    }
    private static void writeStudent(FileOutputStream fos) throws IOException {
        StudentGenerator generator
                = new StudentGenerator(1L, 1, NUMBER_OF_CLASSROOM, STUDENT_PER_CLASS_ROOM);
        fos.write(new String("/* Insert student */\n").getBytes(StandardCharsets.UTF_8));
        fos.write(generator.generate().getBytes(StandardCharsets.UTF_8));
    }

    private static void writeMark(FileOutputStream fos) throws IOException {
        MarkGenerator generator
                = new MarkGenerator(1L, 1, TOTAL_EXAM_GENERATE_HAS_MARK, 1, TOTAL_STUDENT_HAVE_MARK);
        fos.write(new String("/* Insert Mark */\n").getBytes(StandardCharsets.UTF_8));
        generator.generate().forEach(statement -> {
            try {
                fos.write(statement.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void writeClassType(FileOutputStream fos) throws IOException {
        String content = "/* Insert class type */\n" +
                "INSERT INTO class_type (id, name) VALUES (1, 'Maths');\n" +
                "INSERT INTO class_type (id, name) VALUES (2, 'Physics');\n" +
                "INSERT INTO class_type (id, name) VALUES (3, 'Chemistry');\n" +
                "INSERT INTO class_type (id, name) VALUES (4, 'Biology');\n" +
                "INSERT INTO class_type (id, name) VALUES (5, 'Geography');\n" +
                "INSERT INTO class_type (id, name) VALUES (6, 'Literature');\n" +
                "INSERT INTO class_type (id, name) VALUES (7, 'IT');\n";
        fos.write(content.getBytes(StandardCharsets.UTF_8));
    }

    private static void writeSchoolYear(FileOutputStream fos) throws IOException {
        String content = "/* Insert school year */\n" +
                "INSERT INTO school_year (id, first_year, second_year) VALUES (1, 2020, 2021);\n";
        fos.write(content.getBytes(StandardCharsets.UTF_8));
    }

    private static void writeSubject(FileOutputStream fos) throws IOException {
        String content = "/* Insert subject */\n" +
                "INSERT INTO subject (id, name) VALUES (1, 'Maths');\n" +
                "INSERT INTO subject (id, name) VALUES (2, 'Physics');\n" +
                "INSERT INTO subject (id, name) VALUES (3, 'Chemistry');\n" +
                "INSERT INTO subject (id, name) VALUES (4, 'Biology');\n" +
                "INSERT INTO subject (id, name) VALUES (5, 'Geography');\n" +
                "INSERT INTO subject (id, name) VALUES (6, 'Literature');\n" +
                "INSERT INTO subject (id, name) VALUES (7, 'IT');\n";
        fos.write(content.getBytes(StandardCharsets.UTF_8));
    }

    private static void writeClassRoom(FileOutputStream fos) throws IOException {
        fos.write("/* Insert Class Room */\n".getBytes(StandardCharsets.UTF_8));
        ClassRoomGenerator generator = new ClassRoomGenerator(1L, NUMBER_OF_CLASSROOM);
        generator.generate().forEach(statement -> {
            try {
                fos.write(statement.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void writeTeacher(FileOutputStream fos) throws IOException {
        fos.write("/* Insert Teacher */\n".getBytes(StandardCharsets.UTF_8));
        TeacherGenerator generator = new TeacherGenerator(1L, TOTAL_TEACHER);
        generator.generate().forEach(statement -> {
            try {
                fos.write(statement.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void writeTeacherClassRoom(FileOutputStream fos) throws IOException {
        fos.write("/* Insert into teacher _ class relationship */\n".getBytes(StandardCharsets.UTF_8));
        TeacherAndClassRelationGenerator generator =
                new TeacherAndClassRelationGenerator(NUMBER_OF_CLASSROOM, Math.toIntExact(TOTAL_TEACHER));
        generator.generate().forEach(statement -> {
            try {
                fos.write(statement.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void writeExam(FileOutputStream fos) throws IOException {
        fos.write("/* Write Exam */\n".getBytes(StandardCharsets.UTF_8));
        ExamGenerator generator = new ExamGenerator(1L, 1, 1, 1, 7);
        fos.write(generator.generate().getBytes(StandardCharsets.UTF_8));
    }
}
