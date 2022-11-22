package com.emc.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;


import com.emc.demo.model.Student;

@Controller
public class StudentController {
	
		
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${webservice.url}")
	private String url;

	
	@GetMapping("/studentList")
	public String getStudents(Model model) {
			
		//String fooResourceUrl = "https://emc-spring-boot-cristina.herokuapp.com/student/students";
		
		//String fooResourceUrl = "http://localhost:8080/student/students";
		
		ResponseEntity<Student[]> response = restTemplate
				.getForEntity(url, Student[].class);
		Student[] studentsArray = response.getBody();

		List<Student> studentList2 = Arrays.asList(studentsArray);
		model.addAttribute("students", studentList2);

		return "showStudents";
	}
	
	@GetMapping("/addStudentForm")
	public String addStudentForm(Model model) {

		Student student = new Student();	
		model.addAttribute("student", student);
		return "addStudent";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute Student student) {
		restTemplate.postForEntity(url, student, String.class);
		return "redirect:/studentList";
	}

}
