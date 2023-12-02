package com.example.trabalho.service;

import com.example.trabalho.model.Subject;
import com.example.trabalho.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository repository;

    public Subject creates( Subject subject) {
        return repository.save(subject);
    }

    public List<Subject> getAll() {
        return repository.findAll();
    }

    public Optional<Subject> getOne( Integer id) {
        return repository.findById(id);
    }

    public void delete(Optional<Subject> subject) {
        repository.delete(subject.get());
    }
}
