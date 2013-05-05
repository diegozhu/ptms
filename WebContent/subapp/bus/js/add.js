i18n.init();
var model = i18n.model("bus");
model.data = {};

$(function(){
	
	try{
		model.data.users = ptms.User.getAll();
	}catch(e){
		ptms.error(e);
	}
	ko.applyBindings(model);
		
	$('.dropdown-toggle').dropdown();
	
	$("#userList ul li a").click(function(e){
		$("#bus_user").attr("user-id",$(this).attr('user-id')).html($(this).html());
	});
	 	
	$("#btnAdd").click(function(e){
		var bus = {};
		bus.name = $("#input-name").val();
		bus.description = $("#input-description").val();
		bus.maxpassager = $("#input-maxpassager").val();
		bus.type = $("#input-type").val();
		bus.purchasetime = $("#input-purchasetime").val();
		bus.lefttime = $("#input-lefttime").val();
		bus.user = new ptms.User({id:$("#bus_user").attr("user-id")});

		if(bus.name == ""){
			ptms.warn("name could not be null!");
		}else{
			try{
				(new ptms.Bus(bus)).add();
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