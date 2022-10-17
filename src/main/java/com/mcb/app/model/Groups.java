package com.mcb.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Groups {
	@Id
	@Column(name = "group_id")
	private Integer groupId;
	@Column(name = "group_name")
	private String name;
}
