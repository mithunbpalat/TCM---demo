package com.tcm.test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tcm.web.dao.institution.InstitutionDao;
import com.tcm.web.model.institution.Institution;
import com.tcm.web.persistence.institution.InstitutionPersistence;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstitutionTestResponse {
	
	@Autowired
	private InstitutionPersistence institutionpersistence;
	
	@MockBean
	private InstitutionDao institutionDao;
	
	@Test
	public void saveInstitutionTest() {
		Institution institution = new Institution(100, "ABC Tution Center", "Piravom", "9998889990", "9998889990",
				"abc@gmail.com", "Ernakulam", "Kerala", "686610");
		when(institutionDao.save(institution)).thenReturn(institution);
		assertEquals(institution, institutionpersistence.saveInstitution(institution));
	}
	
	@Test
	public void updateInstitutionTest() {
		Institution institution = new Institution(100, "ABC Tution Center", "Piravom", "9998889990", "9998889990",
				"abc@gmail.com", "Ernakulam", "Kerala", "686610");
		when(institutionDao.save(institution)).thenReturn(institution);
		assertEquals(institution, institutionpersistence.updateInstitution(institution));
	}
	
	@Test
	public void getInstitutionsTest() {
		when(institutionDao.findAll()).thenReturn(Stream.of(
				new Institution(100, "ABC Tution Center", "Piravom", "9998889900", "9998889900",
						"abc@gmail.com", "Ernakulam", "Kerala", "686610"),
				new Institution(101, "XYZ Tution Center", "Vyttila", "9998889990", "9998889990",
						"xyz@gmail.com", "Ernakulam", "Kerala", "686610"))
				.collect(Collectors.toList()));
		assertEquals(2, institutionpersistence.getAllInstitutions().size());
	}
	
	@Test
	public void getInstitutionByIdTest() {
		int tid = 100;
		when(institutionDao.findByTutioncenterId(tid)).thenReturn(Stream.of(
				new Institution(100, "XYZ Tution Center", "Vyttila", "9998889990", "9998889990",
						"xyz@gmail.com", "Ernakulam", "Kerala", "686610"))
				.collect(Collectors.toList()));
		assertEquals(1, institutionpersistence.getInstitutionById(tid).size());
	}
	
	@Test 
	public void deleteInstitutionTest() {
		Institution institution = new Institution(100, "ABC Tution Center", "Piravom", "9998889990", "9998889990",
				"abc@gmail.com", "Ernakulam", "Kerala", "686610");
		int tid = 100;
		institutionpersistence.deleteInstitutionById(tid);  
		verify(institutionDao, times(1)).deleteById(tid);
	}
	
	@Test
	public void getInstitutionNameByIdTest() {
		int tid = 100;
		when(institutionDao.findByTutioncenterId(tid)).thenReturn(Stream.of(
				new Institution(100, "XYZ Tution Center", "Vyttila", "9998889990", "9998889990",
						"xyz@gmail.com", "Ernakulam", "Kerala", "686610"))
				.collect(Collectors.toList()));
		assertEquals(1, institutionDao.findByTutioncenterId(tid).size());
	}
	
	
}
