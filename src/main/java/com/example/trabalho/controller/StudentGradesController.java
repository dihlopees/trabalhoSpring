package com.example.trabalho.controller;

import com.example.trabalho.service.StudentGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grades")
public class StudentGradesController {

    @Autowired
    private StudentGradesService service;
}
