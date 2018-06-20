package com.rk.todo.service;

import java.util.List;

import com.rk.todo.dto.Student;



public interface StudentService {
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int student_id);
	Student getStudentById(int student_id);
	List<Student> getStudents();
}
