i18n.init();
var model = i18n.model("events");
model.data = {};

$(function(){

	try{
		model.data.events = new ptms.Events(local("events"));
	
		model.data.users = ptms.User.getAll();
		model.data.buses = ptms.Bus.getAll();
		model.data.lines = ptms.Line.getAll();
		model.data.stations = ptms.Station.getAll();
		model.data.eventtypes = ptms.Eventtype.getAll();
		
	}catch(e){
		ptms.error(e);
	}
	
	var events = model.data.events;	
	
	ko.applyBindings(model);
	
	$('.dropdown-toggle').dropdown();

	$("#userList ul li a").on("click",function(e){
		$("#events_user").attr("user-id",$(this).attr('user-id')).html($(this).html());
	});
	
	$("#lineList ul li a").on("click",function(e){
		$("#events_line").attr("line-id",$(this).attr('line-id')).html($(this).html());
	});
	
	$("#stationList ul li a").on("click",function(e){
		$("#events_station").attr("station-id",$(this).attr('station-id')).html($(this).html());
	});
	
	$("#busList ul li a").on("click",function(e){
		$("#events_bus").attr("bus-id",$(this).attr('bus-id')).html($(this).html());
	});
	
	$("#eventtypeList ul li a").on("click",function(e){
		$("#events_eventtype").attr("eventtype-id",$(this).attr('eventtype-id')).html($(this).html());
	});
	
	
	$("#btnSave").click(function(e){
		events.name = $("#input-name").val();
		events.description = $("#input-description").val();
		events.user = new ptms.User({id :$("#events_user").attr("user-id")});
		events.line = new ptms.User({id : $("#events_line").attr("line-id")});
		events.station = new ptms.User({id : $("#events_station").attr("station-id")});
		events.bus = new ptms.User({id : $("#events_bus").attr("bus-id")});
		events.eventype = new ptms.User({id : $("#events_eventype").attr("eventype-id")});
		try{
			events.update();
			ptms.success("update ok!");
			local.one("events-id",events.id);
			window.history.back();
		}catch(e){
			ptms.error(e);
		}		
	});
	
	$("#btnCancel").on("click",function(){
		local.one("events-id",model.data.events.id);
		window.history.back();
		return false;
	});
	
	ptms.commonInit();
});