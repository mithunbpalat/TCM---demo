package com.tcm.web.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcm.web.dao.course.CourseDao;
import com.tcm.web.model.course.Course;
import com.tcm.web.persistence.course.CoursePersistence;
import com.tcm.web.serviceinterface.course.CourseServiceInterface;

@Service
public class CourseServiceImpl implements CourseServiceInterface {

	@Autowired
	private CoursePersistence coursepersistence;
	
	@Override
	public List<Course> saveCourse(Course course) {
		coursepersistence.saveCourse(course);
		return coursepersistence.getAllCourses();
	}

	@Override
	public List<Course> updateCourse(Course course) {
		coursepersistence.saveCourse(course);
		return coursepersistence.getAllCourses();
	}

	@Override
	public List<Course> getAllCourses() {
		return coursepersistence.getAllCourses();
	}

	@Override
	public Course getCourseById(int cid) {
		return coursepersistence.getCourseById(cid).get(0);
	}

	@Override
	public void deleteCourseById(int cid) {
		coursepersistence.deleteCourseById(cid); 
	}
	
	@Override
	public Course saveCourseTest(Course course) {
		return coursepersistence.saveCourse(course);
	}
	
}
