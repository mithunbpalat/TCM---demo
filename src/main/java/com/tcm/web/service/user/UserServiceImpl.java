package com.tcm.web.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcm.web.model.user.User;
import com.tcm.web.persistence.user.UserPersistence;
import com.tcm.web.serviceinterface.user.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface {
	
	@Autowired
	private UserPersistence userpersistence;
	
	@Override
	public int saveUser(User user) {
		int uid = userpersistence.saveUser(user).getUid();
		return uid;
	}

	@Override
	public int updateUser(User user) {
		int uid = userpersistence.updateUser(user).getUid();
		return uid;
	}

	@Override
	public List<User> getAllUsers() {
		return userpersistence.getAllUsers();
	}

	@Override
	public User getUserById(int uid) {
		User user = userpersistence.getUserById(uid).get(0);
		return user;
	}

	@Override
	public void deleteUserById(int uid) {
		userpersistence.deleteUserById(uid);		
	}
	
	@Override
	public void deleteall() {
		userpersistence.deleteall();
	}
}
