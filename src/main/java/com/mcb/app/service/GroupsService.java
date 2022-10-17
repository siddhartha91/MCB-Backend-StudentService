package com.mcb.app.service;

import java.util.List;
import java.util.Optional;

import com.mcb.app.model.Groups;
import com.mcb.app.response.ResponseData;

public interface GroupsService {

	public ResponseData createGroups(Groups Groups);

	public ResponseData updateGroupsById(Groups Groups);

	public ResponseData deleteGroupsById(Integer GroupsId);

	public List<Groups> findAllGroupss();

	public Optional<Groups> findOneGroupsById(Integer GroupsId);

}
