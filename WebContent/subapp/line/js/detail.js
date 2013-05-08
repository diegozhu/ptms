i18n.init();
var model = i18n.model("line");
model.data = {}

$(function(){

	try{
        model.data.line = ptms.Line.get(parseInt(local("line-id")));
        model.data.line.stations = model.data.line.getStations();
        model.data.line.buses = model.data.line.getBuses();
	}catch(e){
		ptms.error(e);
	}
		
	ko.applyBindings(model);
	
	$("#btnEidt").click(function(e){
		local.one("line",model.data.line);
		window.location = "edit.html";
	});
    
    $("#relatedStation li a").click(function(e){
		local.one("line-id",model.data.line.id);
		window.location = "../station/list.html";
	});
    
    $("#relatedBus li a").click(function(e){
		local.one("line-id",model.data.line.id);
		window.location = "../bus/list.html";
	});
    
    $("#btnDelete").click(function(e){
        try{
            ptms.Line.del(model.data.line.id);
        }catch(e){
            ptms.error(e);
        }
    });
	ptms.commonInit();

});