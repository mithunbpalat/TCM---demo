package com.tcm.web.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcm.web.model.user.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

//	@Query("SELECT a from user a where a.uid = ?1")
	List<User> findByUid(int uid);
}
