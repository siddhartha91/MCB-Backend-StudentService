package com.mcb.app.model;

import java.time.LocalDate;

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
public class Marks {
	@Id
	@Column(name="marks_Id")
	private Integer marksId;
	
	@Column(name="stud_id")
	private Integer studentId;
	
	@Column(name="sub_id")
	private Integer subjectId;
	
	@Column(name="created_Date")
	private LocalDate createdDate;
	
	@Column(name="marks")
	private int marks;	
}
