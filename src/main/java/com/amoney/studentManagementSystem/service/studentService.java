package com.amoney.studentManagementSystem.service;

import java.util.List;

import com.amoney.studentManagementSystem.entity.student;

public interface studentService {
    List<student> getAllstudents();

	student saveStudent(student Student);

    Student getStudentById(long id);
    
    student updateStudent (student Student);
}
