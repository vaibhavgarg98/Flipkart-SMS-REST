package com.flipcard.service;

import java.util.List;

import com.flipcard.bean.Course;

//This interface contains all the methods required for performing professor's task.
public interface ProfessorOperations {
	public void addCourse(String professorId, long courseId);
	public void dropCourse(String professorId, long courseId);
	List<Course> viewCoursesToTeach(String professorId);
	public void addGrades(String studentId, int courseId, String grade);
	public List<String> viewStudentsToTeach(String professorId);
}
