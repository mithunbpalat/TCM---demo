package com.tcm.web.dao.institution;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcm.web.model.institution.Institution;

@Repository
public interface InstitutionDao extends JpaRepository<Institution, Integer>{
	
//	@Query("SELECT a from institution a where a.tutioncenterId = ?1")
	List<Institution> findByTutioncenterId(int tutioncenterId);
	
}
