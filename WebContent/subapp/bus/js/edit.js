i18n.init();
var model = i18n.model("bus");
model.data = {};

$(function(){

	model.data.bus = new ptms.Bus(local("bus"));
	model.data.users = JSON.parse(local("users"));
	
	var bus = model.data.bus;	
	
	ko.applyBindings(model);
	
	$('.dropdown-toggle').dropdown();

	$("#userList ul li a").on("click",function(e){
		$("#bus_user").attr("user-id",$(this).attr('user-id')).html($(this).html());
	});
	
	$("#btnSave").click(function(e){
		bus.name = $("#input-name").val();
		bus.description = $("#input-description").val();
		bus.maxpassager = $("#input-maxpassager").val();
		bus.type = $("#input-type").val();
		bus.purchasetime = $("#input-purchasetime").val();
		bus.lefttime = $("#input-lefttime").val();
		bus.user = new ptms.User({id:$("#bus_user").attr("user-id")});

		try{
			bus.update();
			ptms.success("update ok!");
			local.one("bus-id",bus.id);
			window.history.back();
		}catch(e){
			ptms.error(e);
		}		
	});

	$("#btnCancel").on("click",function(){
		local.one("bus-id",model.data.bus.id);
		window.history.back();
		return false;
	});
	
	ptms.commonInit();
});