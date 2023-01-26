package com.repairs.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.repairs.dao.TechnicianDAO;
import com.repairs.dao.TechnicianDAOImp;

import com.repairs.model.TechnicianModel;

@Service
public class TechnicianService {
	private TechnicianDAO techDAO = new TechnicianDAOImp();

	public List<TechnicianModel> searchTechnicianService(String location, String skill, int rate)
			throws ParseException {
		return techDAO.technicianSearch(location, skill, rate);
	}

	public List<TechnicianModel> sortTechnicianService(String location, String skill, int rate) {
		return techDAO.technicianSort(location, skill, rate);
	}

	public List<TechnicianModel> selectTechnicianService(String techName) {
		return techDAO.technicianSelect(techName);
	}

}
