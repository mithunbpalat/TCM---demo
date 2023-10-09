package com.tcm.web.restcontroller.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcm.web.model.course.Course;
import com.tcm.web.service.course.CourseServiceImpl;



@RestController
@RequestMapping("/course")
public class CourseControllers {

	@Autowired
	private CourseServiceImpl courseService;
	
	@PostMapping(value="/savecourse")
	public List<Course> saveCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}

	@PostMapping(value="/updatecourse")
	public List<Course> updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}

	@GetMapping(value="/getallcourse")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	@GetMapping(value="/getcourse")
	public Course getCourseById(@RequestParam int cid) {
		return courseService.getCourseById(cid);
	}

	@DeleteMapping(value="/deletecourse")
	public int deleteCourseById(@RequestParam int cid) {
		courseService.deleteCourseById(cid);
		return cid;
	}
	
	@PostMapping(value="/savecoursetest")
	public Course saveCourseTest(@RequestBody Course course) {
		return courseService.saveCourseTest(course);
	}

	
}
