package com.amoney.studentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.amoney.studentManagementSystem.entity.student;
import com.amoney.studentManagementSystem.service.studentService;

@Controller
public class studentController {
    
    @Autowired
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

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        student Student = new student();
        model.addAttribute("student", Student);
        return "create_student";
    }

    //form handler method to handle save student request
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") student Student) {
        StudentService.saveStudent(Student);
        return "redirect:/students";
    }
}