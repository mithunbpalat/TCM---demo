package com.tcm.web.serviceinterface.user;

import java.util.List;

import com.tcm.web.dto.UserDTO;

public interface UserDTOServiceInterface {

	 public List<UserDTO> saveUserDTO(UserDTO userdto);
		
	 public List<UserDTO> updateUserDTO(UserDTO userdto);
		
	 public List<UserDTO> getAllUsers();
		
	 public UserDTO getUserById(int uid);
		
	 public int deleteUserById(int uid);
	 
	 public void deleteAllUser();
	
}
