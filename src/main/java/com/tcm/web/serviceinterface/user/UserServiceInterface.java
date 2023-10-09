package com.tcm.web.serviceinterface.user;

import java.util.List;

import com.tcm.web.model.user.User;

public interface UserServiceInterface {
	
	 public int saveUser(User user);
		
	 public int updateUser(User user);
		
	 public List<User> getAllUsers();
		
	 public User getUserById(int uid);
		
	 public void deleteUserById(int uid);
	 
	 public void deleteall();
	
}
