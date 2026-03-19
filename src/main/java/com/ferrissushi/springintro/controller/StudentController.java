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
import com.ferrissushi.springintro.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name should not be empty");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Welcome " + name);
    }

    @PostMapping("/students")
    public String save(@RequestBody List<Student> studentsToCreate) {
        List<Student> students = studentService.save(studentsToCreate);
        return students.toString();
    }

    @GetMapping("/students")
    public String findAll(@RequestHeader("accept") String acceptHeader) {
        return "text/plain".equals(acceptHeader) ? studentService.findAllStudents().toString() : "Format non supporte";
    }
}
