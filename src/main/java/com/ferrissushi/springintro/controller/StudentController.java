package com.ferrissushi.springintro.controller;

import java.util.List;

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
    public String welcome(@RequestParam String name) {
        return "Welcome " + name;
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
