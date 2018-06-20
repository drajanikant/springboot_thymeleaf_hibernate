package com.rk.todo.dto;

/**
 * Title: Student DTO class
 * @author rajanikant
 * Description performing the opration of the
 */
public class Student {
	private int student_id;
	private String student_name;
	private String student_class;
	private String student_marks;
	
	/**
	 * Default constructor for the student constructor
	 */
	public Student() {
		this.student_id = 0;
		this.student_name = "";
		this.student_class = "";
		this.student_marks = "";
	}
	
	
	/**
	 * @param student_id
	 * @param student_name
	 * @param student_class
	 * @param student_marks
	 */
	public Student(int student_id, String student_name, String student_class, String student_marks) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_class = student_class;
		this.student_marks = student_marks;
	}
	/**
	 * @return the student_id
	 */
	public int getStudent_id() {
		return student_id;
	}
	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	/**
	 * @return the student_name
	 */
	public String getStudent_name() {
		return student_name;
	}
	/**
	 * @param student_name the student_name to set
	 */
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	/**
	 * @return the student_class
	 */
	public String getStudent_class() {
		return student_class;
	}
	/**
	 * @param student_class the student_class to set
	 */
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	/**
	 * @return the student_marks
	 */
	public String getStudent_marks() {
		return student_marks;
	}
	/**
	 * @param student_marks the student_marks to set
	 */
	public void setStudent_marks(String student_marks) {
		this.student_marks = student_marks;
	}
	
	
}
