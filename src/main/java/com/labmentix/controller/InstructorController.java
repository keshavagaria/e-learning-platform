package com.labmentix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
    @GetMapping("/dashboard")
    public String instructorPage() {
        return "instructor/dashboard";
    }
}
