package com.mcb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.app.model.Students;
import com.mcb.app.response.ResponseData;
import com.mcb.app.service.StudentsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("mcb/api/students")
@Slf4j
public class StudentController {

	@Autowired
	private StudentsService studentsService;

	@PostMapping("/create")
	public ResponseData createStudent(@RequestBody Students student) {
		System.out.println("student created : "+student); 
		return studentsService.createStudent(student);
	}

	@PutMapping("/update")
	public ResponseData updateStudentById(@RequestBody Students student) {
		return studentsService.updateStudentById(student);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseData deleteStudentById(@PathVariable Integer id) {
		return studentsService.deleteStudentById(id);
	}

	@GetMapping("/list")
	public List<Students> findAllStudents() {
		return studentsService.findAllStudents();
	}

	@GetMapping("/{studentId}")
	public Students findOneStudentById(@PathVariable Integer id) {
		return studentsService.findOneStudentById(id);
	}

}
