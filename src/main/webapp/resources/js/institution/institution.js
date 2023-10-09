
$(".actionmsg").show();
$(".actionmsg").delay("slow").fadeIn();
setInterval(function () {
	$(".actionmsg").hide();     
	}, 5000);

getInstitution();


setInterval(function () {	
	if( $(".updatetutioncenter").val() && $(".updateaddress").val() && $(".updatemobile").val() &&  $(".updatephone").val() &&
        $(".updateemail").val() && $(".updatedistrict").val() && $(".updatestate").val() && $(".updatepincode").val() ){
		$('#updatesingleinstitution').prop('disabled', false);
		$(".required").hide();
	}else{
		$(".required").show();
		$('#updatesingleinstitution').prop('disabled', true);
	}
	
if( $(".tutioncenter").val() && $(".address").val() && $(".mobile").val() &&  $(".phone").val() &&
        $(".email").val() && $(".district").val() && $(".state").val() && $(".pincode").val() ){
		$('#savesingleinstitution').prop('disabled', false);
		$(".required").hide();
	}else{
		$(".required").show();
		$('#savesingleinstitution').prop('disabled', true);
	}
}, 1000);


function getInstitution(){
    $.ajax({
        type      : 'GET',
        url       : '/institution/getallinstitution',
        success   : function(result){
            getInstitutionSuccess(result);
        }
    });
}

function getInstitutionSuccess(response){

    $(".tbody").empty();
    var row = '';
    var tr = '';
    var c = 0;
    $.each(response, function(key,inv){
		c = c + 1;
        tr = '<tr>'+
              '<td>'+c+'</td>'+
     //       '<td>'+inv.tutioncenterId +'</td>'+
              '<td>'+inv.tutioncenter +'</td>'+
              '<td>'+inv.address +'</td>'+
     //       '<td>'+inv.mobile +'</td>'+
              '<td>'+inv.phone +'</td>'+
     //       '<td>'+inv.email +'</td>'+
              '<td>'+inv.district +'</td>'+
     //       '<td>'+inv.state +'</td>'+
     //       '<td>'+inv.pincode +'</td>'+
              '<td><button type="button" class="btn btn-outline-secondary" onclick="showmodal('+inv.tutioncenterId+')" data-bs-toggle="modal" data-bs-target="#updateModal"><img src="/resources/images/pencil-square.svg" style="height:24px;width:24px;"> Edit</button>     '+
			  '<button type="button" class="btn btn-outline-danger" onclick="deleteInstitutionSingle('+inv.tutioncenterId+')" ><img src="/resources/images/trash.svg" style="height:24px;width:24px;"> Delete</button><td>'+
			  '</tr>'
        row = row + tr ;
    })
    $(".tbody").append(row);
}

function showmodal(tutioncenterId){
	getInstitutionSingle(tutioncenterId);		
}



function getInstitutionSingle(tutioncenterId){

    $.ajax({
        type      : 'GET',
        url       : '/institution/getinstitution?tutioncenterId='+tutioncenterId,
        success   : function(result){
            getInstitutionSingleSuccess(result);
        }
    });
}


function getInstitutionSingleSuccess(response){

    $(".updatetutioncenterId").val(response.tutioncenterId);
    $(".updatetutioncenter").val(response.tutioncenter);
    $(".updateaddress").val(response.address);
    $(".updatemobile").val(response.mobile);
    $(".updatephone").val(response.phone);
    $(".updateemail").val(response.email);
    $(".updatedistrict").val(response.district);
    $(".updatestate").val(response.state);
    $(".updatepincode").val(response.pincode);			     

}



function deleteInstitutionSingle(tutioncenterId){
    $.ajax({
        type      : 'DELETE',
        url       : '/institution/deleteinstitution?tutioncenterId='+tutioncenterId,
        success   : function(result){
            $(".actionmsg").show();
            $(".message").text("Institution Deleted Successfully!")
            $(".actionmsg").delay("slow").fadeIn();
            setInterval(function () {         $(".actionmsg").hide();     }, 3000);
            getInstitution();
        }
    });
}


function updatesingleinstitution(){
    var institution = {
        tutioncenterId    	:  $(".updatetutioncenterId").val(),
        tutioncenter      	:  $(".updatetutioncenter").val(),
        address    			:  $(".updateaddress").val(),
        mobile      		:  $(".updatemobile").val(),
        phone  				:  $(".updatephone").val(),
        email  				:  $(".updateemail").val(),
        district 			:  $(".updatedistrict").val(),
        state    			:  $(".updatestate").val(),
        pincode         	:  $(".updatepincode").val(),
    } 

    $.ajax({
        type          : 'POST',
        url           : '/institution/updateinstitution',
        data          : JSON.stringify(institution),
        datatype      : "json",
        contentType   : 'application/json;charset = utf-8',
        success   : function(result){
			$(".actionmsg").show();
            $(".message").text("Institution Updated Successfully!")
            $(".actionmsg").delay("slow").fadeIn();
            setInterval(function () {         $(".actionmsg").hide();     }, 5000);
            getInstitution();
        }
    });
}


$(".savesingleinstitution").on('click',function(){
    savesingleinstitution();
})

function savesingleinstitution(){
    var institution = {
        tutioncenterId    	:  $(".tutioncenterId").val(),
        tutioncenter      	:  $(".tutioncenter").val(),
        address    			:  $(".address").val(),
        mobile      		:  $(".mobile").val(),
        phone  				:  $(".phone").val(),
        email  				:  $(".email").val(),
        district 			:  $(".district").val(),
        state    			:  $(".state").val(),
        pincode         	:  $(".pincode").val(),
    } 

    $.ajax({
        type          : 'POST',
        url           : '/institution/updateinstitution',
        data          : JSON.stringify(institution),
        datatype      : "json",
        contentType   : 'application/json;charset = utf-8',
        success   : function(result){
			$(".actionmsg").show();
            $(".message").text("Institution Saved Successfully!")
            $(".actionmsg").delay("slow").fadeIn();
            setInterval(function () {         $(".actionmsg").hide();     }, 5000);
            getInstitution();
        }
    });
}

