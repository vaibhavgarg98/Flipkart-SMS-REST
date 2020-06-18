package com.flipcard.service;

import java.util.List;

import com.flipcard.bean.Course;
import com.flipcard.bean.User;
//This interface contain methods that are required for performing add operations
//AdminClient class will call this methods depending on the task need to be done.
public interface AdminOperations {
	void addCourse(Course course);
	void updateCourse(long oldId, Course course);
	void deleteCourse(long id);
	List<Course> viewCourses();
	void addUser(User user,String role);
	void editUser(String oldId,User user, String role);
	void deleteUser(String userId, String role);
	List<User> viewUsers(String role);
}
