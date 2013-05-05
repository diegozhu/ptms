i18n.init();
var model = i18n.model("station");

$(function(){

	ko.applyBindings(model);
	
	$("#btnSave").click(function(e){
		var station = {};
		station.name = $("#input-name").val();
		station.description = $("#input-description").val();
		station.periority = $("#input-periority").val();
		station.locationX = $("#input-locationX").val();
		station.locationY = $("#input-locationY").val();
		station.availble = $("#input-availble").val();
		if(station.name == ""){
			ptms.warn("name could not be null!");
		}else{
			try{
				(new ptms.Station(station)).add();
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