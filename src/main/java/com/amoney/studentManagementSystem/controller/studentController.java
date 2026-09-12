package com.amoney.studentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    //handler method to handle edit student request
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", StudentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    //handler method to handle update request
    public String updateStudent(@PathVariable Long id,
        @ModelAttribute("student") student Student,
        Model model ) {

            //getStudent from database by id
            student existingStudent = StudentService.getStudentById(id);
            existingStudent.setId(id);
            existingStudent.setFirstName(Student.getFirstName());
            existingStudent.setLastName(Student.getLastName());
            existingStudent.setEmail(Student.getEmail());

            //save updated student object
            StudentService.updateStudent(existingStudent);
            return "redirect:/students";
    }

    //handler method to handle delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        StudentService.deleteStudentById(id);
        return "redirect:/students";
    }
}