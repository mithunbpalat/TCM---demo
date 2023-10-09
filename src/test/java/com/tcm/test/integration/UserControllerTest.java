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
import org.json.JSONObject;
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
import com.tcm.web.dao.user.UserDao;
import com.tcm.web.dao.user.UserDetailDao;
import com.tcm.web.dto.UserDTO;
import com.tcm.web.persistence.user.UserDetailPersistence;
import com.tcm.web.persistence.user.UserPersistence;

import jakarta.servlet.ServletException;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = {
		   "classpath:test.properties"
})
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	 
    @Autowired
    private UserDao userdao;
    
    @Autowired
    private UserDetailDao userdetaildao;
    
    @Autowired
	private UserPersistence userpersistence;
    
    @Autowired
	private UserDetailPersistence userdetailpersistence;
	
    UserTestDTO usertestDTO = new UserTestDTO();
 	
	@Test @Order(1)
	 public void saveUser() throws Exception{
		 
		 ResultActions response = mockMvc.perform(delete("/user/deletealluser"));
		 
		 UserDTO userdto = new UserDTO();
		 userdto.setName("Rajeev");
		 userdto.setTutioncenteridstr("1");
		 userdto.setRole("STUDENT");
		 userdto.setUsername("Rajeev");
		 userdto.setPassword("Rajeev");
		 userdto.setAddress("Piravom");
		 userdto.setPhone("8086632281");
		 userdto.setMobile("8086632281");
		 userdto.setEmail("abc@gmail.com");
		 ObjectMapper mapper = new ObjectMapper();
		 String userdtojsonStr = mapper.writeValueAsString(userdto);
		 ResultActions result = mockMvc.perform(post("/user/saveuser")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(userdtojsonStr)); 
			
	 	 result.andExpect(status().isOk())
			   .andDo(print());
	 	 
		 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
		 System.out.println(str);
		 JSONObject jobj = jarr.getJSONObject(0);
		 String uid = jobj.get("uid").toString();
		 String usdid = jobj.get("usdid").toString();
		 usertestDTO.setGlobal_uid(Integer.valueOf(uid));
		 usertestDTO.setGlobal_usdid(Integer.valueOf(usdid));
		 System.out.println("global_uid =>"+ usertestDTO.getGlobal_uid() + "   global_usdid =>" + usertestDTO.getGlobal_usdid());
	 } 
	 
	 @Test @Order(2)
	 public void updateUser() throws Exception{
		
		 saveUser();
		 int uid = usertestDTO.getGlobal_uid();
		 int usdid = usertestDTO.getGlobal_usdid();
		 UserDTO userdto = new UserDTO();
		 userdto.setUid(uid);
		 userdto.setUsdid(usdid);
		 userdto.setName("Rajeev");
		 userdto.setTutioncenteridstr("1");
		 userdto.setRole("STUDENT");
		 userdto.setUsername("Shreya");
		 userdto.setPassword("Shreya");
		 userdto.setAddress("Piravom");
		 userdto.setPhone("8086632281");
		 userdto.setMobile("8086632281");
		 userdto.setEmail("abc@gmail.com");
		 ObjectMapper mapper = new ObjectMapper();
		 String userdtojsonStr = mapper.writeValueAsString(userdto);
		 ResultActions result = mockMvc.perform(post("/user/updateuser")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(userdtojsonStr)); 
			
	 	 result.andExpect(status().isOk())
			  .andDo(print());
	 	 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 
	 } 
	 
	 @Test @Order(3)
	 public void updateUserNegativeScenario() throws Exception{
		
		 Throwable exception = assertThrows(
					ServletException.class, () -> {
		 int uid = 200000;
		 int usdid = 200000;
		 UserDTO userdto = new UserDTO();
		 userdto.setUid(uid);
		 userdto.setUsdid(usdid);
		 userdto.setName("Rajeev");
		 userdto.setTutioncenteridstr("1");
		 userdto.setRole("STUDENT");
		 userdto.setUsername("Shreya");
		 userdto.setPassword("Shreya");
		 userdto.setAddress("Piravom");
		 userdto.setPhone("8086632281");
		 userdto.setMobile("8086632281");
		 userdto.setEmail("abc@gmail.com");
		 ObjectMapper mapper = new ObjectMapper();
		 String userdtojsonStr = mapper.writeValueAsString(userdto);
		 ResultActions result = mockMvc.perform(post("/user/updateuser")
				 .contentType(MediaType.APPLICATION_JSON)
	 			 .content(userdtojsonStr)); 
			
	 	 result.andExpect(status().isOk())
			  .andDo(print());
	 	 
	 	 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
		 
		 });
	 
	 } 
	 
	 @Test @Order(4)
	 public void getAllUser() throws Exception{
		 ResultActions result = mockMvc.perform(get("/user/getallUser"));
		 
		 result.andExpect(status().isOk())
		       .andDo(print());
		 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() );
	 } 
	 
	 @Test @Order(5)
	 public void getAllUserInAlternateWay() throws Exception{
		 List<UserDTO> listofuser = new ArrayList<UserDTO>();
		 saveUser();
		 int size = 1;
		 ResultActions result = mockMvc.perform(get("/user/getallUser"))
		 								.andExpect(status().isOk())
		 								.andDo(print());
		 
		 String str = result.andReturn().getResponse().getContentAsString();
		 JSONArray jarr = new JSONArray(str);
		 System.out.print("Number Of Records : "+jarr.length() + " ==> " + listofuser.size() + "   ");
		 
	//	 result.andExpect(jsonPath("$.size()", is(listofinstitution.size())));   
	 } 
	 
	 
	 
	 @Test @Order(6)
	 public void getUser() throws Exception{
		saveUser();
		int uid = usertestDTO.getGlobal_uid();
		int usdid = usertestDTO.getGlobal_usdid();
		ResultActions result =   mockMvc.perform(get("/user/getuser?uid="+uid)
								 .contentType(MediaType.APPLICATION_JSON)
								 .content("{ uid : " + uid + " }"))
								 .andExpect(status().isOk())
								 .andDo(print());
	 } 
	 
	 @Test @Order(7)
	 public void getUserForSave() throws Exception{
		saveUser();
		int uid = usertestDTO.getGlobal_uid();
		int usdid = usertestDTO.getGlobal_usdid();
		ResultActions result =   mockMvc.perform(get("/user/getuser?uid="+uid)
								 .contentType(MediaType.APPLICATION_JSON)
								 .content("{ uid : " + uid + " }"))
								 .andExpect(status().isOk())
								 .andDo(print());
		
	 } 
	 
	 @Test @Order(8)
	 public void getUserNegativeScenario() throws Exception{
		int uid = 5; 
		Throwable exception = assertThrows(
				ServletException.class, () -> {
				ResultActions result =   mockMvc.perform(get("/user/getuser?uid="+uid)
						 .contentType(MediaType.APPLICATION_JSON)
						 .content("{ uid : " + uid + " }"))
				    	 .andExpect(status().isNotFound())
						 .andDo(print());	
				});
		
	 } 
	 
	 @Test @Order(9)
	 public void deleteInstitution() throws Exception{
		
		 saveUser();
		 int uid = usertestDTO.getGlobal_uid();
		 int usdid = usertestDTO.getGlobal_usdid();
		 ResultActions response = mockMvc.perform(delete("/user/deleteuser?uid="+uid));

	     response.andExpect(status().isOk())
	            .andDo(print());
	     System.out.println("tutioncenterId"+uid);
		
	 } 
	 

}
