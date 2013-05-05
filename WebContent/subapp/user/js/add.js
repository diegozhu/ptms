i18n.init();
var model = i18n.model("user");
model.data = {};

$(function(){
	
	try{
		model.data.roles = ptms.Role.getAll();
	}catch(e){
		ptms.error(e);
	}
	ko.applyBindings(model);
		
	$('.dropdown-toggle').dropdown();
	
	$("#roleList ul li a").click(function(e){
		$("#user_role").attr("role-id",$(this).attr('role-id')).html($(this).html());
	});
	
	$("#btnAdd").click(function(e){
		var user = {};
		user.name = $("#input-name").val();
		user.description = $("#input-description").val();
		user.workid = $("#input-workid").val();
		user.personalid = $("#input-personalid").val();
		user.address = $("#input-address").val();
		user.cellphone = $("#input-cellphone").val();
		user.gender = $("#input-gender-male")[0].checked ? 0 : 1;
		user.jointime = $("#input-jointime").val();
		user.resigntime = $("#input-resigntime").val();
		user.role = new ptms.Role({id:$("#user_role").attr("role-id")});
		user.password = $("#input-password").val();

		if(user.name == ""){
			ptms.warn("name could not be null!");
		}else{
			try{
				(new ptms.User(user)).add();
				ptms.success("add ok");
				window.history.back();
			}catch(e){
				ptms.error(e);
			}
		}			
		return false;
	});
	ptms.commonInit();	
});