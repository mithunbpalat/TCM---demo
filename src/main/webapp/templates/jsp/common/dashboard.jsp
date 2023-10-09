<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Courses</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <%@ include file="/templates/jsp/common/common.jsp" %>  
   
</head>
<body> 

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">
		 <img src="/resources/images/tcm-logo.png" style="height:50px;width:50px;">	
	</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="/TCM/InstitutionList">Institution</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/TCM/UserList">Users</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/TCM/CourseList">Course</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="Search">
        <button class="btn btn-primary" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>



</body>
</html>


