package com.tcm.web.service.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcm.web.dao.institution.InstitutionDao;
import com.tcm.web.model.institution.Institution;
import com.tcm.web.persistence.institution.InstitutionPersistence;
import com.tcm.web.serviceinterface.institution.InstitutionServiceInterface;

@Service
public class InstitutionServiceImpl implements InstitutionServiceInterface{
	
	@Autowired
	private InstitutionPersistence institutionpersistence;
	
	@Override
	public List<Institution> saveInstitution(Institution institution) {
		institutionpersistence.saveInstitution(institution);
		return institutionpersistence.getAllInstitutions();
	}

	@Override
	public List<Institution> updateInstitution(Institution institution) {
		institutionpersistence.saveInstitution(institution);
		return institutionpersistence.getAllInstitutions();
	}

	@Override
	public List<Institution> getAllInstitutions() {
		return institutionpersistence.getAllInstitutions();
	}

	@Override
	public Institution getInstitutionById(int tutioncenterId) {
		List<Institution> institution = institutionpersistence.getInstitutionById(tutioncenterId);
		return institution.get(0);
	}

	@Override
	public void deleteInstitutionById(int tutioncenterId) {
		institutionpersistence.deleteInstitutionById(tutioncenterId);		
	}
	
	@Override
	public String getInstitutionNameById(int tutioncenterId) {
		return institutionpersistence.getInstitutionNameById(tutioncenterId);
	}

}
