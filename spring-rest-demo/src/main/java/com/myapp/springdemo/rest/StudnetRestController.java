package com.myapp.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudnetRestController {

	private List<Student> theStudents;
	
	// Define @PostConstuct to load the student data only once
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Vishal", "Jagdale"));
		theStudents.add(new Student("Ram", "Hardi"));
		theStudents.add(new Student("Niti", "Gog"));
	}
	
	
	// Define endpoint for "/students" - return the list of students
	@GetMapping("/students")
	public List<Student> getStudents(){

		return theStudents;
	}
	
	// Define endpoint for "/students/{studentId}" - return student at the index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// Just index into the list ... keep it simple for now
		
		// Check the studentId against the list
		if((studentId >= theStudents.size()) || (studentId<0)) {
			throw new StudnetNotFoundException("Student not found for id: "+studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	// Add an Exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudnetNotFoundException exp){
		
		// Create a StudentErrorResonse
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exp.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponceEntity
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
}


