package com.tcm.web.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcm.web.dto.UserDTO;
import com.tcm.web.model.user.User;
import com.tcm.web.model.user.UserDetail;
import com.tcm.web.service.institution.InstitutionServiceImpl;
import com.tcm.web.serviceinterface.user.UserDTOServiceInterface;

@Service
public class UserDTOServiceImpl implements UserDTOServiceInterface {

	@Autowired
	private UserServiceImpl userserviceimpl;
	
	@Autowired
	private UserDetailServiceImpl userdetailserviceimpl;
	
	@Autowired
	private InstitutionServiceImpl institutionServiceImpl;
	
	@Override
	public List<UserDTO> saveUserDTO(UserDTO userdto) {
		
		userdto.setTutioncenterId(Integer.valueOf(userdto.getTutioncenteridstr()));
		String tutioncenter = institutionServiceImpl.getInstitutionNameById(userdto.getTutioncenterId());
		userdto.setTutioncenter(tutioncenter);
		 
		User user = new User();
		user.setName(userdto.getName());
		user.setTutioncenter(userdto.getTutioncenter());
		user.setTutioncenterId(userdto.getTutioncenterId());
		user.setRole(userdto.getRole());
		user.setUsername(userdto.getUsername());
		user.setPassword(userdto.getPassword());
		int uid = userserviceimpl.saveUser(user);
		
		UserDetail usdetail = new UserDetail();
		usdetail.setUid(uid);
		usdetail.setName(userdto.getName());
		usdetail.setAddress(userdto.getAddress());
		usdetail.setPhone(userdto.getPhone());
		usdetail.setMobile(userdto.getMobile());
		usdetail.setEmail(userdto.getEmail());
		usdetail.setTutioncenterId(userdto.getTutioncenterId());
		userdetailserviceimpl.saveUserDetail(usdetail);
		
		return getAllUsers();
	}

	@Override
	public List<UserDTO> updateUserDTO(UserDTO userdto) {
		
		userdto.setTutioncenterId(Integer.valueOf(userdto.getTutioncenteridstr()));
		String tutioncenter = institutionServiceImpl.getInstitutionNameById(userdto.getTutioncenterId());
		userdto.setTutioncenter(tutioncenter);
		
		User user = new User();
		user.setUid(userdto.getUid());
		user.setName(userdto.getName());
		user.setTutioncenter(userdto.getTutioncenter());
		user.setTutioncenterId(userdto.getTutioncenterId());
		user.setRole(userdto.getRole());
		user.setUsername(userdto.getUsername());
		user.setPassword(userdto.getPassword());
		userserviceimpl.saveUser(user);
		
		UserDetail usdetail = new UserDetail();
		usdetail.setUsdid(userdto.getUsdid());
		usdetail.setUid(userdto.getUid());
		usdetail.setName(userdto.getName());
		usdetail.setAddress(userdto.getAddress());
		usdetail.setPhone(userdto.getPhone());
		usdetail.setMobile(userdto.getMobile());
		usdetail.setEmail(userdto.getEmail());
		usdetail.setTutioncenterId(userdto.getTutioncenterId());
		userdetailserviceimpl.saveUserDetail(usdetail);
		
		return getAllUsers();
	}

	@Override
	public List<UserDTO> getAllUsers() {
		
		List<User> userlist = userserviceimpl.getAllUsers();
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		for(User us : userlist) {
			UserDTO dto = new UserDTO();
			dto.setUid(us.getUid());
			dto.setName(us.getName());
			dto.setTutioncenter(us.getTutioncenter());
			dto.setTutioncenterId(us.getTutioncenterId());
			dto.setRole(us.getRole());
			UserDetail usdetail = userdetailserviceimpl.getUserDetailByUserId(us.getUid());
			dto.setUsdid(usdetail.getUsdid());
			dto.setAddress(usdetail.getAddress());
			dto.setPhone(usdetail.getPhone());
			dto.setMobile(usdetail.getMobile());
			dto.setEmail(usdetail.getEmail());
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public UserDTO getUserById(int uid) {
		
		User user = userserviceimpl.getUserById(uid);
		UserDTO dto = new UserDTO();
		
		dto.setUid(user.getUid());
		dto.setName(user.getName());
		dto.setTutioncenter(user.getTutioncenter());
		dto.setTutioncenterId(user.getTutioncenterId());
		dto.setTutioncenteridstr(String.valueOf(user.getTutioncenterId()));
		dto.setRole(user.getRole());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		UserDetail usdetail = userdetailserviceimpl.getUserDetailByUserId(user.getUid());
		dto.setUsdid(usdetail.getUsdid());
		dto.setAddress(usdetail.getAddress());
		dto.setPhone(usdetail.getPhone());
		dto.setMobile(usdetail.getMobile());
		dto.setEmail(usdetail.getEmail());
		
		return dto;
	}

	@Override
	public int deleteUserById(int uid) {
		
		UserDetail usdet = userdetailserviceimpl.getUserDetailByUserId(uid);
		userdetailserviceimpl.deleteUserDetailById(usdet.getUsdid());
		userserviceimpl.deleteUserById(uid);
		return uid;
	}
	
	@Override
	public void deleteAllUser() {
		userdetailserviceimpl.deleteall();
		userserviceimpl.deleteall();
	}

}
