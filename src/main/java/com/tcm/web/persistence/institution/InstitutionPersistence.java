package com.tcm.web.persistence.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcm.web.dao.institution.InstitutionDao;
import com.tcm.web.model.institution.Institution;

@Service
public class InstitutionPersistence {
	
	@Autowired
	private InstitutionDao institutiondao;
	
	public Institution saveInstitution(Institution institution) {
		return institutiondao.save(institution);
	}

	public Institution updateInstitution(Institution institution) {
		return institutiondao.save(institution);
	}

	public List<Institution> getAllInstitutions() {
		return institutiondao.findAll();
	}

	public List<Institution> getInstitutionById(int tutioncenterId) {
		List<Institution> institution = institutiondao.findByTutioncenterId(tutioncenterId);
		return institution;
	}

	public void deleteInstitutionById(int tutioncenterId) {
		institutiondao.deleteById(tutioncenterId);		
	}
	
	public String getInstitutionNameById(int tutioncenterId) {
		return institutiondao.findByTutioncenterId(tutioncenterId).get(0).getTutioncenter();
	}
	
}
