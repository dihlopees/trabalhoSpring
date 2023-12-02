package com.example.trabalho.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;
import org.hibernate.annotations.CascadeType;
@Entity
@Table(name = "Student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;

    @Column(name = "Name")
    private String name;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Status")
    private String status;

    @Column(name = "CPF")
    private String cpf;


    @OneToMany(mappedBy = "pk.student")
    private List<StudentCourses> studentCourses;

    public Student () {
    }

    public Integer getIdStudent () {
        return idStudent;
    }

    public void setIdStudent ( Integer idStudent ) {
        this.idStudent = idStudent;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus ( String status ) {
        this.status = status;
    }

    public String getCpf () {
        return cpf;
    }

    public void setCpf ( String cpf ) {
        this.cpf = cpf;
    }

    public List<StudentCourses> getStudentCourses () {
        return studentCourses;
    }

    public void setStudentCourses ( List<StudentCourses> studentCourses ) {
        this.studentCourses = studentCourses;
    }
}
