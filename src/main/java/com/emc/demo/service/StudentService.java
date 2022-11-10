package com.emc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.demo.model.Student;
import com.emc.demo.repositories.StudentRepository;

/**
 * @author c_ara
 *
 */
@Service
public class StudentService {
	
	/*
	 * Amb l'autowired injectem el repository que té implementats els mètodes de jpa
	 */	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public Student saveStudent(Student student){
		return studentRepository.save(student);
	}


}
