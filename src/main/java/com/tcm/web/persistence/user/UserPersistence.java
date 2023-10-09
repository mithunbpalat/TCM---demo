package com.tcm.web.persistence.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcm.web.dao.user.UserDao;
import com.tcm.web.model.user.User;

@Service
public class UserPersistence {
	
	@Autowired
	private UserDao userdao;
	
	public User saveUser(User user) {
		return userdao.save(user);
	}

	public User updateUser(User user) {
		return userdao.save(user);
	}

	public List<User> getAllUsers() {
		return userdao.findAll();
	}

	public List<User> getUserById(int uid) {
		List<User> user = userdao.findByUid(uid);
		return user;
	}

	public void deleteUserById(int uid) {
		userdao.deleteById(uid);		
	}
	
	public void deleteall(){
		userdao.deleteAll();
	}
	
	
}
