package com.example.trabalho.service;

import com.example.trabalho.model.Student;
import com.example.trabalho.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student creates( Student student) {
        return repository.save(student);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Optional<Student> getOne( Integer id) {
        return repository.findById(id);
    }

    public void delete(Optional<Student> student) {
        repository.delete(student.get());
    }
}
