
$(".actionmsg").show();
$(".actionmsg").delay("slow").fadeIn();
setInterval(function () {
	$(".actionmsg").hide();     
	}, 5000);

getCourse();
	
setInterval(function () {	
	if( $(".updatecode").val() && $(".updatecourse").val() && $(".updatefees").val() && $(".updateduration").val() ){
		$('#updatesinglecourse').prop('disabled', false);
		$(".required").hide();
	}else{
		$(".required").show();
		$('#updatesinglecourse').prop('disabled', true);
	}
	
	if( $(".code").val() && $(".course").val() && $(".fees").val() && $(".duration").val() ){
		$('#savesinglecourse').prop('disabled', false);
		$(".required").hide();
	}else{
		$(".required").show();
		$('#savesinglecourse').prop('disabled', true);
	}
}, 1000);

function getCourse(){
    $.ajax({
        type      : 'GET',
        url       : '/course/getallcourse',
        success   : function(result){
            getCourseSuccess(result);
            getCourseList(result);
        }
    });
}


function getCourseSuccess(response){

    $(".tbody").empty();
    var row = '';
    var tr = '';
    var c = 0;
    $.each(response, function(key,inv){
		c = c + 1;
        tr = '<tr>'+
              '<td>'+c+'</td>'+
              '<td>'+inv.code +'</td>'+
              '<td>'+inv.course +'</td>'+
              '<td>'+inv.fees +'</td>'+
              '<td>'+inv.duration +'</td>'+
              '<td><button type="button" class="btn btn-outline-secondary" onclick="showmodal('+inv.cid+')" data-bs-toggle="modal" data-bs-target="#updateModal"><img src="/resources/images/pencil-square.svg" style="height:24px;width:24px;"> Edit</button>     '+
			  '<button type="button" class="btn btn-outline-danger" onclick="deleteCourseSingle('+inv.cid+')" ><img src="/resources/images/trash.svg" style="height:24px;width:24px;"> Delete</button><td>'+
			  '</tr>'
        row = row + tr ;
    })
    $(".tbody").append(row);
}

function showmodal(cid){
	getCourseSingle(cid);		
}


function getCourseList(response){

    $(".delcid").empty();
    $(".updcid").empty();
    var row = '<option value="">Please Select A Course</option>';
    var opt = '';
    $.each(response, function(key,inv){
        opt = '<option value="'+inv.cid+'">'+inv.code+' - '+inv.course+'</option>';
        row = row + opt ;
    })
    $(".delcid").append(row);
    $(".updcid").append(row);
}




function getCourseSingle(cid){

    $.ajax({
        type      : 'GET',
        url       : '/course/getcourse?cid='+cid,
        success   : function(result){
            getCourseSingleSuccess(result);
        }
    });
}


function getCourseSingleSuccess(response){

    $(".updatecid").val(response.cid);
    $(".updatecode").val(response.code);
    $(".updatecourse").val(response.course);
    $(".updatefees").val(response.fees);
    $(".updateduration").val(response.duration);

}



function deleteCourseSingle(cid){
    $.ajax({
        type      : 'DELETE',
        url       : '/course/deletecourse?cid='+cid,
        success   : function(result){
            $(".actionmsg").show();
            $(".message").text("Course Deleted Successfully!")
            $(".actionmsg").delay("slow").fadeIn();
            setInterval(function () {         $(".actionmsg").hide();     }, 3000);
            getCourse();
        }
    });
}

function updatesinglecourse(){
    var course = {
        cid       :  $(".updatecid").val(),
        code      :  $(".updatecode").val(),
        course    :  $(".updatecourse").val(),
        fees      :  $(".updatefees").val(),
        duration  :  $(".updateduration").val()
    } 

    $.ajax({
        type          : 'POST',
        url           : '/course/updatecourse',
        data          : JSON.stringify(course),
        datatype      : "json",
        contentType   : 'application/json;charset = utf-8',
        success   : function(result){
			$(".actionmsg").show();
            $(".message").text("Course Updated Successfully!")
            $(".actionmsg").delay("slow").fadeIn();
            setInterval(function () {         $(".actionmsg").hide();     }, 5000);
            getCourse();
        }
    });
}


$(".savesinglecourse").on('click',function(){
    savesinglecourse();
})

function savesinglecourse(){
    var course = {
		code      :  $(".code").val(),
        course    :  $(".course").val(),
        fees      :  $(".fees").val(),
        duration  :  $(".duration").val()
    } 

    $.ajax({
        type          : 'POST',
        url           : '/course/savecourse',
        data          : JSON.stringify(course),
        datatype      : "json",
        contentType   : 'application/json;charset = utf-8',
        success   : function(result){
			$(".actionmsg").show();
            $(".message").text("Course Saved Successfully!")
            $(".actionmsg").delay("slow").fadeIn();
            setInterval(function () {         $(".actionmsg").hide();     }, 5000);
            getCourse();
        }
    });
}

