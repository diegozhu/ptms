i18n.init();
var model = i18n.model("role");

$(function(){

	ko.applyBindings(model);
	
	$("#btnAdd").click(function(e){
		var role = {};
		role.name = $("#input-name").val();
		role.description = $("#input-description").val();
		
		if(role.name == ""){
			ptms.warn("name could not be null!");
		}else{
			try{
				(new ptms.Role(role)).add();
				ptms.success("add ok");
				window.history.back();
			}catch(e){
				ptms.error(e);
			}			
		}
		return false;
	});
	
	ptms.commonInit();
});