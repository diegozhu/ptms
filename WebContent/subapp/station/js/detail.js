i18n.init();
var model = i18n.model("station");
model.data = {}

$(function(){

	try{
		model.data.station = ptms.Station.get(parseInt(local("station-id")));
	}catch(e){
		ptms.error(e);
	}
		
	ko.applyBindings(model);
	
	$("#btnEidt").click(function(e){
		local.one("station",model.data.station);
		window.location = "edit.html";
	});
	ptms.commonInit();

});