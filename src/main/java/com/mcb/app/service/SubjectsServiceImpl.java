package com.mcb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.app.model.Subjects;
import com.mcb.app.repository.SubjectsRepository;
import com.mcb.app.response.ResponseData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubjectsServiceImpl implements SubjectsService {

	@Autowired
	private SubjectsRepository subjectsRepository;

	@Override
	public ResponseData createSubject(Subjects subject) {
		log.info("Calling Subject Creaction in serviceImpl");
		ResponseData responseData = new ResponseData();

		Subjects sub = subjectsRepository.save(subject);
		if (sub.getSubjectId() != null) {
			log.info("Subjects created : " + sub.getSubjectId());
			responseData.setStatus(201);
			responseData.setMessage("Subjects created : " + sub.getSubjectId());
			return responseData;
		} else {
			responseData.setStatus(400);
			responseData.setMessage("unable to create Subjects!");
			return responseData;
		}
	}

	@Override
	public ResponseData updateSubjectById(Subjects subject) {
		ResponseData responseData = new ResponseData();

		try {
			subjectsRepository.findById(subject.getSubjectId()).orElseThrow();
			Subjects sub = subjectsRepository.save(subject);
			log.info("Subjects updated : " + sub.getSubjectId());
			responseData.setStatus(200);
			responseData.setMessage("Subjects updated : " + sub.getSubjectId());
		} catch (Exception e) {
			responseData.setStatus(400);
			responseData.setMessage("unable to updated Subjects!");

		}
		return responseData;
	}

	@Override
	public ResponseData deleteSubjectById(Integer subjectId) {
		ResponseData responseData = new ResponseData();
		try {
			subjectsRepository.deleteById(subjectId);
			log.info("Subjects deleted : " + subjectId);
			responseData.setStatus(200);
			responseData.setMessage("Subjects deleted : " + subjectId);
		} catch (Exception e) {
			responseData.setStatus(404);
			responseData.setMessage("Subjects not found!");
		}
		return null;
	}

	@Override
	public List<Subjects> findAllSubject() {
		return subjectsRepository.findAll();
	}

	@Override
	public Subjects findOneSubjectById(Integer subjectId) {
		// TODO Auto-generated method stub
		return subjectsRepository.findById(subjectId).get();
	}

}
