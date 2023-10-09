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

import com.tcm.web.dao.user.UserDao;
import com.tcm.web.model.user.User;
import com.tcm.web.persistence.user.UserPersistence;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestResponse {

	@Autowired
	private UserPersistence userpersistence;
	
	@MockBean
	private UserDao userDao;
	
	@Test
	public void saveUserTest() {
		User user = new User(100, "Catherine", "ABC Tutioncenter", 5, "TEACHER", "catherine", "catherine");
		when(userDao.save(user)).thenReturn(user);
		assertEquals(user, userpersistence.saveUser(user));
	}
	
	@Test
	public void updateUserTest() {
		User user = new User(100, "Catherine", "ABC Tutioncenter", 5, "TEACHER", "catherine", "catherine");
		when(userDao.save(user)).thenReturn(user);
		assertEquals(user, userpersistence.updateUser(user));
	}
	
	@Test
	public void getUsersTest() {
		when(userDao.findAll()).thenReturn(Stream.of(
				new User(100, "Catherine", "ABC Tutioncenter", 5, "TEACHER", "catherine", "catherine"),
				new User(101, "Nikki", "XYZ Tutioncenter", 6, "TEACHER", "nikki", "nikki"))
				.collect(Collectors.toList()));
		assertEquals(2, userpersistence.getAllUsers().size());
	}
	
	@Test
	public void getUserByIdTest() {
		int uid = 100;
		when(userDao.findByUid(uid)).thenReturn(Stream.of(
				new User(100, "Catherine", "ABC Tutioncenter", 5, "TEACHER", "catherine", "catherine"))
				.collect(Collectors.toList()));
		assertEquals(1, userpersistence.getUserById(uid).size());
	}
	
	@Test 
	public void deleteUserTest() {
		User user = new User(100, "Catherine", "ABC Tutioncenter", 5, "TEACHER", "catherine", "catherine");
		int uid = 100;
		userpersistence.deleteUserById(uid);
		verify(userDao, times(1)).deleteById(uid);
	}
	
	
}

