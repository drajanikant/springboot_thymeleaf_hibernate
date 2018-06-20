package com.rk.todo.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rk.todo.dto.Student;
import com.rk.todo.service.StudentServiceImpl;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private StudentServiceImpl student_service;
	
	
	
	/**
	 * @param student_service the student_service to set
	 */
	public void setStudent_service(StudentServiceImpl student_service) {
		this.student_service = student_service;
	}



	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// Get all students and set to 'students' variable
		model.addAttribute("students", student_service.getStudents());
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getStudentRegistrForm(Locale locale, Model model) {
		// Get all students and set to 'students' variable
		model.addAttribute("student", new Student());
		return "register-student";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getRegisterStudent(Locale locale, Model model, @ModelAttribute(name="student")Student student) {
		// Get all students and set to 'students' variable
		if(student_service.insertStudent(student) >= 1) {
			return "redirect:/";
		}else {
			return "redirect:register-student";
		}
	}
	
	@RequestMapping(value = "/delete/{student_id}", method = RequestMethod.GET)
	public String getDeleteStudent(Locale locale, Model model, @PathVariable(name="student_id", required = true)int student_id) {
		// Get all students and set to 'students' variable
		if(student_service.deleteStudent(student_id) >= 1) {
			return "redirect:/";
		}else {
			model.addAttribute("error", "Failed in deletion");
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value = "/update/{student_id}", method = RequestMethod.GET)
	public String getUpdateStudent(Locale locale, Model model, @PathVariable(name="student_id", required = true)int student_id) {
		// Get all students and set to 'students' variable
		Student student = student_service.getStudentById(student_id); 
		if(student !=null) {
			model.addAttribute("student", student);
			return "update-student";
		}else {
			model.addAttribute("error", "Failed in updation");
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateStudent(Locale locale, Model model, @ModelAttribute(name="student")Student student) {
		// Get all students and set to 'students' variable
		if(student_service.updateStudent(student) >= 1) {
			return "redirect:/";
		}else {
			model.addAttribute("error", "Failed in updation");
			return "redirect:/";
		}
	}
}
