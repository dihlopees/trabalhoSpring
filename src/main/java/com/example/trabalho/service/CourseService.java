package com.example.trabalho.service;

import com.example.trabalho.model.Course;
import com.example.trabalho.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course creates(Course course) {
        return repository.save(course);
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public Optional<Course> getOne( Integer id) {
        return repository.findById(id);
    }

    public void delete(Optional<Course> course) {
        repository.delete(course.get());
    }
}
