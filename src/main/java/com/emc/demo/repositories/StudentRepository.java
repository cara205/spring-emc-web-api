package com.emc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emc.demo.model.Student;


/**
 * @author c_ara
 * No té codi perquè al JPA ja està implementat el CRUD
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
