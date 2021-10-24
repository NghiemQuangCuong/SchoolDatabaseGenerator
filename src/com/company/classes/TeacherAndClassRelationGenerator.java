package com.company.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cuongnghiem on 24/10/2021
 **/

public class TeacherAndClassRelationGenerator {
    private int classRoomTotal;
    private int teacherTotal;

    public TeacherAndClassRelationGenerator(int classRoomTotal, int teacherTotal) {
        this.classRoomTotal = classRoomTotal;
        this.teacherTotal = teacherTotal;
    }

    public List<String> generate() {
        List<String> result = new ArrayList<>();
        Random rd = new Random();
        int curTeacherId = 1;

        for (int i = 1; i <= classRoomTotal; i++) {
            final int TEACHER_PER_CLASS = rd.nextInt(8);
            for (int teacherNum = 0; teacherNum < TEACHER_PER_CLASS; teacherNum++) {
                result.add(
                        "INSERT INTO classes_teachers (class_room_id, teacher_id) VALUES (" +
                                i +
                                ", " +
                                curTeacherId +
                                ");\n"
                );
                curTeacherId++;
                if (curTeacherId > teacherTotal)
                    curTeacherId = 1;
            }
        }

        return result;
    }
}
