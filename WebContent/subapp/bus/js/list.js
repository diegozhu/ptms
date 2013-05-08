i18n.init();
var model = i18n.model("bus");
model.data = {};

$(function(){
    
    var line_id = local("line-id");

	try{
        if(line_id != null){
            var line = new ptms.Line({id:line_id});
            model.data.buses = line.buses();
        }else{
            model.data.buses = ptms.Bus.getAll();
        }		
	}catch(e){
		ptms.error(e);
	}
	
	ko.applyBindings(model);
	
	$("#buss_list li a").click(function(e){
		local.one("bus-id",$(this).attr("bus-id"));
	});
	
	ptms.commonInit();
});