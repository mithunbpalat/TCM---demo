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
import com.tcm.web.dao.course.CourseDao;
import com.tcm.web.model.course.Course;
import com.tcm.web.persistence.course.CoursePersistence;

import jakarta.servlet.ServletException;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = {
		   "classpath:test.properties"
})
public class CourseControllerTest {
	
	 @Autowired
	 private MockMvc mockMvc;
	 
     @Autowired
     private CourseDao courseDao;
     
     @Autowired
 	 private CoursePersistence coursepersistence;
	
     private int global_cid = 57;
     
	 @Test @Order(1)
	 public void saveCourse() throws Exception{
		
		 Course course = new Course(1308, "001", "Artificial Intelligence", "5000", "4");
		 ObjectMapper mapper = new ObjectMapper();
		 String coursejsonStr = mapper.writeValueAsString(course);
 		 ResultActions result = mockMvc.perform(post("/course/savecourse")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(coursejsonStr)); 
			
	 	 result.andExpect(status().isOk())
			   .andDo(print());
	 	 
	 	 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 
	 } 
	/* 
	 @Test
	 public void saveCourseTest() throws Exception{
		
		 Course course = new Course(100002, "001", "Artificial Intelligence", "5000", "4");
		 ObjectMapper mapper = new ObjectMapper();
		 String coursejsonStr = mapper.writeValueAsString(course);
 		 ResultActions result = mockMvc.perform(post("/course/savecoursetest")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(coursejsonStr)); 
			
	 	 result.andExpect(status().isCreated())
	// 	 result.andExpect(status().isOk())
			   .andDo(print());
	 
	 } 
	 */
	 
	 @Test @Order(2)
	 public void updateCourse() throws Exception{
		
		 Course course = new Course(100, "001", "Artificial Intelligence", "5000", "4");
		 ObjectMapper mapper = new ObjectMapper();
		 String coursejsonStr = mapper.writeValueAsString(course);
 		 ResultActions result = mockMvc.perform(post("/course/updatecourse")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(coursejsonStr)); 
			
	 	 result.andExpect(status().isOk())
			  .andDo(print());
	 	 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 
	 } 
	 
	 @Test @Order(3)
	 public void updateCourseNegativeScenario() throws Exception{
		
		 Course course = new Course(11, "001", "Artificial Intelligence", "5000", "4");
		 ObjectMapper mapper = new ObjectMapper();
		 String coursejsonStr = mapper.writeValueAsString(course);
 		 ResultActions result = mockMvc.perform(post("/course/updatecourse")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(coursejsonStr)); 
			
	 	 result.andExpect(status().isOk())
			  .andDo(print());
	 	 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 
	 } 
	 
	 @Test @Order(4)
	 public void getAllCourse() throws Exception{
		 ResultActions result = mockMvc.perform(get("/course/getallcourse"));
		 
		 result.andExpect(status().isOk())
		       .andDo(print());
		 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 } 
	 
	 @Test @Order(5)
	 public void getAllCourseInAlternateWay() throws Exception{
		 List<Course> listofcourse = new ArrayList<>();
		 listofcourse.add(new Course(101, "001", "Artificial Intelligence 01", "5000", "4"));
		 listofcourse.add(new Course(102, "002", "Artificial Intelligence 02", "6000", "5"));
		 int size = listofcourse.size();
		 courseDao.save(listofcourse.get(0));
		 courseDao.save(listofcourse.get(1));
		 ResultActions result = mockMvc.perform(get("/course/getallcourse"))
		 								.andExpect(status().isOk())
		 								.andDo(print());
		 
		 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() + " ==> " + listofcourse.size() + "   ");
		 
	//	 result.andExpect(jsonPath("$.size()", is(listofcourse.size())));   
	 } 
	 
	 
	 
	 @Test @Order(6)
	 public void getCourse() throws Exception{
		int cid = global_cid;
		ResultActions result =   mockMvc.perform(get("/course/getcourse?cid="+cid)
								 .contentType(MediaType.APPLICATION_JSON)
								 .content("{ cid : " + cid + " }"))
								 .andExpect(status().isOk())
								 .andDo(print());
	 } 
	 
	 @Test @Order(7)
	 public void getCourseForSave() throws Exception{
		int cid = global_cid;
		ResultActions result =   mockMvc.perform(get("/course/getcourse?cid="+cid)
								 .contentType(MediaType.APPLICATION_JSON)
								 .content("{ cid : " + cid + " }"))
								 .andExpect(status().isOk())
								 .andDo(print());
		
	 } 
	 
	 @Test @Order(8)
	 public void getCourseNegativeScenario() throws Exception{
		int cid = 1; 
		Throwable exception = assertThrows(
				ServletException.class, () -> {
				ResultActions result =   mockMvc.perform(get("/course/getcourse?cid="+cid)
						 .contentType(MediaType.APPLICATION_JSON)
						 .content("{ cid : " + cid + " }"))
				    	 .andExpect(status().isNotFound())
						 .andDo(print());	
				});
		
	 } 
	 
	 @Test @Order(9)
	 public void deleteCourse() throws Exception{
		
		Course course = new Course(100, "001", "Artificial Intelligence", "5000", "4");
		int cid = courseDao.save(course).getCid();
		ResultActions response = mockMvc.perform(delete("/course/deletecourse?cid="+cid));

	    response.andExpect(status().isOk())
	            .andDo(print());
	    System.out.println("cid"+cid);
		
	 } 
	 
	 
	  
	
}
