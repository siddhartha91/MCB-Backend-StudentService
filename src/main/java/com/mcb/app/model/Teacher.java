package com.mcb.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
	@Id
	@Column(name = "teacher_Id")
	private Integer teacherId;

	@Column(name = "sub_id")
	private Integer subjectId;

	@Column(name = "group_id")
	private Integer groupId;

}
