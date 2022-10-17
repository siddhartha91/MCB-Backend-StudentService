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

import com.mcb.app.model.Subjects;
import com.mcb.app.response.ResponseData;
import com.mcb.app.service.SubjectsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("mcb/api/subject")
@Slf4j
public class SubjectController {

	@Autowired
	private SubjectsService subjectsService;

	@PostMapping("/create")
	public ResponseData createSubject(@RequestBody Subjects subject) {
		log.info("Calling create subject in controller::");
		return subjectsService.createSubject(subject);
	}

	@PutMapping("/update")
	public ResponseData updateSubjectById(@RequestBody Subjects subject) {
		return subjectsService.updateSubjectById(subject);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseData deleteSubjectById(@PathVariable Integer id) {
		return subjectsService.deleteSubjectById(id);
	}

	@GetMapping("/list")
	public List<Subjects> findAllSubject() {
		return subjectsService.findAllSubject();
	}

	@GetMapping("/{id}")
	public Subjects findOneSubjectById(@PathVariable Integer id) {
		return subjectsService.findOneSubjectById(id);
	}

}
