package com.tcm.web.restcontroller.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcm.web.model.institution.Institution;
import com.tcm.web.service.institution.InstitutionServiceImpl;


@RestController
@RequestMapping("/institution")
public class InstitutionController {
	
	@Autowired
	private InstitutionServiceImpl institutionServiceImpl;
	
	@PostMapping(value="/saveinstitution")
	public List<Institution> saveCourse(@RequestBody Institution institution) {
		return institutionServiceImpl.saveInstitution(institution);
	}

	@PostMapping(value="/updateinstitution")
	public List<Institution> updateInstitution(@RequestBody Institution institution) {
		return institutionServiceImpl.updateInstitution(institution);
	}

	@GetMapping(value="/getallinstitution")
	public List<Institution> getAllCourses() {
		return institutionServiceImpl.getAllInstitutions();
	}

	@GetMapping(value="/getinstitution")
	public Institution getCourseById(@RequestParam int tutioncenterId) {
		return institutionServiceImpl.getInstitutionById(tutioncenterId);
	}

	@DeleteMapping(value="/deleteinstitution")
	public int deleteCourseById(@RequestParam int tutioncenterId) {
		institutionServiceImpl.deleteInstitutionById(tutioncenterId);
		return tutioncenterId;
	}
	
}
