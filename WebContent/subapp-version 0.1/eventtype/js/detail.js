i18n.init();
var model = i18n.model();
model.data = {}

$(function(){

	try{
		model.data.eventtype = ptms.Eventtype.get(local("eventtype-id"));
	}catch(e){
		alert(e);
	}
		
	ko.applyBindings(model);
	
	$("#btnEidt").click(function(e){
		local("eventtype",model.data.eventtype);
		window.location = "edit.html";
	});

	ptms.commonInit();
});