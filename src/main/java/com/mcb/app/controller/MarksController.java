package com.mcb.app.controller;

import java.time.LocalDate;
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

import com.mcb.app.model.Marks;
import com.mcb.app.response.ResponseData;
import com.mcb.app.service.MarkesService;

@RestController
@RequestMapping("mcb/api/marks")
public class MarksController {

	@Autowired
	private MarkesService markesService;

	@PostMapping("/create")
	public ResponseData createMarkes(@RequestBody Marks markes) {
		
		return markesService.createMarkes(markes);
	}

	@PutMapping("/update")
	public ResponseData updateMarkesById(@RequestBody Marks markes) {
		markes.setCreatedDate(LocalDate.now());
		return markesService.updateMarkesById(markes);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseData deleteMarkesById(@PathVariable Integer id) {
		return markesService.deleteMarkesById(id);
	}

	@GetMapping("/list")
	public List<Marks> findAllMarkes() {
		return markesService.findAllMarkes();
	}

	@GetMapping("/{id}")
	public Marks findOneMarkesById(@PathVariable Integer id) {
		Marks m = new Marks();
		m.setCreatedDate(LocalDate.now());
		return m;
	}

}
