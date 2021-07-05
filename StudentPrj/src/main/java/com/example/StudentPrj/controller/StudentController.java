package com.example.StudentPrj.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentPrj.entities.Student;
import com.example.StudentPrj.helper.Message;
import com.example.StudentPrj.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/home")
	public String Home(Model model) {
		model.addAttribute("title","Project");
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title","Register");
		model.addAttribute("student",new Student());
		return "signup";
		
	}
	
	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("student") Student student,BindingResult result,Model model, HttpSession session) {
		
		try {
			if (result.hasErrors()) {
				model.addAttribute("student",student);
				return "signup";
			}
			
			student.setRole("ROLE_USER");
			
			student.setPassword(passwordEncoder.encode(student.getPassword()));
			studentRepository.save(student);
			
			model.addAttribute("student",new Student());
			session.setAttribute("message", new Message("Successful!", "alert-success"));
			System.out.println(student);
			return "signup";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("student",student);
			session.setAttribute("message", new Message("Something went wrong!", "alert-danger"));
			return "signup";
		}
		
	}
	
}
