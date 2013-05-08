i18n.init();
var model = i18n.model("role");
model.data = {}

$(function(){

	try{
		model.data.role = ptms.Role.get(parseInt(local("role-id")));
	}catch(e){
		ptms.error(e);
	}
		
	ko.applyBindings(model);
	
	$("#btnEidt").click(function(e){
		local.one("role",model.data.role);
		window.location = "edit.html";
	});
    
    $("#btnDelete").click(function(e){
        try{
            ptms.Role.del(model.data.role.id);
        }catch(e){
            ptms.error(e);
        }
    });
    
	ptms.commonInit();

});