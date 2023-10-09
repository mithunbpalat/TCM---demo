package com.tcm.test.integration;

import static org.junit.Assert.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcm.web.dao.institution.InstitutionDao;
import com.tcm.web.model.institution.Institution;
import com.tcm.web.persistence.institution.InstitutionPersistence;

import jakarta.servlet.ServletException;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = {
		   "classpath:test.properties"
})
public class InstitutionControllerTest {
	
	 @Autowired
	 private MockMvc mockMvc;
	 
     @Autowired
     private InstitutionDao institutiondao;
     
     @Autowired
 	 private InstitutionPersistence institutionpersistence;
	
     private int global_tutioncenteridid = 52;
     
	 @Test @Order(1)
	 public void saveInstitution() throws Exception{
		
		 Institution institution = new Institution(100, "ABC Tution Center", "Piravom", "9998889990", "9998889990",
					"abc@gmail.com", "Ernakulam", "Kerala", "686610");
		 ObjectMapper mapper = new ObjectMapper();
		 String institutionjsonStr = mapper.writeValueAsString(institution);
 		 ResultActions result = mockMvc.perform(post("/institution/saveinstitution")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(institutionjsonStr)); 
			
	 	 result.andExpect(status().isOk())
			   .andDo(print());
	 	 
	 	 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 
	 } 
	 
	 @Test @Order(2)
	 public void updateInstitution() throws Exception{
		
		 Institution institution = new Institution(100, "ABC Tution Center", "Piravom", "9998889990", "9998889990",
					"abc@gmail.com", "Ernakulam", "Kerala", "686610");
		 ObjectMapper mapper = new ObjectMapper();
		 String institutionjsonStr = mapper.writeValueAsString(institution);
 		 ResultActions result = mockMvc.perform(post("/institution/updateinstitution")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(institutionjsonStr)); 
			
	 	 result.andExpect(status().isOk())
			  .andDo(print());
	 	 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 
	 } 
	 
	 @Test @Order(3)
	 public void updateInstitutionNegativeScenario() throws Exception{
		
		 Institution institution = new Institution(11, "ABC Tution Center", "Piravom", "9998889990", "9998889990",
					"abc@gmail.com", "Ernakulam", "Kerala", "686610");
		 ObjectMapper mapper = new ObjectMapper();
		 String institutionjsonStr = mapper.writeValueAsString(institution);
 		 ResultActions result = mockMvc.perform(post("/institution/updateinstitution")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(institutionjsonStr)); 
			
	 	 result.andExpect(status().isOk())
			  .andDo(print());
	 	 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 
	 } 
	 
	 @Test @Order(4)
	 public void getAllInstitution() throws Exception{
		 ResultActions result = mockMvc.perform(get("/institution/getallinstitution"));
		 
		 result.andExpect(status().isOk())
		       .andDo(print());
		 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 } 
	 
	 @Test @Order(5)
	 public void getAllInstitutionInAlternateWay() throws Exception{
		 List<Institution> listofinstitution = new ArrayList<Institution>();
		 listofinstitution.add(new Institution(100, "ABC Tution Center", "Piravom", "9998889990", "9998889990",
					"abc@gmail.com", "Ernakulam", "Kerala", "686610"));
		 listofinstitution.add(new Institution(101, "XYZ Tution Center", "Piravom", "9998889990", "9998889990",
					"xyz@gmail.com", "Ernakulam", "Kerala", "686610"));
		 int size = listofinstitution.size();
		 institutiondao.save(listofinstitution.get(0));
		 institutiondao.save(listofinstitution.get(1));
		 ResultActions result = mockMvc.perform(get("/institution/getallinstitution"))
		 								.andExpect(status().isOk())
		 								.andDo(print());
		 
		 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() + " ==> " + listofinstitution.size() + "   ");
		 
	//	 result.andExpect(jsonPath("$.size()", is(listofinstitution.size())));   
	 } 
	 
	 
	 
	 @Test @Order(6)
	 public void getInstitution() throws Exception{
		int tutioncenterId = global_tutioncenteridid;
		ResultActions result =   mockMvc.perform(get("/institution/getinstitution?tutioncenterId="+tutioncenterId)
								 .contentType(MediaType.APPLICATION_JSON)
								 .content("{ tutioncenterId : " + tutioncenterId + " }"))
								 .andExpect(status().isOk())
								 .andDo(print());
	 } 
	 
	 @Test @Order(7)
	 public void getInstitutionForSave() throws Exception{
		int tutioncenterId = global_tutioncenteridid;
		ResultActions result =   mockMvc.perform(get("/institution/getinstitution?tutioncenterId="+tutioncenterId)
								 .contentType(MediaType.APPLICATION_JSON)
								 .content("{ tutioncenterId : " + tutioncenterId + " }"))
								 .andExpect(status().isOk())
								 .andDo(print());
		
	 } 
	 
	 @Test @Order(8)
	 public void getCourseNegativeScenario() throws Exception{
		int tutioncenterId = 5; 
		Throwable exception = assertThrows(
				ServletException.class, () -> {
				ResultActions result =   mockMvc.perform(get("/institution/getinstitution?tutioncenterId="+tutioncenterId)
						 .contentType(MediaType.APPLICATION_JSON)
						 .content("{ tutioncenterId : " + tutioncenterId + " }"))
				    	 .andExpect(status().isNotFound())
						 .andDo(print());	
				});
		
	 } 
	 
	 @Test @Order(9)
	 public void deleteInstitution() throws Exception{
		
		Institution institution = new Institution(100, "ABC Tution Center", "Piravom", "9998889990", "9998889990",
					"abc@gmail.com", "Ernakulam", "Kerala", "686610");
		int tutioncenterId = institutiondao.save(institution).getTutioncenterId();
		ResultActions response = mockMvc.perform(delete("/institution/deleteinstitution?tutioncenterId="+tutioncenterId));

	    response.andExpect(status().isOk())
	            .andDo(print());
	    System.out.println("tutioncenterId"+tutioncenterId);
		
	 } 
	 
}
