package com.example.trabalho.model;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;

    @Column(name = "Name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    @Cascade( CascadeType.ALL)
    private List<Subject> subjects;

    public Course () {
    }

    public Integer getIdCourse () {
        return idCourse;
    }

    public void setIdCourse ( Integer idCourse ) {
        this.idCourse = idCourse;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public List<Subject> getSubjects () {
        return subjects;
    }

    public void setSubjects ( List<Subject> subjects ) {
        this.subjects = subjects;
    }
}
