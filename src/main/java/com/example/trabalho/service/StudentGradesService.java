package com.example.trabalho.service;

import com.example.trabalho.model.StudentGrades;
import com.example.trabalho.repository.StudentGradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentGradesService {
    @Autowired
    private StudentGradesRepository repository;

    public StudentGrades creates( StudentGrades studentGrades) {
        return repository.save(studentGrades);
    }

    public List<StudentGrades> getAll() {
        return repository.findAll();
    }

    public List<StudentGrades> getOneStudentGrade( Integer id) {
        return repository.findByIdAluno(id);
    }

    public Optional<StudentGrades> getOne(Integer id) {
        return repository.findById(id);
    }

    public void delete(Optional<StudentGrades> studentGradesRepository) {
        repository.delete(studentGradesRepository.get());
    }
}
