i18n.init();
var model = i18n.model("line");
model.data = {}

$(function(){
	
	try{
		model.data.lines = ptms.Line.getAll();	
	}catch(e){
		ptms.error(e);
	}
	
	ko.applyBindings(model);
	
	$("#lines_list li a").on("click",function(e){
		local.one("line-id",$(this).attr("line-id"));
	});
	ptms.commonInit();
});