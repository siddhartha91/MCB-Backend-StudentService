package com.mcb.app.service;

import java.util.List;

import com.mcb.app.model.Subjects;
import com.mcb.app.response.ResponseData;

public interface SubjectsService {

	public ResponseData createSubject(Subjects subject);

	public ResponseData updateSubjectById(Subjects subject);

	public ResponseData deleteSubjectById(Integer subjectId);

	public List<Subjects> findAllSubject();

	public Subjects findOneSubjectById(Integer subjectId);

}
