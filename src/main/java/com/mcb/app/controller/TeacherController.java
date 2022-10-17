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

import com.mcb.app.model.Teacher;
import com.mcb.app.response.ResponseData;
import com.mcb.app.service.TeacherService;

@RestController
@RequestMapping("mcb/api/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@PostMapping("/create")
	public ResponseData createSubject(@RequestBody Teacher teacher) {
		return teacherService.createSubject(teacher);
	}

	@PutMapping("/update")
	public ResponseData updateSubjectById(@RequestBody Teacher teacher) {
		return teacherService.updateSubjectById(teacher);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseData deleteSubjectById(@PathVariable Integer id) {
		return teacherService.deleteSubjectById(id);
	}

	@GetMapping("/list")
	public List<Teacher> findAllSubject() {
		return teacherService.findAllSubject();
	}

	@GetMapping("/{id}")
	public Teacher findOneSubjectById(@PathVariable Integer id) {
		return teacherService.findOneSubjectById(id);
	}

}
