i18n.init();
var model = i18n.model("line");
model.data = {}

$(function(){

	try{
		model.data.line = ptms.Line.get(parseInt(local("line-id")));
	}catch(e){
		ptms.error(e);
	}
		
	ko.applyBindings(model);
	
	$("#btnEidt").click(function(e){
		local.one("line",model.data.line);
		window.location = "edit.html";
	});
	ptms.commonInit();

});