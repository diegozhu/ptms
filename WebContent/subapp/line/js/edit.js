i18n.init();
var model = i18n.model("line");
model.data = {}

$(function(){

	model.data.line = new ptms.Line(local("line"));
    var mystations = model.data.line.getStations();
    var mybuses = model.data.line.getBuses();
    
    var otherstations = new Array();
    var otherbuses = new Array();
    
    var allStations = ptms.Station.getAll();
    var allBuses = ptms.Bus.getAll();
    
	for(i in allStations){
        var has = false;
        for(j in mystations){
            if(allStations[i].id == mystations[j].id){
                has = true;
                break;
            }
        }
        if(!has){
            otherstations.push(allStations[i]);
        }
    }
    
    for(i in allBuses){
        var has = false;
        for(j in mybuses){
            if(allBuses[i].id == mybuses[j].id){
                has = true;
                break;
            }
        }
        if(!has){
            otherbuses.push(allBuses[i]);
        }
    }
    
    model.data.otherstations = otherstations;
    model.data.mystations = mystations;
    model.data.otherbuses = otherbuses;
    model.data.mybuses = mybuses;
    
	ko.applyBindings(model);
	
	$("#btnCancel").click(function(e){
		window.history.back();
	});

	$("#btnSave").click(function(e){
		var line = model.data.line;
		line.name = $("#input-name").val();
		line.description = $("#input-description").val();
		line.timespace = $("#input-timespace").val();
		line.starttime = $("#input-starttime").val();
		line.endtime = $("#input-endtime").val();
		try{
			line.update();
			ptms.success("update ok!");
			local.one("line-id",line.id);
			window.history.back();
		}catch(e){
			ptms.error(e);
		}
	});

	$("#btnCancel").on("click",function(){
		local.one("line-id",model.data.line.id);
		window.history.back();
		return false;
	});
    
    $("#mystations li a").click(function(e){
       model.data.line.delStation($(this).attr('station-id'));
       local.one("line",model.data.line);
       location.reload();
    });
    
    $("#otherstations li a").click(function(e){
        model.data.line.addStation($(this).attr('station-id'));
        local.one("line",model.data.line);
        location.reload();
    });
    
    $("#mybuses li a").click(function(e){
       model.data.line.delBus($(this).attr('bus-id'));
       local.one("line",model.data.line);
       location.reload();
    });
    
    $("#otherbuses li a").click(function(e){
        model.data.line.addBus($(this).attr('bus-id'));
        local.one("line",model.data.line);
        location.reload();
    });
	
	ptms.commonInit();
});