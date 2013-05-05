i18n.init();
var model = i18n.model();
model.data = {};

$(function(){
	try{
		model.data.users = ptms.User.get();			
	}catch(e){
		alert(e);
	}
	
	ko.applyBindings(model);
	
	$("#users_list li a").click(function(e){
		local("user-id",$(this).attr("user-id"));
	});
	
	ptms.commonInit();
});