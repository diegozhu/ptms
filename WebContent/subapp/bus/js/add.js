i18n.init();
var model = i18n.model("bus");
model.data = {};

$(function(){
	
	try{
		model.data.users = ptms.User.getAll();
		model.data.lines = ptms.Line.getAll();
	}catch(e){
		ptms.error(e);
	}
	ko.applyBindings(model);
		
	$('.dropdown-toggle').dropdown();
	
	$("#userList ul li a").click(function(e){
		$("#bus_user").attr("user-id",$(this).attr('user-id')).html($(this).html());
	});
	
	$("#lineList ul li a").click(function(e){
		$("#bus_line").attr("line-id",$(this).attr('line-id')).html($(this).html());
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
		bus.line = new ptms.Line({id:$("#bus_line").attr("line-id")});

		if(bus.name == ""){
			ptms.warn("name could not be null!");
		}else{
			try{
				var bus = new ptms.Bus(bus);
				var res = bus.checkFields();
				if(res.res){
					bus.add();
				}else{
					ptms.alert(res.msg);
				};
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