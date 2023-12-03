package com.example.trabalho.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubject;

    @Column(name = "Name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    @Cascade(CascadeType.ALL)
    private List<StudentGrades> studentGrades;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;

    public Subject () {
    }

    public Course getCourse () {
        return course;
    }

    public void setCourse ( Course course ) {
        this.course = course;
    }

    public Integer getIdSubject () {
        return idSubject;
    }

    public void setIdSubject ( Integer idSubject ) {
        this.idSubject = idSubject;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public List<StudentGrades> getStudentGrades () {
        return studentGrades;
    }

    public void setStudentGrades ( List<StudentGrades> studentGrades ) {
        this.studentGrades = studentGrades;
    }
}
