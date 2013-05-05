i18n.init();
var model = i18n.model("bus");
model.data = {};

$(function(){

	try{
		model.data.bus = ptms.Bus.get(local("bus-id"));
	}catch(e){
		alert(e);
	}
	
	ko.applyBindings(model);

	$("#btnEidt").click(function(e){
		local.one("bus", model.data.bus);
		window.location = "edit.html";
	});
	$("#relatedStatus").click(function(e){
		local.one("bus-id",model.data.bus.id);
		window.location = "status.html"
	});
	$("#relatedEvents").click(function(e){
		local.one("bus-id",model.data.bus.id);
		window.location = "../events/list.html"
	});
	ptms.commonInit();
});