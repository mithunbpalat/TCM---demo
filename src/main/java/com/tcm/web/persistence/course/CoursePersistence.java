package com.tcm.web.persistence.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcm.web.dao.course.CourseDao;
import com.tcm.web.model.course.Course;

@Service
public class CoursePersistence {
	
	@Autowired
	private CourseDao coursedao;
	
	public Course saveCourse(Course course) {
		return coursedao.save(course);
	}

	public Course updateCourse(Course course) {
		return coursedao.save(course);
	}

	public List<Course> getAllCourses() {
		return coursedao.findAll();
	}

	public List<Course> getCourseById(int cid) {
		List<Course> course = coursedao.findByCid(cid);
		return 	course;
	}

	public void deleteCourseById(int cid) {
		coursedao.deleteById(cid);
	}
	
}
