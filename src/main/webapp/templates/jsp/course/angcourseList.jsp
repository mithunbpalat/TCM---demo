<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Course</title>
    
    <%@ include file="/templates/jsp/common/common.jsp" %>  
   
</head>
<body  ng-app = "courseApp"> 
	
<!--	<p> <c:out value="${courses}" /><p>      -->
<!--
    <c:forEach var="course" items="${courses}" varStatus="loop">
  	<c:if test="${loop.index != 0}">
    <c:out value="${course.code}"/>
    </c:if>
	</c:forEach>
	-->

	<h2>Course </h2><br/>
	
	<div class="row">
		<div class="col-6 col-sm-6 col-md-6">
			<input class="form-control w-75" id="myInput" type="text" placeholder="Search..">
		</div>
		<div class="col-6 col-sm-6 col-md-6">
	  		
	  		<button type="button" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#saveModal">
	    		 <img src="/resources/images/plus-lg.svg" style="height:30px;width:30px;"> Add New Course
	  		</button>
	  		
		</div>
	</div></br>
			
	<div class="alert alert-info alert-dismissible fade show actionmsg">
	    	<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	    	<strong><span class="message">Course Fetched Successfully!</span></strong> 
	</div>
	 
	 
	<div ng-controller = "courseController">  
        
         <table class="table table-striped table-bordered" style="width:100%">
		  <thead>
		    <tr>
		        <th>CID</th>
		        <th>Code</th>
		        <th>Course</th>
		        <th>Fees</th>
		        <th>Duration</th>
		        <th>Action</th>
		    </tr>
		  </thead>
        <!-- <tbody>
	            <tr ng-repeat = "course in courses">  
	               <td>{{ $index + 1 }}</td>
	               <td>{{ course.code }}</td>  
	               <td>{{ course.course }}</td>  
	               <td>{{ course.fees }}</td>  
	               <td>{{ course.duration }}</td>  
	               <td><button type="button" class="btn btn-outline-secondary" ng-click="showmodal({{course.cid}})" data-bs-toggle="modal" data-bs-target="#updateModal"><img src="/resources/images/pencil-square.svg" style="height:24px;width:24px;"> Edit</button>
			  		   <button type="button" class="btn btn-outline-danger" ng-click="deleteCourseSingle({{course.cid}})" ><img src="/resources/images/trash.svg" style="height:24px;width:24px;"> Delete</button>
			  	   <td>
	            </tr> 
            </tbody>   -->
            
            
            <tbody>
	            
     	            <c:forEach var="course" items="${courses}" varStatus="loop">
                <tr >
                 	<c:if test="${loop.index != 0}">
    				<td> <c:out value="${loop.index}"/> </td>
    				<td> <c:out value="${course.code}"/> </td>
    				<td> <c:out value="${course.course}"/> </td>
    				<td> <c:out value="${course.fees}"/> </td>
    				<td> <c:out value="${course.duration}"/> </td>
    				 
	               <td><button type="button" class="btn btn-outline-secondary" ng-click="showmodal(<c:out value="${course.cid}"/>)" data-bs-toggle="modal" data-bs-target="#updateModal"><img src="/resources/images/pencil-square.svg" style="height:24px;width:24px;"> Edit</button>
			  		   <button type="button" class="btn btn-outline-danger" ng-click="deleteCourseSingle({{course.cid}})" ><img src="/resources/images/trash.svg" style="height:24px;width:24px;"> Delete</button>
			  	   <td>
			  	    </c:if>
			  	 </tr>
					</c:forEach>  
	             
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
			
			    <div class="form-group col-4" style="display:none;">
			        <label for="updatecid">CID:</label>
			        <input type="text" class="form-control updatecid" id="updatecid" disabled>
			    </div>
				
				 <div class="form-group col-4">
			        <label for="updatecode">Code:</label>
			        <input type="text" class="form-control updatecode" id="updatecode">
			    </div>
				
			    <div class="form-group col-4">
			        <label for="updatecourse">Course:</label>
			        <input type="text" class="form-control updatecourse" id="updatecourse">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="updatefees">Fees:</label>
			        <input type="text" class="form-control updatefees" id="updatefees">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="updateduration">Duration:</label>
			        <input type="text" class="form-control updateduration" id="updateduration">
			    </div>
			
			</div>
			
			</form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-secondary " onclick="updatesinglecourse()" data-bs-dismiss="modal">Update</button>
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
				
				 <div class="form-group col-4" style="display: none;">
			        <label for="cid">Code:</label>
			        <input type="text" class="form-control cid" id="cid">
			    </div>

				 <div class="form-group col-4">
			        <label for="code">Code:</label>
			        <input type="text" class="form-control code" id="code">
			    </div>
				
			    <div class="form-group col-4">
			        <label for="course">Course:</label>
			        <input type="text" class="form-control course" id="course">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="fees">Fees:</label>
			        <input type="text" class="form-control fees" id="fees">
			    </div>
			
			    <div class="form-group col-4">
			        <label for="duration">Duration:</label>
			        <input type="text" class="form-control duration" id="duration">
			    </div>
			
			</div>
			
			</form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-primary savesinglecourse" data-bs-dismiss="modal">Save</button>
      </div>

    </div>
  </div>
</div>



 <script src="<c:url value="/resources/angularjs/angular.js" />"></script>
<!-- <script src="<c:url value="/resources/js/course/course.js" />"></script> -->
<!-- <script src="<c:url value="/resources/js/course/angcourse.js" />"></script> -->
 <script src="<c:url value="/resources/js/common/filtersearch.js" />"></script>

</body>
</html>
