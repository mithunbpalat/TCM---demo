package com.tcm.web.restcontroller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcm.web.dto.UserDTO;
import com.tcm.web.model.institution.Institution;
import com.tcm.web.service.institution.InstitutionServiceImpl;
import com.tcm.web.service.user.UserDTOServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDTOServiceImpl userdtoserviceimpl;
	
	@PostMapping(value="/saveuser")
	public List<UserDTO> saveUser(@RequestBody UserDTO userdto) {
		return userdtoserviceimpl.saveUserDTO(userdto);
	}

	@PostMapping(value="/updateuser")
	public List<UserDTO> updateUser(@RequestBody UserDTO userdto) {
		return userdtoserviceimpl.updateUserDTO(userdto);
	}

	@GetMapping(value="/getallUser")
	public List<UserDTO> getAllUsers() {
		return userdtoserviceimpl.getAllUsers();
	}

	@GetMapping(value="/getuser")
	public UserDTO getUserById(@RequestParam int uid) {
		return userdtoserviceimpl.getUserById(uid);
	}

	@DeleteMapping(value="/deleteuser")
	public int deleteuserById(@RequestParam int uid) {
		return userdtoserviceimpl.deleteUserById(uid);
	}
	
	@DeleteMapping(value="/deletealluser")
	public void deletealluser() {
		userdtoserviceimpl.deleteAllUser();
	}
}
