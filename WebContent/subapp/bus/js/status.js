i18n.init();
var model = i18n.model("bus");
model.data = {};

$(function(){
	try{
		model.data.status = (new ptms.Bus( { id : local("bus-id") } )).getAllStatus();
	}catch(e){
		ptms.error(e);
	}
	
	ko.applyBindings(model);
	
	$("#status_list li a").click(function(e){
		local.one("status-id",$(this).attr("status-id"));
	});
	
	ptms.commonInit();
});