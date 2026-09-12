package com.amoney.studentManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoney.studentManagementSystem.entity.student;
import com.amoney.studentManagementSystem.repository.studentRepository;
import com.amoney.studentManagementSystem.service.studentService;

@Service
public class studentServiceImpl implements studentService {


	@Autowired
    private studentRepository StudentRepository;

    public studentServiceImpl(studentRepository StudentRepository) {
        super();
        this.StudentRepository = StudentRepository;
    }

	@Override
	public List<student> getAllstudents() {
		return StudentRepository.findAll();
	}

	@Override
	public student saveStudent(student Student) {
		return StudentRepository.save(Student);
	}

	@Override
	public student getStudentById(long id){
		return StudentRepository.findById(id).get();
	}

	@Override
	public student updateStudent(student Student){
		return StudentRepository.save(Student);
	}
    
}