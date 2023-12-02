package com.example.trabalho.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class StudentCoursePK implements Serializable {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;

    public StudentCoursePK ( Student student, Course course ) {
        this.student = student;
        this.course = course;
    }

    public StudentCoursePK () {
    }

    public Student getStudent () {
        return student;
    }

    public void setStudent ( Student student ) {
        this.student = student;
    }

    public Course getCourse () {
        return course;
    }

    public void setCourse ( Course course ) {
        this.course = course;
    }
}
