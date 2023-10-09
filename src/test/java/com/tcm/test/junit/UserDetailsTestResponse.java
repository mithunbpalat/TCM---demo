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

import com.tcm.web.dao.user.UserDetailDao;
import com.tcm.web.model.user.UserDetail;
import com.tcm.web.persistence.user.UserDetailPersistence;
import com.tcm.web.service.user.UserDetailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsTestResponse {
	
	@Autowired
	private UserDetailPersistence userdetailpersistence;
	
	@MockBean
	private UserDetailDao userDetailDao;
	
	@Test
	public void saveUserDetailTest() {
		UserDetail userdetail = new UserDetail(100, 101, "Catherine", "Address", "9998889990", "9998889990", "abc@gmail.com",5);
		when(userDetailDao.save(userdetail)).thenReturn(userdetail);
		assertEquals(userdetail, userdetailpersistence.saveUserDetail(userdetail));
		UserDetail userdetail1 = new UserDetail(101, 102, "Treesa", "Address", "9998889990", "9998889990", "abc@gmail.com",5);
		when(userDetailDao.save(userdetail1)).thenReturn(userdetail1);
		assertEquals(userdetail1, userdetailpersistence.saveUserDetail(userdetail1));
	}
	
	@Test
	public void updateUserDetailTest() {
		UserDetail userdetail = new UserDetail(100, 101, "Catherine", "Piravom", "9998889990", "9998889990", "abc@gmail.com",5);
		when(userDetailDao.save(userdetail)).thenReturn(userdetail);
		assertEquals(userdetail, userdetailpersistence.saveUserDetail(userdetail));
	}
	
	@Test
	public void getUserDetailsTest() {
		when(userDetailDao.findAll()).thenReturn(Stream.of(
				new UserDetail(100, 101, "Catherine", "Piravom", "9998889990", "9998889990", "abc@gmail.com",5),
				new UserDetail(103, 104, "Nikki", "Vyttila", "9998889990", "9998889990", "abc@gmail.com",5))
				.collect(Collectors.toList()));
		assertEquals(2, userdetailpersistence.getAllUserDetails().size());
	}
	
	@Test
	public void getUserDetailByUsdIdTest() {
		int usdid = 100;
		when(userDetailDao.findByUsdid(usdid)).thenReturn(Stream.of(
				new UserDetail(100, 101, "Catherine", "Piravom", "9998889990", "9998889990", "abc@gmail.com",5))
				.collect(Collectors.toList()));
		assertEquals(1, userdetailpersistence.getUserDetailByUserDetailsId(usdid).size());
	}
	
	@Test
	public void getUserDetailByUIdTest() {
		int uid = 102;
		when(userDetailDao.findByUid(uid)).thenReturn(Stream.of(
				new UserDetail(101, 102, "Treesa", "Piravom", "9998889990", "9998889990", "abc@gmail.com",5))
				.collect(Collectors.toList()));
		assertEquals(1, userdetailpersistence.getUserDetailByUserId(uid).size());
	}
	
	@Test 
	public void deleteUserTest() {
		UserDetail userdetail = new UserDetail(100, 101, "Catherine", "Address", "9998889990", "9998889990", "abc@gmail.com",5);
		int usdid = 100;
		userdetailpersistence.deleteUserDetailById(usdid);
		verify(userDetailDao, times(1)).deleteById(usdid);
	}
	
}
