package com.example.trabalho.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Table(name = "Student_Courses")
@Entity
public class StudentCourses implements Serializable {
    @EmbeddedId
    private StudentCoursePK pk;


    public StudentCourses ( StudentCoursePK pk ) {
        this.pk = pk;
    }

    public StudentCourses () {
    }

    public StudentCoursePK getPk () {
        return pk;
    }

    public void setPk ( StudentCoursePK pk ) {
        this.pk = pk;
    }
}
