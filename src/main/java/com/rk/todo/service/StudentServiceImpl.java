package com.rk.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rk.todo.dto.Student;



@Service
public class StudentServiceImpl implements StudentService {

	private List<Student> students;
	public StudentServiceImpl() {
		this.students = new ArrayList<Student>();
		insertStudents();
	}
	
	/**
	 * generate the student list
	 */
	private void insertStudents() {
		students.add(new Student(1, "ram", "FY", "78"));
		students.add(new Student(2, "ravan", "FY", "99"));
		students.add(new Student(3, "shyam", "FY", "98"));
		students.add(new Student(4, "hari", "FY", "78"));
	}
	
	
	
	@Override
	public int insertStudent(Student student) {
		if(student != null) {
			students.add(student);
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int updateStudent(Student student) {
		if(student != null) {
			students.remove(getStudentById(student.getStudent_id()));
			students.add(student);
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int deleteStudent(int student_id) {
		if(student_id != 0) {
			students.remove(getStudentById(student_id));
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public Student getStudentById(int student_id) {
		for (Student student : students) {
			if(student_id == student.getStudent_id()) {
				return student;
			}
		}
		return null;
	}

	@Override
	public List<Student> getStudents() {
		return students;
	}

}
