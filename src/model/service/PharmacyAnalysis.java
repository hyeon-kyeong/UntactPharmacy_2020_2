package model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.PharmacyDTO;
import model.dao.PharmacyDAO;

// an example business class
public class PharmacyAnalysis {
	private PharmacyDAO dao;
	
	public PharmacyAnalysis() {}
	
	public PharmacyAnalysis(PharmacyDAO dao) {
		super();
		this.dao = dao;
	}
}
