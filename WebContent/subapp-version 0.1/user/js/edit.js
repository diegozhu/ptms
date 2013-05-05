i18n.init();
var model = i18n.model();
model.data = {};

$(function(){

	model.data.user = new ptms.User(local("user"));
	model.data.roles = JSON.parse(local("roles"));
	
	var user = model.data.user;	
	
	ko.applyBindings(model);
	
	$('.dropdown-toggle').dropdown();

	$("#roleList ul li a").on("click",function(e){
		$("#user_role").attr("role-id",$(this).attr('role-id')).html($(this).html());
	});
	
	$("#btnSave").click(function(e){
		user.name = $("#input-name").val();
		user.description = $("#input-description").val();
		user.workid = $("#input-workid").val();
		user.personalid = $("#input-personalid").val();
		user.address = $("#input-address").val();
		user.cellphone = $("#input-cellphone").val();
		user.gender = $("#input-gender-male")[0].checked ? 0 : 1;
		user.jointime = $("#input-jointime").val();
		user.resigntime = $("#input-resigntime").val();
		user.role = ptms.Role.get($("#user_role").attr("role-id"));
		user.password = $("#input-password").val();
		console.log(user);

		try{
			user.add();
		}catch(e){
			alert(e);
		}
		alert("update ok!");
		window.history.back();
	});

	ptms.commonInit();
});