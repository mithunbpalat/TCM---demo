 var courseApp = angular.module("courseApp", []);  
 courseApp.controller('courseController', function($scope,$http) { 

  var url = "/course/getallcourse";  
  $http.get(url).then(function(response) {  
      $scope.courses = response.data;  
  });
 
 });
          

       
  