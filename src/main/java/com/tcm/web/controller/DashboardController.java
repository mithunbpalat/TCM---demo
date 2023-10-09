package com.tcm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcm.web.model.course.Course;
import com.tcm.web.service.course.CourseServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/TCM")
public class DashboardController {
	
	@Autowired
	private CourseServiceImpl courseService;

	@RequestMapping("/Dashboard")
	public ModelAndView dashboardPage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/dashboard");
		return mav;
	}
	
	@RequestMapping("/CourseList")
	public ModelAndView coursePage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("course/courseList");
		return mav;
	}
	
	@RequestMapping("/CourseAngularList")
	public ModelAndView angcoursePage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Course> courses = courseService.getAllCourses();
		mav.addObject("courses",courses);
		mav.setViewName("course/angcourseList");
		return mav;
	}
	
	@RequestMapping("/InstitutionList")
	public ModelAndView institutionPage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("institution/institutionList");
		return mav;
	}
	
	
	@RequestMapping("/UserList")
	public ModelAndView userPage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/userList");
		return mav;
	}
	
}
