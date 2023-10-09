<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Institutions</title>
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
		<h2>Institutions </h2><br/>
	
	<div class="row">
		<div class="col-6 col-sm-6 col-md-6">
			<input class="form-control w-75" id="myInput" type="text" placeholder="Search..">
		</div>
		<div class="col-6 col-sm-6 col-md-6">
	  		
	  		<button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#saveModal">
	    		 <img src="/resources/images/plus-lg.svg" style="height:30px;width:30px;"> Add New Institution
	  		</button>
	  		
		</div>
	</div></br>
	
	</div>
			
	<div class="alert alert-info alert-dismissible fade show actionmsg">
	    	<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	    	<strong><span class="message">Institution Fetched Successfully!</span></strong> 
	</div>
	
	<div class="data-table">
	
	<table class="table table-striped table-bordered" style="width:100%">
	  <thead>
	    <tr>
	        <th>SlNo</th>
	<!--    <th>TutioncenterId</th>  -->
	        <th>Tution Center</th>
	        <th>Address</th>
	<!--    <th>Mobile</th>          -->
	        <th>Phone</th>
	<!--    <th>Email</th>           -->
	        <th>District</th>
	<!--    <th>State</th>           -->
	<!--    <th>Pincode</th>         -->
	        <th style="width:260px;">Action</th>
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
        <h4 class="modal-title">Update Institution</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <div class="modal-body">
			<form>
			
			<div class="row" style="padding : 5px;">
				
				<h6 class="required text-danger"> Please Fill in all Mandatory (*) Fields </h6>		
			    <div class="form-group col-4" style="display:none;">
			        <label for="updatetutioncenterId">Tution Center Id:</label>
			        <input type="text" class="form-control updatetutioncenterId" id="updatetutioncenterId" disabled>
			    </div>
				
				 <div class="form-group col-4">
			        <label for="updatetutioncenter">Tution Center<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control updatetutioncenter" id="updatetutioncenter">
			    </div>
				
			    <div class="form-group col-4">
			        <label for="updateaddress">Address<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control updateaddress" id="updateaddress">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="updatemobile">Mobile<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control updatemobile" id="updatemobile">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="updatephone">Phone<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control updatephone" id="updatephone">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="updateemail">Email<span class="text-danger"> * </span>:</label>
			        <input type="email" class="form-control updateemail" id="updateemail">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="updatedistrict">District<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control updatedistrict" id="updatedistrict">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="updatestate">State<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control updatestate" id="updatestate">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="updatepincode">Pincode<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control updatepincode" id="updatepincode">
			    </div>
			
			</div>
			
			</form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-secondary " id="updatesingleinstitution"  onclick="updatesingleinstitution()" data-bs-dismiss="modal">Update</button>
      </div>

    </div>
  </div>
</div>




<div class="modal" id="saveModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <div class="modal-header">
        <h4 class="modal-title">New Institution</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <div class="modal-body">
			<form>
			
			<div class="row" style="padding : 5px;">
				
				<h6 class="required text-danger"> Please Fill in all Mandatory (*) Fields </h6>		
				 <div class="form-group col-4" style="display:none;">
			        <label for="tutioncenterId">Tution Center Id <span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control tutioncenterId" id="tutioncenterId" disabled>
			    </div>
				
				 <div class="form-group col-4">
			        <label for="tutioncenter">Tution Center<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control tutioncenter" id="tutioncenter">
			    </div>
				
			    <div class="form-group col-4">
			        <label for="address">Address<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control address" id="address">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="mobile">Mobile<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control mobile" id="mobile">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="phone">Phone<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control phone" id="phone">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="email">Email<span class="text-danger"> * </span>:</label>
			        <input type="email" class="form-control email" id="email">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="district">District<span class="text-danger"> * </span>:</label>
			        <input type="text" class="form-control district" id="district">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="state">State:</label>
			        <input type="text" class="form-control state" id="state">
			    </div>
			    
			    <div class="form-group col-4">
			        <label for="pincode">Pincode<span class="text-danger"> * </span>:</label>
			        <input type="number" class="form-control pincode" id="pincode">
			    </div>
			
			</div>
			
			</form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-primary savesingleinstitution" id="savesingleinstitution" data-bs-dismiss="modal">Save</button>
      </div>

    </div>
  </div>
</div>

</div>


 <script src="<c:url value="/resources/angularjs/angular.js" />"></script>
 <script src="<c:url value="/resources/js/institution/institution.js" />"></script> 
 <script src="<c:url value="/resources/js/common/filtersearch.js" />"></script>

</body>
</html>
