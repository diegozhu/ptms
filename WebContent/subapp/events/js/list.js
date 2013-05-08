i18n.init();
var model = i18n.model("events");
model.data = {};

$(function(){

	var eventsList;
	var user_id = local("user-id");
	var bus_id = local("bus-id");
	var line_id = local("line-id");

	var catogray = window.location.href;
	catogray = catogray.substring(catogray.indexOf(".html")+6);
	console.log("catogray+"+catogray);

	try{
		if(user_id != null){
			eventsList = (new ptms.User({id:user_id})).events();
		}else if(bus_id != null){
			eventsList = (new ptms.Bus({id:bus_id})).events();
		}else if(line_id != null){
			eventsList = (new ptms.Line({id:line_id})).events();
		}else if(catogray != undefined || catogray != ""){
			eventsList = ptms.Events[catogray]();
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