package com.company.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongnghiem on 20/10/2021
 **/

public class ExamGenerator {
    private Long beginExamId;
    private final List<String> examType = new ArrayList<>();
    private int beginSchoolYearId;
    private int lastSchoolYearId;
    private int beginSubjectId;
    private int lastSubjectId;

    public ExamGenerator() {
        examType.addAll(List.of("KTM1_HK1", "KTM2_HK1", "KT15P1_HK1", "KT15P2_HK1", "KT1T1_HK1",
                "KT1T2_HK1", "KTCK_HK1", "KTM1_HK2", "KTM2_HK2", "KT15P1_HK2", "KT15P2_HK2", "KT1T1_HK2",
                "KT1T2_HK2", "KTCK_HK2"));
    }

    public ExamGenerator(Long beginExamId, int beginSchoolYearId, int lastSchoolYearId, int beginSubjectId, int lastSubjectId) {
        this.beginExamId = beginExamId;
        this.beginSchoolYearId = beginSchoolYearId;
        this.lastSchoolYearId = lastSchoolYearId;
        this.beginSubjectId = beginSubjectId;
        this.lastSubjectId = lastSubjectId;
        examType.addAll(List.of("KTM1_HK1", "KTM2_HK1", "KT15P1_HK1", "KT15P2_HK1", "KT1T1_HK1",
                "KT1T2_HK1", "KTCK_HK1", "KTM1_HK2", "KTM2_HK2", "KT15P1_HK2", "KT15P2_HK2", "KT1T1_HK2",
                "KT1T2_HK2", "KTCK_HK2"));
    }

    public String generate() {
        String result = "";
        Long count = beginExamId;

        for (int schoolYearId = beginSchoolYearId; schoolYearId <= lastSchoolYearId; schoolYearId++) {
            for (int subjectId = beginSubjectId; subjectId <= lastSubjectId; subjectId++){
                for (int examTypeIndex = 0; examTypeIndex < examType.size(); examTypeIndex++) {
                    result += "INSERT INTO exam (id, exam_type, school_year_id, subject_id) VALUES (" +
                            count++ +
                            ", '" +
                            examType.get(examTypeIndex) +
                            "', " +
                            schoolYearId +
                            ", " +
                            subjectId +
                            ");\n" ;
                }
            }
        }

        return result;
    }

    public Long getBeginExamId() {
        return beginExamId;
    }

    public void setBeginExamId(Long beginExamId) {
        this.beginExamId = beginExamId;
    }

    public List<String> getExamType() {
        return examType;
    }

    public int getBeginSchoolYearId() {
        return beginSchoolYearId;
    }

    public void setBeginSchoolYearId(int beginSchoolYearId) {
        this.beginSchoolYearId = beginSchoolYearId;
    }

    public int getLastSchoolYearId() {
        return lastSchoolYearId;
    }

    public void setLastSchoolYearId(int lastSchoolYearId) {
        this.lastSchoolYearId = lastSchoolYearId;
    }

    public int getBeginSubjectId() {
        return beginSubjectId;
    }

    public void setBeginSubjectId(int beginSubjectId) {
        this.beginSubjectId = beginSubjectId;
    }

    public int getLastSubjectId() {
        return lastSubjectId;
    }

    public void setLastSubjectId(int lastSubjectId) {
        this.lastSubjectId = lastSubjectId;
    }
}
