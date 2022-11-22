package com.emc.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.emc.demo.model.Student;

/*
 * Amb AutoConfigure hauriem de posar un properties al Test i variables d'entorn al runner del Test
 * Amb això no agafaria l'H2, sinó la BD que tenim configurada
 * Això es fa per fer els test d'integració
 * Els test unitaris s'han de fer 
 */
@DataJpaTest
//AutoConfigureTestDatabase(replace = Replace.NONE)
class StudentRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	StudentRepository repository;
	
	@Test
	void testFindByName() {
		Student student = new Student();
		
		student.setName("Jordi");
		student.setSurname("Ros");
		student.setAge(25);
		
		entityManager.persist(student);
		entityManager.flush();
		
		List<Student> studentList = repository.findByName("Jordi");
		assertTrue(studentList.size()>0);
	}

	@Test
	void testFindByNameAndSurname() {
		Student student = new Student();

		student.setName("Jordi");
		student.setSurname("Ros");
		student.setAge(25);

		entityManager.persist(student);
		entityManager.flush();

		List<Student> studentList = repository.findByNameAndSurname("Jordi","Ros");
		assertTrue(studentList.size()>0);
	}

	@Test
	void testFindByAge() {
		Student student = new Student();
		
		student.setName("Jordi");
		student.setSurname("Ros");
		student.setAge(25);
		
		entityManager.persist(student);
		entityManager.flush();
		
		List<Student> studentList = repository.findByAge(25);
		assertTrue(studentList.size()>0);
	}

}
