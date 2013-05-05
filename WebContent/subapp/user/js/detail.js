i18n.init();
var model = i18n.model("user");
model.data = {};

$(function(){

	try{
		model.data.user = ptms.User.get(local("user-id"));
	}catch(e){
		alert(e);
	}

	ko.applyBindings(model);
		
	$("#btnEidt").click(function(e){
		local.one("user", model.data.user);
		local("roles",ptms.Role.getAll());
		window.location = "edit.html";
	});
	
	$("#relatedEvents").click(function(e){
		local.one("user-id",model.data.user.id);
		window.location = "../events/list.html"
	});
	ptms.commonInit();
});