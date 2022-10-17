package com.mcb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.app.model.Teacher;
import com.mcb.app.repository.TeacherRepository;
import com.mcb.app.response.ResponseData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public ResponseData createSubject(Teacher teacher) {
		ResponseData responseData = new ResponseData();

		Teacher techr = teacherRepository.save(teacher);
		if (techr.getSubjectId() != null) {
			log.info("Teacher created : " + techr.getTeacherId());
			responseData.setStatus(201);
			responseData.setMessage("Teacher created : " + techr.getTeacherId());
			return responseData;
		} else {
			responseData.setStatus(400);
			responseData.setMessage("unable to create Teacher!");
			return responseData;
		}
	}

	@Override
	public ResponseData updateSubjectById(Teacher teacher) {
		ResponseData responseData = new ResponseData();

		try {
			teacherRepository.findById(teacher.getTeacherId()).orElseThrow();
			Teacher techr = teacherRepository.save(teacher);
			log.info("Teacher updated : " + techr.getTeacherId());
			responseData.setStatus(200);
			responseData.setMessage("Teacher updated : " + techr.getTeacherId());
		} catch (Exception e) {
			responseData.setStatus(400);
			responseData.setMessage("unable to updated Teacher!");

		}
		return responseData;
	}

	@Override
	public ResponseData deleteSubjectById(Integer teacherId) {
		ResponseData responseData = new ResponseData();
		try {
			teacherRepository.deleteById(teacherId);
			log.info("Teacher deleted : " + teacherId);
			responseData.setStatus(200);
			responseData.setMessage("Teacher deleted : " + teacherId);
		} catch (Exception e) {
			responseData.setStatus(404);
			responseData.setMessage("Teacher not found!");
		}
		return null;
	}

	@Override
	public List<Teacher> findAllSubject() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher findOneSubjectById(Integer teacherId) {
		return teacherRepository.findById(teacherId).get();
	}

}
