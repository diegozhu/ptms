i18n.init();
var model = i18n.model("events");
model.data = {};

$(function(){
	
	try{
		model.data.users = ptms.User.getAll();
		model.data.buses = ptms.Bus.getAll();
		model.data.lines = ptms.Line.getAll();
		model.data.stations = ptms.Station.getAll();
		model.data.eventtypes = ptms.Eventtype.getAll();
		
	}catch(e){
		ptms.error(e);
	}
	ko.applyBindings(model);
		
	$('.dropdown-toggle').dropdown();
	
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
	
	$("#btnAdd").click(function(e){
		var events = {};
		events.name = $("#input-name").val();
		events.description = $("#input-description").val();
		events.user = new ptms.User({id : $("#events_user").attr("user-id")});
		events.bus = new ptms.Bus({id :$("#events_bus").attr("bus-id")});
		events.line = new ptms.Line({id :$("#events_line").attr("line-id") });
		events.station = new ptms.Station({id :$("#events_station").attr("station-id")});
		events.eventtype = new ptms.Eventtype({id :$("#events_eventtype").attr("eventtype-id")});
		
		if(events.name == ""){
			ptms.warn("name could not be null!");
		}else{
			try{
				(new ptms.Events(events)).add();
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