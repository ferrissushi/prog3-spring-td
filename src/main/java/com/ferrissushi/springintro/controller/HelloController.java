package com.ferrissushi.springintro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

}
