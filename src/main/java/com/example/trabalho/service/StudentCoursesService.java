package com.example.trabalho.service;

import com.example.trabalho.model.StudentCourses;
import com.example.trabalho.model.StudentGrades;
import com.example.trabalho.repository.StudentCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCoursesService {

    @Autowired
    private StudentCoursesRepository repository;

    public StudentCourses creates( StudentCourses studentCourses) {
        return repository.save(studentCourses);
    }

    public List<StudentCourses> getAll() {
        return repository.findAll();
    }

    public Optional<StudentCourses> getOne( Integer id) {
        return repository.findById(id);
    }

    public void delete(Optional<StudentCourses> studentCourses) {
        repository.delete(studentCourses.get());
    }
}
