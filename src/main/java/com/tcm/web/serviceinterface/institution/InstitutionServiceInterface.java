package com.tcm.web.serviceinterface.institution;

import java.util.List;

import com.tcm.web.model.institution.Institution;

public interface InstitutionServiceInterface {
	
	public  List<Institution> saveInstitution(Institution institution);
	
	public  List<Institution> updateInstitution(Institution institution);
	
	public List<Institution> getAllInstitutions();
	
	public Institution getInstitutionById(int tutioncenterId);
	
	public void deleteInstitutionById(int tutioncenterId);
	
	public String getInstitutionNameById(int tutioncenterId);
	
}
