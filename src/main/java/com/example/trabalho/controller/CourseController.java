package com.example.trabalho.controller;

import com.example.trabalho.model.Course;
import com.example.trabalho.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping()
    public ResponseEntity<Course> createsCourse( @RequestBody Course course ) {
        return ResponseEntity.status(HttpStatus.OK).body(service.creates(course));
    }

    @GetMapping()
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneById(@PathVariable(value = "id") Integer id) {
        Optional<Course> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id ) {
        Optional<Course> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }
        service.delete(entity);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody Course course  ) {
        Optional<Course> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }

        Course entityToUpdate = entity.get();
        entityToUpdate.setName(course.getName());

        return ResponseEntity.status(HttpStatus.OK).body(service.creates(entityToUpdate));
    }
}
