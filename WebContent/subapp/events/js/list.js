i18n.init();
var model = i18n.model("events");
model.data = {};

$(function(){

	var eventsList;
	var user_id = local("user-id");
	var bus_id = local("bus-id");

	try{
		if(user_id != null){
			eventsList = (new ptms.User({id:user_id})).events();
		}else if(bus_id != null){
			eventsList = (new ptms.Bus({id:bus_id})).events();
		}else{
			eventsList = ptms.Events.getAll();
		}
	}catch(e){
		ptms.error(e);
	}

	model.data.eventss = eventsList;	

	ko.applyBindings(model);
	
	$("#eventss_list li a").click(function(e){
		local.one("events-id",$(this).attr("events-id"));
	});
	
	ptms.commonInit();
});