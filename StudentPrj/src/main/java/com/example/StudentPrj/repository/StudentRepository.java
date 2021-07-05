package com.example.StudentPrj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.StudentPrj.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("select s from Student s where s.email = :email")
	public Student getStudentByStudentName(@Param("email") String email);
	
	@Query("select s,p from Student s,Project p on s.id=p.id where s.id =?1")
	public List<Student> findStudentById(int id);
}
