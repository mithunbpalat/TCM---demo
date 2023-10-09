package com.tcm.web.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcm.web.model.user.UserDetail;

@Repository
public interface UserDetailDao extends JpaRepository<UserDetail, Integer>{

//	@Query("SELECT a from userdetail a where a.usdid = ?1")
	List<UserDetail> findByUsdid(int usdid);
	
//	@Query("SELECT a from userdetail a where a.uid = ?1")
	List<UserDetail> findByUid(int uid);
}
