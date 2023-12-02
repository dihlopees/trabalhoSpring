package com.example.trabalho.controller;

import com.example.trabalho.model.Course;
import com.example.trabalho.model.Student;
import com.example.trabalho.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping()
    public ResponseEntity<Student> createsStudent( @RequestBody Student student ) {
        return ResponseEntity.status(HttpStatus.OK).body(service.creates(student));
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneById(@PathVariable(value = "id") Integer id) {
        Optional<Student> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id ) {
        Optional<Student> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }
        service.delete(entity);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody Student student  ) {
        Optional<Student> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }

        Student entityToUpdate = entity.get();
        entityToUpdate.setName(student.getName());
        entityToUpdate.setCpf(student.getCpf());
        entityToUpdate.setStatus(student.getStatus());
        entityToUpdate.setLastName(student.getLastName());
        entityToUpdate.setStudentCourses(student.getStudentCourses());

        return ResponseEntity.status(HttpStatus.OK).body(service.creates(entityToUpdate));
    }
}
