i18n.init();
var model = i18n.model("line");

$(function(){

	ko.applyBindings(model);
	
	$("#btnSave").click(function(e){
		var line = {};
		line.name = $("#input-name").val();
		line.description = $("#input-description").val();
		line.timespace = $("#input-timespace").val();
		line.starttime = $("#input-starttime").val();
		line.endtime = $("#input-endtime").val();
		if(line.name == ""){
			ptms.warn("name could not be null!");
		}else{
			try{
				(new ptms.Line(line)).add();
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