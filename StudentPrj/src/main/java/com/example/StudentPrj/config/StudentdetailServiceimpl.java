package com.example.StudentPrj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.StudentPrj.entities.Student;
import com.example.StudentPrj.repository.StudentRepository;

public class StudentdetailServiceimpl implements UserDetailsService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Student student = studentRepository.getStudentByStudentName(username);
		
		if (student==null) {
			throw new UsernameNotFoundException("could not found student");
		}
		
		CustomStudentDestails customStudentDestails = new CustomStudentDestails(student);
		return customStudentDestails;
	}

}
