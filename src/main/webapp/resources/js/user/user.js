
$(".actionmsg").show();
$(".actionmsg").delay("slow").fadeIn();
setInterval(function () {
	$(".actionmsg").hide();     
	}, 5000);

getUser();
getInstitutionDropdown();


setInterval(function () {	
	if( $(".updatename").val() && $("#updatetutioncenterid").val() && $(".updaterole").val() &&  $(".updateusername").val() &&
        $(".updatepassword").val() && $(".updateaddress").val() && $(".updatephone").val() && $(".updatemobile").val() && $(".updateemail").val() ){
		$('#updatesingleuser').prop('disabled', false);
		$(".required").hide();
	}else{
		$(".required").show();
		$('#updatesingleuser').prop('disabled', true);
	}
	
    if( $(".name").val() && $("#tutioncenterid").val() && $(".role").val() &&  $(".username").val() &&
        $(".password").val() && $(".address").val() && $(".phone").val() && $(".mobile").val() && $(".email").val() ){
		$('#savesingleuser').prop('disabled', false);
		$(".required").hide();
	}else{
		$(".required").show();
		$('#savesingleuser').prop('disabled', true);
	}
}, 1000);


function getUser(){
    $.ajax({
        type      : 'GET',
        url       : '/user/getallUser',
        success   : function(result){
            getUserSuccess(result);
        }
    });
}

function getUserSuccess(response){

    $(".tbody").empty();
    var row = '';
    var tr = '';
    var c = 0;
    $.each(response, function(key,inv){
		c = c + 1;
        tr = '<tr>'+
              '<td>'+c+'</td>'+
   //  	      '<td>'+inv.uid +'</td>'+
   //         '<td>'+inv.usdid +'</td>'+
              '<td>'+inv.tutioncenter +'</td>'+
     	      '<td>'+inv.name +'</td>'+
              '<td>'+inv.role +'</td>'+
              '<td>'+inv.address +'</td>'+
              '<td>'+inv.phone +'</td>'+
   //         '<td>'+inv.mobile +'</td>'+
              '<td>'+inv.email +'</td>'+
              '<td><button type="button" class="btn btn-outline-secondary" onclick="showmodal('+inv.uid+')" data-bs-toggle="modal" data-bs-target="#updateModal"><img src="/resources/images/pencil-square.svg" style="height:24px;width:24px;"> Edit</button>  '+
			  '<button type="button" class="btn btn-outline-danger" onclick="deleteUserSingle('+inv.uid+')" ><img src="/resources/images/trash.svg" style="height:24px;width:24px;"> Delete</button><td>'+
			  '</tr>'
        row = row + tr ;
    })
    $(".tbody").append(row);
}


function showmodal(uid){
	getUserSingle(uid);		
}

function getUserSingle(uid){

    $.ajax({
        type      : 'GET',
        url       : '/user/getuser?uid='+uid,
        success   : function(result){
            getUserSingleSuccess(result);
        }
    });
}


function getUserSingleSuccess(response){

    $(".updateuid").val(response.uid);
    $(".updateusdid").val(response.usdid);
    $(".updatename").val(response.name);
    $(".updatetutioncenterid").val(response.tutioncenterid);
    $(".updaterole").val(response.role);
    $(".updateusername").val(response.username);
    $(".updatepassword").val(response.password);
    $(".updateaddress").val(response.address);
    $(".updatephone").val(response.phone);			   
    $(".updatemobile").val(response.mobile);	
    $(".updateemail").val(response.email);	
    
    getInstitutionUpdatedDropdown(response.tutioncenteridstr);  

}



function deleteUserSingle(uid){
    $.ajax({
        type      : 'DELETE',
        url       : '/user/deleteuser?uid='+uid,
        success   : function(result){
            $(".actionmsg").show();
            $(".message").text("User Deleted Successfully!")
            $(".actionmsg").delay("slow").fadeIn();
            setInterval(function () {         $(".actionmsg").hide();     }, 3000);
            getUser();
        }
    });
}


function updatesingleuser(){
    var UserDTO = {
        uid    				:  $(".updateuid").val(),
        usdid      			:  $(".updateusdid").val(),
        name    			:  $(".updatename").val(),
        tutioncenteridstr   :  $(".updatetutioncenterid").val(),
        role  				:  $(".updaterole").val(),
        username  			:  $(".updateusername").val(),
        password 			:  $(".updatepassword").val(),
        address    			:  $(".updateaddress").val(),
        phone         		:  $(".updatephone").val(),
        mobile    			:  $(".updatemobile").val(),
        email         		:  $(".updateemail").val(),
    } 

    $.ajax({
        type          : 'POST',
        url           : '/user/updateuser',
        data          : JSON.stringify(UserDTO),
        datatype      : "json",
        contentType   : 'application/json;charset = utf-8',
        success   : function(result){
			$(".actionmsg").show();
            $(".message").text("User Updated Successfully!")
            $(".actionmsg").delay("slow").fadeIn();
            setInterval(function () {         $(".actionmsg").hide();     }, 5000);
            getUser();
        }
    });
}


$(".savesingleuser").on('click',function(){
    savesingleuser();
})


function savesingleuser(){
    var UserDTO = {
    //  uid    				:  $(".uid").val(),
    //  usdid      			:  $(".usdid").val(),
        name    			:  $(".name").val(),
        tutioncenteridstr   :  $("#tutioncenterid").val(),
        role  				:  $("#role").val(),
        username  			:  $(".username").val(),
        password 			:  $(".password").val(),
        address    			:  $(".address").val(),
        phone         		:  $(".phone").val(),
        mobile    			:  $(".mobile").val(),
        email         		:  $(".email").val(),
    } 

    $.ajax({
        type          : 'POST',
        url           : '/user/saveuser',
        data          : JSON.stringify(UserDTO),
        datatype      : "json",
        contentType   : 'application/json;charset = utf-8',
        success   : function(result){
			$(".actionmsg").show();
            $(".message").text("User Saved Successfully!")
            $(".actionmsg").delay("slow").fadeIn();
            setInterval(function () {         $(".actionmsg").hide();     }, 5000);
            getUser();
        }
    });
}


function getInstitutionDropdown(){
    $.ajax({
        type      : 'GET',
        url       : '/institution/getallinstitution',
        success   : function(result){
            getInstitutionDropdownSuccess(result);
        }
    });
}

function getInstitutionDropdownSuccess(response){

    $("#tutioncenterid").empty();
    $("#updatetutioncenterid").empty();
    
    var opt = '';
    var ss = '';
    $.each(response, function(key,inv){
		ss = '<option value="'+inv.tutioncenterId+'">'+inv.tutioncenter+'</option>';
		opt = opt + ss;
    })
    $("#tutioncenterid").append(opt);
    $("#updatetutioncenterid").append(opt);

}

function getInstitutionUpdatedDropdown(tutioncenterId){
    $.ajax({
        type      : 'GET',
        url       : '/institution/getallinstitution',
        success   : function(result){
		    $("#updatetutioncenterid").empty();
		    var opt = '';
		    var ss = '';
		    $.each(result, function(key,inv){
			if(tutioncenterId == inv.tutioncenterId){
				ss = '<option value="'+inv.tutioncenterId+'" Selected="true">'+inv.tutioncenter+'</option>';
				opt = opt + ss;
			}else{
				ss = '<option value="'+inv.tutioncenterId+'">'+inv.tutioncenter+'</option>';
				opt = opt + ss;
			}
		    })
		    $("#updatetutioncenterid").append(opt);
		}
    });
}


