package com.tcm.test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tcm.web.dao.course.CourseDao;
import com.tcm.web.model.course.Course;
import com.tcm.web.persistence.course.CoursePersistence;
import com.tcm.web.service.course.CourseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTestResponse {
	
	@Autowired
	private CoursePersistence coursepersistence;
	
	@MockBean
	private CourseDao courseDao;
	
	@Test
	public void saveCourseTest() {
		Course course = new Course(100, "001", "Artificial Intelligence", "5000", "4");
		when(courseDao.save(course)).thenReturn(course);
		assertEquals(course, coursepersistence.saveCourse(course));
	}
	
	@Test
	public void updateCourseTest() {
		Course course = new Course(100, "001", "Artificial Intelligence", "4000", "5");
		when(courseDao.save(course)).thenReturn(course);
		assertEquals(course, coursepersistence.updateCourse(course));
	}
	
	@Test
	public void getCoursesTest() {
		when(courseDao.findAll()).thenReturn(Stream.of(
				new Course(100, "001", "Artificial Intelligence", "4000", "5"),
				new Course(101, "002", "Robotics", "5000", "6"))
				.collect(Collectors.toList()));
		assertEquals(2, coursepersistence.getAllCourses().size());
	}
	
	@Test
	public void getCourseByIdTest() {
		int cid = 100;
		when(courseDao.findByCid(cid)).thenReturn(Stream.of(
				new Course(100, "001", "Robotics", "5000", "6"))
				.collect(Collectors.toList()));
		assertEquals(1, coursepersistence.getCourseById(cid).size());
	}
	
	@Test 
	public void deleteCourseTest() {
		Course course = new Course(100, "001", "Robotics", "5000", "6");
		int cid = 100;
		coursepersistence.deleteCourseById(cid);
		verify(courseDao, times(1)).deleteById(cid);
	}
	
	
	
}