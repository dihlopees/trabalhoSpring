package com.example.trabalho.controller;

import com.example.trabalho.model.Course;
import com.example.trabalho.model.Subject;
import com.example.trabalho.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @PostMapping()
    public ResponseEntity<Subject> creates( @RequestBody Subject subject ) {
        return ResponseEntity.status(HttpStatus.OK).body(service.creates(subject));
    }

    @GetMapping()
    public ResponseEntity<List<Subject>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneById(@PathVariable(value = "id") Integer id) {
        Optional<Subject> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id ) {
        Optional<Subject> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }
        service.delete(entity);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody Subject subject  ) {
        Optional<Subject> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }

        Subject entityToUpdate = entity.get();
        entityToUpdate.setName(subject.getName());
        entityToUpdate.setCourse(subject.getCourse());

        return ResponseEntity.status(HttpStatus.OK).body(service.creates(entityToUpdate));
    }
}
