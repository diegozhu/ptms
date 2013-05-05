i18n.init();
var model = i18n.model("station");
model.data = {}

$(function(){

	model.data.station = new ptms.Station(local("station"));
	
	ko.applyBindings(model);
	
	$("#btnCancel").click(function(e){
		window.history.back();
	});

	$("#btnSave").click(function(e){
		var station = model.data.station;
		station.name = $("#input-name").val();
		station.description = $("#input-description").val();
		station.periority = $("#input-periority").val();
		station.locationX = $("#input-locationX").val();
		station.locationY = $("#input-locationY").val();
		station.availble = $("#input-availble").val();
		try{
			station.update();
			ptms.success("update ok!");
			local.one("station-id",station.id);
			window.history.back();
		}catch(e){
			ptms.error(e);
		}
	});
	
	$("#btnCancel").on("click",function(){
		local.one("station-id",model.data.station.id);
		window.history.back();
		return false;
	});
	
	ptms.commonInit();
});