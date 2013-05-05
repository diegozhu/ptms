i18n.init();
var model = i18n.model();
model.data = {}

$(function(){

	model.data.role = new ptms.Role(local("role"));
	
	ko.applyBindings(model);
	
	$("#btnCancel").click(function(e){
		window.location.back();
	});

	$("#btnSave").click(function(e){
		model.data.role.name = $("#input-name").val();
		model.data.role.description = $("#input-description").val();
		try{
			model.data.role.update();
		}catch(e){
			alert(e);
		}
		alert("update ok!");
		window.history.back();
	});

	ptms.commonInit();
});