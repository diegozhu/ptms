i18n.init();
var model = i18n.model("role");
model.data = {}

$(function(){

	model.data.role = new ptms.Role(local("role"));
	
	ko.applyBindings(model);
	
	$("#btnSave").click(function(e){
		var role = model.data.role;
		role.name = $("#input-name").val();
		role.description = $("#input-description").val();
		try{
			role.update();
			ptms.success("update ok!");
			local.one("role-id",role.id);
			window.history.back();
		}catch(e){
			ptms.error(e);
		}
	});
	
	
	$("#btnCancel").on("click",function(){
		local.one("role-id",model.data.role.id);
		window.history.back();
		return false;
	});
	
	ptms.commonInit();
	
});