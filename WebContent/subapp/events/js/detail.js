i18n.init();
var model = i18n.model("events");
model.data = {};

$(function(){

	try{
		model.data.events = ptms.Events.get(local("events-id"));
	}catch(e){
		alert(e);
	}
	
	ko.applyBindings(model);

	$("#btnEidt").click(function(e){
		local.one("events", model.data.events);
		window.location = "edit.html";
	});
	ptms.commonInit();
});