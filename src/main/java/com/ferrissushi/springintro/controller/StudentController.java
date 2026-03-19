package com.ferrissushi.springintro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ferrissushi.springintro.entity.Student;

@Controller
public class StudentController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {
        return "Welcome " + name;
    }

    @PostMapping("/student")
    public String createStudent(@RequestBody Student studentToCreate) {
        return "";
    }
}
