package com.example.trabalho.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;

@Entity
@Table(name = "Student_Grades")
public class StudentGrades implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudentGrades;

    @JoinColumn(name = "id_student")
    private Integer idStudent;
    @JoinColumn(name = "id_subject")
    private Integer idSubject;

    private Double grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade( org.hibernate.annotations.CascadeType.ALL)
    private Subject subject;


    public StudentGrades () {
    }

    public Integer getIdStudentGrades () {
        return idStudentGrades;
    }

    public void setIdStudentGrades ( Integer idStudentGrades ) {
        this.idStudentGrades = idStudentGrades;
    }

    public Integer getIdStudent () {
        return idStudent;
    }

    public void setIdStudent ( Integer idStudent ) {
        this.idStudent = idStudent;
    }

    public Integer getIdSubject () {
        return idSubject;
    }

    public void setIdSubject ( Integer idSubject ) {
        this.idSubject = idSubject;
    }

    public Double getGrade () {
        return grade;
    }

    public void setGrade ( Double grade ) {
        this.grade = grade;
    }

    public Subject getSubject () {
        return subject;
    }

    public void setSubject ( Subject subject ) {
        this.subject = subject;
    }
}
