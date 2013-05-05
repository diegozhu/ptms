i18n.init();
var model = i18n.model();
model.data = {}

$(function(){
	
	try{
		model.data.roles = ptms.Role.get();			
	}catch(e){
		alert(e);
	}
	
	ko.applyBindings(model);
	
	$("#roles_list li a").on("click",function(e){
		local("role-id",$(this).attr("role-id"));
	});
	ptms.commonInit();
});