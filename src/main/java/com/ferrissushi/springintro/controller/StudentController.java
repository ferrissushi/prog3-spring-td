package com.ferrissushi.springintro.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ferrissushi.springintro.entity.Student;
import com.ferrissushi.springintro.service.StudentService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {
        return "Welcome " + name;
    }

    @PostMapping("/students")
    public String createStudent(@RequestBody List<Student> studentsToCreate) {
        List<Student> students = studentService.postStudent(studentsToCreate);
        return students.toString();
    }
}
