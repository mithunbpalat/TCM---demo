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

	<div class="container-fluid">

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
	
	
	
	<div class="header">
		<h2>Courses </h2><br/>
	
	<div class="row">
		<div class="col-6 col-sm-6 col-md-6">
			<input class="form-control w-75" id="myInput" type="text" placeholder="Search..">
		</div>
		<div class="col-6 col-sm-6 col-md-6">
	  		
	  		<button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#saveModal">
	    		 <img src="/resources/images/plus-lg.svg" style="height:30px;width:30px;"> Add New Course
	  		</button>
	  		
		</div>
	</div></br>
	
	</div>
			
	<div class="alert alert-info alert-dismissible fade show actionmsg">
	    	<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	    	<strong><span class="message">Course Fetched Successfully!</span></strong> 
	</div>
	
	<div class="data-table">
		
	<table class="table table-striped table-bordered" style="width:100%">
	  <thead>
	    <tr>
	        <th>CID</th>
	        <th>Code </th>
	        <th>Course</th>
	        <th>Fees (Rs)</th>
	        <th>Duration (Years)</th>
	        <th>Action</th>
	    </tr>
	  </thead>
	  <tbody id="myTable" class="tbody">
	  </tbody>
	</table>

	</div>
	
<div class="modal" id="updateModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <div class="modal-header">
        <h4 class="modal-title">Update Course</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <div class="modal-body">
			<form>
			
			<div class="row" style="padding : 5px;">
				
				<h6 class="required text-danger"> Please Fill in all Mandatory (*) Fields </h6>
			    <div class="form-group col-4" style="display:none;">
			        <label for="updatecid">CID:</label>
			        <input type="text" class="form-control updatecid" id="updatecid" disabled>
			    </div>
				
				 <div class="form-group col-4">
			        <label for="updatecode">Code<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control updatecode" id="updatecode">
			    </div>
				
			    <div class="form-group col-4">
			        <label for="updatecourse">Course<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control updatecourse" id="updatecourse">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="updatefees">Fees (Rs)<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control updatefees" id="updatefees">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="updateduration">Duration (Years)<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control updateduration" id="updateduration">
			    </div>
			
			</div>
			
			</form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" id="updatesinglecourse" onclick="updatesinglecourse()" data-bs-dismiss="modal" disabled="true">Update</button>
      </div>

    </div>
  </div>
</div>




<div class="modal" id="saveModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <div class="modal-header">
        <h4 class="modal-title">New Course</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <div class="modal-body">
			<form>
			
			<div class="row" style="padding : 5px;">
				
				<h6 class="required text-danger"> Please Fill in all Mandatory (*) Fields </h6>				
				 <div class="form-group col-4" style="display: none;">
			        <label for="cid">CID:</label>
			        <input type="text" class="form-control cid" id="cid">
			    </div>

				 <div class="form-group col-4">
			        <label for="code">Code<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control code" id="code">
			    </div>
				
			    <div class="form-group col-4">
			        <label for="course">Course <span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control course" id="course">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="fees">Fees (Rs)<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control fees" id="fees">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="duration">Duration (Years) <span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control duration" id="duration">
			    </div>
			
			</div>
			
			</form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-primary savesinglecourse" id="savesinglecourse" data-bs-dismiss="modal" disabled>Save</button>
      </div>

    </div>
  </div>
</div>

</div>


 <script src="<c:url value="/resources/angularjs/angular.js" />"></script>
 <script src="<c:url value="/resources/js/course/course.js" />"></script> 
 <script src="<c:url value="/resources/js/common/filtersearch.js" />"></script>

</body>
</html>
