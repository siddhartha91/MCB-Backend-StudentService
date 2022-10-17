package com.mcb.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.app.model.Groups;
import com.mcb.app.repository.GroupsRepository;
import com.mcb.app.response.ResponseData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GroupsServiceImpl implements GroupsService {

	@Autowired
	GroupsRepository groupsRepository;

	@Override
	public ResponseData createGroups(Groups Groups) {
		ResponseData responseData = new ResponseData();
		log.info("GroupsServiceImpl -> createGroups: " + Groups);
		Groups group = groupsRepository.save(Groups);
		if (group.getGroupId() != null) {
			log.info("Groups created : " + group.getGroupId());
			responseData.setStatus(201);
			responseData.setMessage("Groups created : " + group.getGroupId());
			return responseData;
		} else {
			responseData.setStatus(400);
			responseData.setMessage("unable to create Groups!");
			return responseData;
		}
	}

	@Override
	public ResponseData updateGroupsById(Groups groups) {
		ResponseData responseData = new ResponseData();
		
		try {
			log.info("GroupsServiceImpl -> updateGroupsById: " + groups);
			groupsRepository.findById(groups.getGroupId()).orElseThrow();
			Groups group = groupsRepository.save(groups);
			log.info("student created : " + group.getGroupId());
			responseData.setStatus(200);
			responseData.setMessage("Groups updated : " + group.getGroupId());
		} catch (Exception e) {
			responseData.setStatus(400);
			responseData.setMessage("unable to updated Groups!");

		}
		return responseData;
	}

	@Override
	public ResponseData deleteGroupsById(Integer GroupsId) {
		ResponseData responseData = new ResponseData();
		try {
			groupsRepository.deleteById(GroupsId);
			log.info("Groups deleted : " + GroupsId);
			responseData.setStatus(200);
			responseData.setMessage("Groups deleted : " + GroupsId);
			return responseData;
		} catch (Exception e) {
			responseData.setStatus(404);
			responseData.setMessage("Groups not found!");
			return responseData;
		}
	}

	@Override
	public List<Groups> findAllGroupss() {
		return groupsRepository.findAll();
	}

	@Override
	public Optional<Groups> findOneGroupsById(Integer GroupsId) {
		log.info("GroupsServiceImpl -> findOneGroupsById: " + GroupsId);
		return groupsRepository.findById(GroupsId);
	}

}
