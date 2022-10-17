package com.mcb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.app.model.Marks;
import com.mcb.app.repository.MarksRepository;
import com.mcb.app.response.ResponseData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MarkesServiceImpl implements MarkesService {

	@Autowired
	private MarksRepository marksRepository;
	
	@Override
	public ResponseData createMarkes(Marks markes) {
		ResponseData responseData = new ResponseData();

		Marks marks = marksRepository.save(markes);
		if (marks.getMarksId() != null) {
			log.info("Marks created : " + marks.getMarksId());
			responseData.setStatus(201);
			responseData.setMessage("Marks created : " + marks.getMarksId());
			return responseData;
		} else {
			responseData.setStatus(400);
			responseData.setMessage("unable to create Marks!");
			return responseData;
		}
	}

	@Override
	public ResponseData updateMarkesById(Marks marks) {
		ResponseData responseData = new ResponseData();
		try {
			marksRepository.findById(marks.getMarksId()).orElseThrow();
			Marks mark = marksRepository.save(marks);
			log.info("Marks updated : " + mark.getMarksId());
			responseData.setStatus(200);
			responseData.setMessage("Marks updated : " + mark.getMarksId());
		} catch (Exception e) {
			responseData.setStatus(400);
			responseData.setMessage("unable to updated Marks!");

		}
		return responseData;
	}

	@Override
	public ResponseData deleteMarkesById(Integer markesId) {
		ResponseData responseData = new ResponseData();
		try {
			marksRepository.deleteById(markesId);
			log.info("student deleted : " + markesId);
			responseData.setStatus(200);
			responseData.setMessage("Marks deleted : " + markesId);
		} catch (Exception e) {
			responseData.setStatus(404);
			responseData.setMessage("Marks not found!");
		}
		return null;
	}

	@Override
	public List<Marks> findAllMarkes() {
		return marksRepository.findAll();
	}

	@Override
	public Marks findOneMarkesById(Integer markesId) {
		return marksRepository.findById(markesId).get();
	}

}
