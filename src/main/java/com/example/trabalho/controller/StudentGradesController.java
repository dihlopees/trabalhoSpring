package com.example.trabalho.controller;

import com.example.trabalho.model.Student;
import com.example.trabalho.model.StudentGrades;
import com.example.trabalho.service.StudentGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grades")
public class StudentGradesController {

    @Autowired
    private StudentGradesService service;

    @PostMapping()
    public ResponseEntity<Object> creates( @RequestBody StudentGrades studentGrades ) {
        if (studentGrades.getGrade() < 0  || studentGrades.getGrade() > 10) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nota não pode ser menor que 0 ou maior que 10.");
        return ResponseEntity.status(HttpStatus.OK).body(service.creates(studentGrades));
    }

    @GetMapping()
    public ResponseEntity<List<StudentGrades>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneById(@PathVariable(value = "id") Integer id) {
        Optional<StudentGrades> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id ) {
        Optional<StudentGrades> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }
        service.delete(entity);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody StudentGrades studentGrades  ) {
        Optional<StudentGrades> entity = service.getOne(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não cadastrado, tente novamente!");
        }
        if (studentGrades.getGrade() < 0  || studentGrades.getGrade() > 10) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nota não pode ser menor que 0 ou maior que 10.");


        StudentGrades entityToUpdate = entity.get();
        entityToUpdate.setGrade(studentGrades.getGrade());
        entityToUpdate.setSubject(studentGrades.getSubject());
        entityToUpdate.setIdStudent(studentGrades.getIdStudent());

        return ResponseEntity.status(HttpStatus.OK).body(service.creates(entityToUpdate));
    }
}
