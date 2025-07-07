package com.mycompany.mavenproject4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import java.time.LocalDateTime;

public class VisitLog {
    public int id;
    public String studentName;
    public String studentId;
    public String studyProgram;
    public String purpose;
    public LocalDateTime visitTime;

    public VisitLog(int id, String studentName, String studentId, String studyProgram, String purpose, LocalDateTime visitTime) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studyProgram = studyProgram;
        this.purpose = purpose;
        this.visitTime = visitTime;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudyProgram() { return studyProgram; }
    public void setStudyProgram(String studyProgram) { this.studyProgram = studyProgram; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public LocalDateTime getVisitTime() { return visitTime; }
    public void setVisitTime(LocalDateTime visitTime) { this.visitTime = visitTime; }
}