package com.ferrissushi.springintro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ferrissushi.springintro.entity.Student;
import com.ferrissushi.springintro.exception.BadRequestException;
import com.ferrissushi.springintro.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name should not be empty");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Welcome " + name);
    }

    @PostMapping("/students")
    public ResponseEntity<String> save(@RequestBody List<Student> studentsToCreate) {
        try {
            List<Student> students = studentService.save(studentsToCreate);
            return ResponseEntity.status(HttpStatus.CREATED).body(students.toString());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

    @GetMapping("/students")
    public ResponseEntity<String> findAll(@RequestHeader(value = "Accept", required = false) String acceptHeader) {
        try {
            if (acceptHeader == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Accept header is required");
            }
            if (!"text/plain".equals(acceptHeader) && !"application/json".equals(acceptHeader)) {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Format non supporté");
            }
            List<Student> students = studentService.findAllStudents();
            return ResponseEntity.status(HttpStatus.OK).body(students.toString());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }
}
