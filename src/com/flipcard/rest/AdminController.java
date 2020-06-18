package com.flipcard.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipcard.bean.*;
import com.flipcard.constants.UserConstants;
import com.flipcard.service.AdminOperations;
import com.flipcard.service.AdminOperationsImpl;

//Controller class for admin services
@Path("/admin")
public class AdminController {
	//logger object to write to console.
	private static Logger log = Logger.getLogger(AdminController.class);
	
	//GET method to send users depending on the role(Admin, Student, Professor) 
	@GET
	@Path("user/view/{role}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserDetails(@PathParam("role") String role){
		AdminOperations operations = new AdminOperationsImpl();
		log.info(role);
		return operations.viewUsers(role);
	}
	
	//GET method to view courses.
	@GET
	@Path("course/view")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCourseDetails(){
		AdminOperations operations = new AdminOperationsImpl();
		return operations.viewCourses();
	}
	
	//POST method to add professor to database.
	@POST
	@Path("/user/Professor/post")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProfessorInJSON(Professor user){
		log.info("hit post service");
		AdminOperations operations = new AdminOperationsImpl();
		
		operations.addUser(user, UserConstants.PROFESSOR);
				
		String result = "User Created Id: "+user.getEmailId();
		return Response
				.status(201)
				.entity(result)
				.build();
	}
	
	//POST method to add Student to database
	@POST
	@Path("/user/Student/post")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createStudentInJSON(Student user){
		log.info("hit post service");
		AdminOperations operations = new AdminOperationsImpl();
		operations.addUser(user, UserConstants.STUDENT);
		String result = "User Created Id: "+user.getEmailId();
		return Response
				.status(201)
				.entity(result)
				.build();
	}
	
	//POST method to add Admin to database.
	@POST
	@Path("/user/Admin/post")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAdminInJSON(Admin user){
		log.info("hit post service");
		AdminOperations operations = new AdminOperationsImpl();
		operations.addUser(user, UserConstants.ADMIN);
		String result = "User Created Id: "+user.getEmailId();
		return Response
				.status(201)
				.entity(result)
				.build();
	}
	
	//POST method to add course to database.
	@POST
	@Path("/course/post")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCourseInJSON(Course course){
		log.info("hit post service");
		AdminOperations operations = new AdminOperationsImpl();
		
		operations.addCourse(course);;
				
		String result = "Course Created Id: "+course.getId();
		return Response
				.status(201)
				.entity(result)
				.build();
	}
	
	//DELETE method to delete role depending on role and emailId
	@DELETE
	@Path("/user/delete/{role}/{Id}")
	public Response deleteAdmin(@PathParam("role") String role,@PathParam("Id") String userId){
		AdminOperations operations = new AdminOperationsImpl();
		operations.deleteUser(userId, role);
		return Response
				.status(200)
				.entity("Track id "+userId+" successfuly deleted")
				.build();
	}
	
	//DELETE method to delete course with id courseId from database. 
	@DELETE
	@Path("/course/delete/{courseId}")
	public Response deleteCourse(@PathParam("courseId") long id){
		AdminOperations operations = new AdminOperationsImpl();
		operations.deleteCourse(id);;
		return Response
				.status(200)
				.entity("Track id "+id+" successfuly deleted")
				.build();
	}
	
	//PUT method to update Professor
	@PUT
	@Path("/user/Professor/update")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProfessorInJSON(Professor user){
		log.info("hit put service");
		AdminOperations operations = new AdminOperationsImpl();
		
		operations.editUser(user.getEmailId(), user, UserConstants.PROFESSOR);
				
		String result = "User updated Id: "+user.getEmailId();
		return Response
				.status(201)
				.entity(result)
				.build();
	}
	
	//PUT method to update Student
	@PUT
	@Path("/user/Student/update")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStudentInJSON(Student user){
		log.info("hit put service");
		AdminOperations operations = new AdminOperationsImpl();
		
		operations.editUser(user.getEmailId(), user, UserConstants.STUDENT);
				
		String result = "User updated Id: "+user.getEmailId();
		return Response
				.status(201)
				.entity(result)
				.build();
	}
	
	//Update method to update Admin
	@PUT
	@Path("/user/Admin/update")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAdminInJSON(Admin user){
		log.info("hit put service");
		AdminOperations operations = new AdminOperationsImpl();
		
		operations.editUser(user.getEmailId(), user, UserConstants.ADMIN);
				
		String result = "User updated Id: "+user.getEmailId();
		return Response
				.status(201)
				.entity(result)
				.build();
	}
	
	//PUT method to update course
	@PUT
	@Path("/course/update")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCourseInJSON(Course course){
		log.info("hit put service");
		AdminOperations operations = new AdminOperationsImpl();
		
		operations.updateCourse(course.getId(),course);
				
		String result = "User updated Id: "+course.getId();
		return Response
				.status(201)
				.entity(result)
				.build();
	}
}
