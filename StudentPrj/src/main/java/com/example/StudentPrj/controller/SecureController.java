package com.example.StudentPrj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentPrj.entities.Student;
import com.example.StudentPrj.repository.StudentRepository;

@RestController
@RequestMapping("/user")
public class SecureController {
	
	private StudentRepository studentRepository;

	
//		@GetMapping("/index")
//		public String dashboard() {
//			
//			
//			return "normal/student_dashboard";
//		}
		
		@GetMapping("/{id}")
		public List<Student> getStudentsById(@PathVariable("id") int id){
			return studentRepository.findStudentById(id);
		}

		

}
