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
		}catch(e){
			alert(e);
		}
		alert("update ok!");
		window.history.back();
	});

	ptms.commonInit();
});