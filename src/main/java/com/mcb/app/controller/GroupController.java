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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.app.model.Groups;
import com.mcb.app.response.ResponseData;
import com.mcb.app.service.GroupsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("mcb/api/groups")
@Slf4j
public class GroupController {

	@Autowired
	private GroupsService groupsService;

	@PostMapping("/create")
	public ResponseData createGroups(@RequestBody Groups Groups) {
		
		return groupsService.createGroups(Groups);
	}

	@PutMapping("/update")
	public ResponseData updateGroupsById(@RequestBody Groups Groups) {
		return groupsService.createGroups(Groups);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseData deleteGroupsById(@PathVariable Integer id) {
		return groupsService.deleteGroupsById(id);
	}

	@GetMapping("/list")
	public List<Groups> findAllGroupss() {
		return groupsService.findAllGroupss();
	}

	@GetMapping("/{id}")
	public Groups findOneGroupsById(@PathVariable Integer id) {
		log.info("findOneGroupsById () ",id);
		return groupsService.findOneGroupsById(id).get();
	}

}
