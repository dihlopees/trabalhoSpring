package com.example.trabalho.repository;

import com.example.trabalho.model.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses, Integer> {
}
