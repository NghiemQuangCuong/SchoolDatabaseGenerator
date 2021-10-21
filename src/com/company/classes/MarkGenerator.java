package com.company.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cuongnghiem on 21/10/2021
 **/

public class MarkGenerator {

    private Long beginMarkId;
    private int beginExamId;
    private int lastExamId;
    private int beginStudentId;
    private int lastStudentId;

    public static final float CHANCE_BELOW_5 = 0.25f;

    public MarkGenerator() {

    }

    public MarkGenerator(Long beginMarkId, int beginExamId, int lastExamId, int beginStudentId, int lastStudentId) {
        this.beginMarkId = beginMarkId;
        this.beginExamId = beginExamId;
        this.lastExamId = lastExamId;
        this.beginStudentId = beginStudentId;
        this.lastStudentId = lastStudentId;
    }

    public List<String> generate() {
        Long count = beginMarkId;
        List<String> result = new ArrayList<>();

        for (int studentId = beginStudentId; studentId <= lastStudentId; studentId++)
            for (int examId = beginExamId; examId <= lastExamId; examId++) {
                result.add(
                        "INSERT INTO mark (id, score, exam_id, student_id) VALUES (" +
                                count++ +
                                ", " +
                                getRandomScore() +
                                ", " +
                                +examId +
                                ", " +
                                +studentId +
                                ");\n"
                );
            }

        return result;
    }

    private float getRandomScore() {
        List<Float> decimal = new ArrayList<Float>(List.of(0f, 0.3f , 0.5f, 0.8f));
        Random rd = new Random();
        Float dec = decimal.get(rd.nextInt(decimal.size()));
        if (Math.random() < CHANCE_BELOW_5) {
             float result = rd.nextInt(5);
             return result + dec;
        } else {
            float result = rd.nextInt(6) + 5;
            if (result + dec > 10f) {
                while (result + dec > 10f) {
                    result = rd.nextInt(6) + 5;
                }
            }
            return result + dec;
        }
    }

    public Long getBeginMarkId() {
        return beginMarkId;
    }

    public void setBeginMarkId(Long beginMarkId) {
        this.beginMarkId = beginMarkId;
    }

    public int getBeginExamId() {
        return beginExamId;
    }

    public void setBeginExamId(int beginExamId) {
        this.beginExamId = beginExamId;
    }

    public int getLastExamId() {
        return lastExamId;
    }

    public void setLastExamId(int lastExamId) {
        this.lastExamId = lastExamId;
    }

    public int getBeginStudentId() {
        return beginStudentId;
    }

    public void setBeginStudentId(int beginStudentId) {
        this.beginStudentId = beginStudentId;
    }

    public int getLastStudentId() {
        return lastStudentId;
    }

    public void setLastStudentId(int lastStudentId) {
        this.lastStudentId = lastStudentId;
    }
}
