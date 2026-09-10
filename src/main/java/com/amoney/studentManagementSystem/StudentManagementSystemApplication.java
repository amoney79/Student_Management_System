package com.amoney.studentManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amoney.studentManagementSystem.entity.student;
import com.amoney.studentManagementSystem.repository.studentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired 
	private studentRepository StudentRepository;

    public void run(String... args) throws Exception {

		student student1 = new student("Amoney", "Akinola", "amoney.akinola@example.com");
		StudentRepository.save(student1);

		student student2 = new student("John", "Doe", "johndoe@example.com");
		StudentRepository.save(student2);

		student student3 = new student("Jane", "Smith", "janesmith@example.com");
		StudentRepository.save(student3);

	}
}
