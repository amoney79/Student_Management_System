package com.amoney.studentManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.amoney.studentManagementSystem.service.studentService;

@Controller
public class studentController {
    
    private studentService StudentService;

    public studentController(studentService StudentService) {
        super();
        this.StudentService = StudentService;
    }

    //handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", StudentService.getAllstudents());
        return "students";
    }
}