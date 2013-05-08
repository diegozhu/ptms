i18n.init();
var model = i18n.model("station");
model.data = {}

$(function(){
	
    var line_id = local("line-id");
    
	try{
        if(line_id != null){
            var line = new pmts.Line({id:line_id});
            model.data.stations = line.stations(); 
        }else{
            model.data.stations = ptms.Station.getAll();	
        }
		
	}catch(e){
		ptms.error(e);
	}
	
	ko.applyBindings(model);
	
	$("#stations_list li a").on("click",function(e){
		local.one("station-id",$(this).attr("station-id"));
	});
	ptms.commonInit();
});