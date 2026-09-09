package com.amoney.studentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amoney.studentManagementSystem.entity.student;


public interface studentRepository extends JpaRepository<student, Long> {
    
}
