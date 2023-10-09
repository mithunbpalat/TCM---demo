package com.tcm.web.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcm.web.model.user.UserDetail;
import com.tcm.web.persistence.user.UserDetailPersistence;
import com.tcm.web.serviceinterface.user.UserDetailsServiceInterface;

@Service
public class UserDetailServiceImpl implements UserDetailsServiceInterface {

	@Autowired
	private UserDetailPersistence userdetailpersistence;
	
	@Override
	public List<UserDetail> saveUserDetail(UserDetail userdetail) {
		userdetailpersistence.saveUserDetail(userdetail);
		return userdetailpersistence.getAllUserDetails();
	}

	@Override
	public List<UserDetail> updateUserDetail(UserDetail userdetail) {
		userdetailpersistence.saveUserDetail(userdetail);
		return userdetailpersistence.getAllUserDetails();
	}

	@Override
	public List<UserDetail> getAllUserDetails() {
		return userdetailpersistence.getAllUserDetails();
	}

	@Override
	public UserDetail getUserDetailByUserDetailsId(int usdid) {
		List<UserDetail> userdetail = userdetailpersistence.getUserDetailByUserDetailsId(usdid);
		return userdetail.get(0);
	}

	@Override
	public UserDetail getUserDetailByUserId(int uid) {
		List<UserDetail> userdetail = userdetailpersistence.getUserDetailByUserId(uid);
		return userdetail.get(0);
	}

	@Override
	public void deleteUserDetailById(int usdid) {
		userdetailpersistence.deleteUserDetailById(usdid);		
	}

	@Override
	public void deleteall() {
		userdetailpersistence.deleteall(); 		
	}
}
