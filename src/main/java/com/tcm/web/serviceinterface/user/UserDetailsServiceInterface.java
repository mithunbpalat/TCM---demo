package com.tcm.web.serviceinterface.user;

import java.util.List;

import com.tcm.web.model.user.UserDetail;

public interface UserDetailsServiceInterface {
	
	public  List<UserDetail> saveUserDetail(UserDetail userdetail);
	
	public  List<UserDetail> updateUserDetail(UserDetail userdetail);
	
	public List<UserDetail> getAllUserDetails();
	
	public UserDetail getUserDetailByUserDetailsId(int usdid);
	
	public UserDetail getUserDetailByUserId(int uid);
	
	public void deleteUserDetailById(int usdid);
	
	public void deleteall();
	
}
