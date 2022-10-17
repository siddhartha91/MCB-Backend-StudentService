package com.mcb.app.service;

import java.util.List;

import com.mcb.app.model.Students;
import com.mcb.app.response.ResponseData;

public interface StudentsService {

	public ResponseData createStudent(Students student);

	public ResponseData updateStudentById(Students student);

	public ResponseData deleteStudentById(Integer studentId);

	public List<Students> findAllStudents();

	public Students findOneStudentById(Integer studentId);

}
