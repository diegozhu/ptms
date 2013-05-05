i18n.init();
var model = i18n.model("bus");
model.data = {};

$(function(){
	try{
		model.data.buses = ptms.Bus.getAll();
	}catch(e){
		ptms.error(e);
	}
	
	ko.applyBindings(model);
	
	$("#buss_list li a").click(function(e){
		local.one("bus-id",$(this).attr("bus-id"));
	});
	
	ptms.commonInit();
});