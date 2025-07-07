package com.mycompany.mavenproject4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VisitLogRepo {
    private static List<VisitLog> visitList = new ArrayList<>();
    private static int idCounter = 1;

    public static VisitLog add(String studentId, String studentName, String studentProgram, String purpose, LocalDateTime visitTime) {
        VisitLog visit = new VisitLog(idCounter, studentName, studentId, studentProgram, purpose, visitTime);
        visitList.add(visit);
        return visit;
    }

    public static List<VisitLog> findAll() {
        return visitList;
    }

    public static VisitLog findById(int id) {
        return visitList.stream().filter(p -> p.id == id).findFirst().orElse(null);
    }

    public static boolean delete(int id) {
        return visitList.removeIf(p -> p.id == id);
    }

    public static VisitLog update(int id, String studentId, String studentName, String studentProgram, String purpose, LocalDateTime visitTime) {
        VisitLog visit = findById(id);
        if (visit != null) {
            visit.setStudentId(studentId);
            visit.setStudentName(studentName);
            visit.setStudyProgram(studentProgram);
            visit.setPurpose(purpose);
            visit.setVisitTime(visitTime);
        }
        return visit;
    }
}
