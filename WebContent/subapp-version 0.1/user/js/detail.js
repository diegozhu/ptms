i18n.init();
var model = i18n.model();
model.data = {};

$(function(){

	try{
		model.data.user = ptms.User.get(local("user-id"));
	}catch(e){
		alert(e);
	}
	
	ko.applyBindings(model);
		
	$("#btnEidt").click(function(e){
		local("user", model.data.user);
		local("roles",ptms.Role.get());
		window.location = "edit.html";
	});
	
	ptms.commonInit();
});