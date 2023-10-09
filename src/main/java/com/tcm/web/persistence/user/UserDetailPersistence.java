package com.tcm.web.persistence.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcm.web.dao.user.UserDetailDao;
import com.tcm.web.model.user.UserDetail;

@Service
public class UserDetailPersistence {
	
	@Autowired
	private UserDetailDao userdetaildao;
	
	public UserDetail saveUserDetail(UserDetail userdetail) {
		return userdetaildao.save(userdetail);
	}

	public UserDetail updateUserDetail(UserDetail userdetail) {
		return userdetaildao.save(userdetail);
	}

	public List<UserDetail> getAllUserDetails() {
		return userdetaildao.findAll();
	}

	public List<UserDetail> getUserDetailByUserDetailsId(int usdid) {
		List<UserDetail> userdetail = userdetaildao.findByUsdid(usdid);
		return userdetail;
	}

	public List<UserDetail> getUserDetailByUserId(int uid) {
		List<UserDetail> userdetail = userdetaildao.findByUid(uid);
		return userdetail;
	}

	public void deleteUserDetailById(int usdid) {
		userdetaildao.deleteById(usdid);		
	}
	
	public void deleteall() {
		userdetaildao.deleteAll();		
	}
}
