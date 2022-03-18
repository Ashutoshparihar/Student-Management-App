package com.example.demo.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@Controller
public class EmpController {
	@Autowired
	private StudentService s;
	@GetMapping("/")
	public String home(Model m) {
		List<Student> stu=s.getAllStudent();
		m.addAttribute("stu",stu);
		return "index";
	}
	
	@GetMapping("/add_Emp")
	public String addStudent() {
		return "addEmp";
	}
	
	@PostMapping("/register")
	public String reg(@ModelAttribute Student e,HttpSession session) {
		
		s.addStudent(e);
		session.setAttribute("msg","Student Added Successfully..");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{ID}")
	public String edit(@PathVariable int ID,Model m) {
		 Student e=s.getStudentById(ID);
		 m.addAttribute("stu",e);
		return "edit";
	}
}
