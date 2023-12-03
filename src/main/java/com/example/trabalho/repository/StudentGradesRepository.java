package com.example.trabalho.repository;

import com.example.trabalho.model.StudentGrades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGradesRepository extends JpaRepository<StudentGrades, Integer> {
    List<StudentGrades> findByIdStudent( Integer idStudent);
}
