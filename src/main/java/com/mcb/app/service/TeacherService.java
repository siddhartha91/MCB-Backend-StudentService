package com.mcb.app.service;

import java.util.List;

import com.mcb.app.model.Teacher;
import com.mcb.app.response.ResponseData;

public interface TeacherService {

	public ResponseData createSubject(Teacher teacher);

	public ResponseData updateSubjectById(Teacher teacher);

	public ResponseData deleteSubjectById(Integer teacherId);

	public List<Teacher> findAllSubject();

	public Teacher findOneSubjectById(Integer teacherId);

}
