package com.tcm.web.dao.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcm.web.model.course.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {
	
//	@Query("SELECT a from course a where a.cid = ?1")
	List<Course> findByCid(int cid);
	
}
