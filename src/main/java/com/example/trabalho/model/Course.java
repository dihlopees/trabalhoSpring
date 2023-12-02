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

}
