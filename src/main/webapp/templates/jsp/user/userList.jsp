<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
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
		<h2>Users </h2><br/>
	
	<div class="row">
		<div class="col-6 col-sm-6 col-md-6">
			<input class="form-control w-75" id="myInput" type="text" placeholder="Search..">
		</div>
		<div class="col-6 col-sm-6 col-md-6">
	  		
	  		<button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#saveModal">
	    		 <img src="/resources/images/plus-lg.svg" style="height:30px;width:30px;"> Add New User
	  		</button>
	  		
		</div>
	</div></br>
	
	</div>
			
	<div class="alert alert-info alert-dismissible fade show actionmsg">
	    	<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	    	<strong><span class="message">Users Fetched Successfully!</span></strong> 
	</div>
	
	<div class="data-table">
		
	<table class="table table-striped table-bordered" style="width:100%">
	  <thead>
	    <tr>
	        <th>SlNo</th>
	        <th>Tution Center</th>
			<th>Name</th>
			<th>Role</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Email</th>
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
        <h4 class="modal-title">Update User</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <div class="modal-body">
			<form>
			
			<div class="row" style="padding : 5px;">
				
				<h6 class="required text-danger"> Please Fill in all Mandatory (*) Fields </h6>
			    <div class="form-group col-4" style="display:none;">
			        <label for="updateuid">UID:</label>
			        <input type="text" class="form-control updateuid" id="updateuid" disabled>
			    </div>
			    
			     <div class="form-group col-4" style="display:none;">
			        <label for="updateusdid">USDID:</label>
			        <input type="text" class="form-control updateusdid" id="updateusdid" disabled>
			    </div>
				
				 <div class="form-group col-4">
			        <label for="updatename">Name<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control updatename" id="updatename">
			    </div>
				
				<div class="form-group col-4">
					<label for="updatetutioncenterid">Select Tution Center (select one)<span class="text-danger"> * </span>:</label>
				    <select class="form-select updatetutioncenterid" id="updatetutioncenterid" name="updatetutioncenterid">
				    </select>
				</div>
				
			    <div class="form-group col-4">
			        <label for="updaterole">Role<span class="text-danger"> * </span>:</label>
			        <select class="form-select updaterole" id="updaterole" name="updaterole">
				      <option value="ADMIN">ADMIN</option>
				      <option value="TEACHER">TEACHER</option>
				      <option value="STUDENT">STUDENT</option>
				      <option value="PARENT">PARENT</option>
				      <option value="OTHER">OTHER</option>
				    </select>
			    </div>
			
			    <div class="form-group col-4">
			        <label for="updateusername">Username<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control updateusername" id="updateusername">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="updatepassword">Password<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control updatepassword" id="updatepassword">
			    </div>
			
				 <div class="form-group col-4">
			        <label for="updateaddress">Address<span class="text-danger"> * </span>:</label>
			    	<textarea class="form-control updateaddress" rows="2" id="updateaddress" name="updateaddress"></textarea>
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="updatephone">Phone<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control updatephone" id="updatephone">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="updatemobile">Mobile<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control updatemobile" id="updatemobile">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="updateemail">Email<span class="text-danger"> * </span>:</label>
			        <input type="email" class="form-control updateemail" id="updateemail">
			    </div>
			    
			</div>
			
			</form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" id="updatesingleuser" onclick="updatesingleuser()" data-bs-dismiss="modal" disabled="true">Update</button>
      </div>

    </div>
  </div>
</div>




<div class="modal" id="saveModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <div class="modal-header">
        <h4 class="modal-title">New User</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <div class="modal-body">
			<form>
			
			<div class="row" style="padding : 5px;">
				
				<h6 class="required text-danger"> Please Fill in all Mandatory (*) Fields </h6>				
				 <div class="form-group col-4" style="display:none;">
			        <label for="uid">UID:</label>
			        <input type="text" class="form-control uid" id="uid" disabled>
			    </div>
			    
			     <div class="form-group col-4" style="display:none;">
			        <label for="usdid;">UID:</label>
			        <input type="text" class="form-control usdid;" id="usdid;" disabled>
			    </div>
				
				 <div class="form-group col-4">
			        <label for="name;">Name<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control name" id="name">
			    </div>
				
				<div class="form-group col-4">
					<label for="tutioncenterid" >Select Tution Center (select one)<span class="text-danger"> * </span>:</label>
				    <select class="form-select tutioncenterid" id="tutioncenterid" name="tutioncenterid" >
				    </select>
				</div>
				
			    <div class="form-group col-4">
			        <label for="role">Role<span class="text-danger"> * </span>:</label>
			        <select class="form-select role" id="role" name="role">
				      <option value="ADMIN">ADMIN</option>
				      <option value="TEACHER">TEACHER</option>
				      <option value="STUDENT">STUDENT</option>
				      <option value="PARENT">PARENT</option>
				      <option value="OTHER">OTHER</option>
				    </select>
			    </div>
			
			    <div class="form-group col-4">
			        <label for="username">Username<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control username" id="username">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="password">Password<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control password" id="password">
			    </div>
			
				 <div class="form-group col-4">
			        <label for="address">Address<span class="text-danger"> * </span>:</label>
			        <textarea class="form-control address" rows="2" id="address" name="address"></textarea>
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="phone">Phone<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control phone" id="phone">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="mobile">Mobile<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control mobile" id="mobile">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="email">Email<span class="text-danger"> * </span>:</label>
			        <input type="email" class="form-control email" id="email">
			    </div>
			
			</div>
			
			</form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-primary savesingleuser" id="savesingleuser" data-bs-dismiss="modal" disabled>Save</button>
      </div>

    </div>
  </div>
</div>

</div>


 <script src="<c:url value="/resources/angularjs/angular.js" />"></script>
 <script src="<c:url value="/resources/js/user/user.js" />"></script> 
 <script src="<c:url value="/resources/js/common/filtersearch.js" />"></script>

</body>
</html>
