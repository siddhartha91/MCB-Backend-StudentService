package com.mcb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.app.model.Students;
import com.mcb.app.repository.StudentsRepository;
import com.mcb.app.response.ResponseData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	private StudentsRepository studentsRepository;

	@Override
	public ResponseData createStudent(Students student) {
		ResponseData responseData = new ResponseData();
		Students students = studentsRepository.save(student);
		if (students.getStudentId() != null) {
			log.info("student created : " + students.getStudentId());
			responseData.setStatus(201);
			responseData.setMessage("student created : " + students.getStudentId());
			return responseData;
		} else {
			responseData.setStatus(400);
			responseData.setMessage("unable to create student!");
			return responseData;
		}
	}

	@Override
	public ResponseData updateStudentById(Students student) {
		ResponseData responseData = new ResponseData();

		try {
			studentsRepository.findById(student.getStudentId()).orElseThrow();
			Students students = studentsRepository.save(student);
			log.info("student created : " + students.getStudentId());
			responseData.setStatus(200);
			responseData.setMessage("student updated : " + students.getStudentId());
		} catch (Exception e) {
			responseData.setStatus(400);
			responseData.setMessage("unable to create student!");

		}
		return responseData;
	}

	@Override
	public ResponseData deleteStudentById(Integer studentId) {
		ResponseData responseData = new ResponseData();
		try {
			studentsRepository.deleteById(studentId);
			log.info("student deleted : " + studentId);
			responseData.setStatus(200);
			responseData.setMessage("Student deleted : " + studentId);
		} catch (Exception e) {
			responseData.setStatus(404);
			responseData.setMessage("Student not found!");
		}
		return null;
	}

	@Override
	public List<Students> findAllStudents() {
		return studentsRepository.findAll();
	}

	@Override
	public Students findOneStudentById(Integer studentId) {
		log.info("Caallling:"+studentId);
		return studentsRepository.findById(studentId).get();
	}

}
