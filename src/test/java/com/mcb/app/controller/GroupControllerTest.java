package com.mcb.app.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcb.app.model.Groups;
import com.mcb.app.response.ResponseData;
import com.mcb.app.service.GroupsService;

@WebMvcTest(controllers = GroupController.class)
class GroupControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private GroupsService groupsService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void test_createGroups() throws Exception {
		Long id = 101L;
		Groups groups = new Groups();
		groups.setGroupId(101);
		groups.setName("A");

		ResponseData responseData = new ResponseData();
		responseData.setMessage("Groups created with id : " + groups.getGroupId());

		when(groupsService.createGroups(Mockito.any(Groups.class))).thenReturn(responseData);

		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Bearer ");
		
		
		// calling rest api
		ResultActions response = mockMvc.perform(post("/mcb/api/groups/create").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(responseData)));

		// then - verify the output
		response.andDo(print()).andExpect(status().isCreated())
				.andExpect(jsonPath("$.status", is(responseData.getStatus())))
				.andExpect(jsonPath("$.message", is(responseData.getMessage())));
	}

}
