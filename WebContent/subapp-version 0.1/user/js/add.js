i18n.init();
var model = i18n.model();
model.data = {};

roleListClick = function(obj){
	$("#user_role").attr("role-id",$(obj).attr('role-id')).html($(obj).html());
}

$(function(){
	
	ko.applyBindings(model);
		
	$('.dropdown-toggle').dropdown();
	
	$("#btnAdd").click(function(e){
		var user = {};
		user.name = $("#inputName").val();
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
		
		if(user.name == ""){
			alert("name could not be null!");
		}else{
			try{
				(new ptms.User(user)).add();
				alert("add ok");
			}catch(e){
				alert(e);
			}
		}			
		return false;
	});
	ptms.commonInit();	
});