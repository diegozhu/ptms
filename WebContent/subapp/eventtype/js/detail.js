i18n.init();
var model = i18n.model();
model.data = {}

$(function(){

	try{
		model.data.eventtype = ptms.Eventtype.get(local("eventtype-id"));
	}catch(e){
		ptms.error(e);
	}
		
	ko.applyBindings(model);
	
	$("#btnEidt").click(function(e){
		local.one("eventtype",model.data.eventtype);
		window.location = "edit.html";
	});

    
    $("#btnDelete").click(function(e){
        try{
            ptms.Eventtype.del(model.data.eventtype.id);
        }catch(e){
            ptms.error(e);
        }
    });
	ptms.commonInit();
});