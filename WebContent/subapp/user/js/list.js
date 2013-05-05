i18n.init();
var model = i18n.model("user");
model.data = {};

$(function(){
	try{
		model.data.users = ptms.User.getAll();
	}catch(e){
		ptms.error(e);
	}
	
	ko.applyBindings(model);
	
	$("#users_list li a").click(function(e){
		local.one("user-id",$(this).attr("user-id"));
	});
	
	ptms.commonInit();
});