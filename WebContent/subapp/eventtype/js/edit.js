i18n.init();
var model = i18n.model();
model.data = {}

$(function(){

	model.data.eventtype = new ptms.Eventtype(local("eventtype"));
	
	ko.applyBindings(model);
	
	$("#btnCancel").click(function(e){
		window.location.back();
	});

	$("#btnSave").click(function(e){
		model.data.eventtype.name = $("#input-name").val();
		model.data.eventtype.description = $("#input-description").val();
		try{
			model.data.eventtype.update();
			ptms.success("update ok!");
			var eventtype = model.data.eventtype;
			local.one("eventtype-id",eventtype.id);
			window.history.back();
		}catch(e){
			ptms.error(e);
		}
	});

	$("#btnCancel").on("click",function(){
		local.one("eventtype-id",model.data.eventtype.id);
		window.history.back();
		return false;
	});
	
	ptms.commonInit();
});