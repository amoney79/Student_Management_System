package com.amoney.studentManagementSystem.service;

import java.util.List;

import com.amoney.studentManagementSystem.entity.student;

public interface studentService {
    List<student> getAllstudents();

	student saveStudent(student Student);

    student getStudentById(Long id);
    
    student updateStudent (student Student);

    void deleteStudentById(Long id);
}
