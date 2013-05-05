i18n.init();
var model = i18n.model("role");
model.data = {}

$(function(){
	
	try{
		model.data.roles = ptms.Role.getAll();
	}catch(e){
		ptms.error(e);
	}
	
	ko.applyBindings(model);
	
	$("#roles_list li a").on("click",function(e){
		local.one("role-id",$(this).attr("role-id"));
	});
	ptms.commonInit();
});