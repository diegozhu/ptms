i18n.init();
var model = i18n.model("line");
model.data = {}

$(function(){

	model.data.line = new ptms.Line(local("line"));
	
	ko.applyBindings(model);
	
	$("#btnCancel").click(function(e){
		window.history.back();
	});

	$("#btnSave").click(function(e){
		var line = model.data.line;
		line.name = $("#input-name").val();
		line.description = $("#input-description").val();
		line.timespace = $("#input-timespace").val();
		line.starttime = $("#input-starttime").val();
		line.endtime = $("#input-endtime").val();
		try{
			line.update();
			ptms.success("update ok!");
			local.one("line-id",line.id);
			window.history.back();
		}catch(e){
			ptms.error(e);
		}
	});

	$("#btnCancel").on("click",function(){
		local.one("line-id",model.data.line.id);
		window.history.back();
		return false;
	});
	
	ptms.commonInit();
});