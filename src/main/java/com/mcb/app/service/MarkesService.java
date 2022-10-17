package com.mcb.app.service;

import java.util.List;

import com.mcb.app.model.Marks;
import com.mcb.app.response.ResponseData;

public interface MarkesService {

	public ResponseData createMarkes(Marks markes);

	public ResponseData updateMarkesById(Marks markes);

	public ResponseData deleteMarkesById(Integer markesId);

	public List<Marks> findAllMarkes();

	public Marks findOneMarkesById(Integer markesId);

}
