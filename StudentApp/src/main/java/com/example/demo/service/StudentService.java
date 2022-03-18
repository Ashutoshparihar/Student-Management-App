package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;
	public void addStudent(Student e) {
		repo.save(e);
		
	}
	
	public List<Student> getAllStudent(){
		return repo.findAll();
		
	}
	
	public Student getStudentById(int ID) {
		Optional<Student> e=repo.findById(ID);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
}
