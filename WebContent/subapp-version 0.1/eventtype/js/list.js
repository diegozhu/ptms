i18n.init();
var model = i18n.model();
model.data = {}

$(function(){
	
	try{
		model.data.eventtypes = ptms.Eventtype.get();			
	}catch(e){
		alert(e);
	}
	
	ko.applyBindings(model);
	
	$("#eventtypes_list li a").on("click",function(e){
		local("eventtype-id",$(this).attr("eventtype-id"));
	});
	ptms.commonInit();
});