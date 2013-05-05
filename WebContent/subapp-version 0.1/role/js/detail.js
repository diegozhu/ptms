i18n.init();
var model = i18n.model();
model.data = {}

$(function(){

	try{
		model.data.role = ptms.Role.get(local("role-id"));
	}catch(e){
		alert(e);
	}
		
	ko.applyBindings(model);
	
	$("#btnEidt").click(function(e){
		local("role",model.data.role);
		window.location = "edit.html";
	});

	ptms.commonInit();
});