package com.tcm.web.serviceinterface.course;

import java.util.List;

import com.tcm.web.model.course.Course;

public interface CourseServiceInterface {
	
    public  List<Course> saveCourse(Course course);
	
	public  List<Course> updateCourse(Course course);
	
	public List<Course> getAllCourses();
	
	public Course getCourseById(int cid);
	
	public void deleteCourseById(int cid);
	
	public Course saveCourseTest(Course course);
	
}
