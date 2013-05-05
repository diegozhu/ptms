i18n.init();
var model = i18n.model();

$(function(){

	ko.applyBindings(model);
	
	$("#btnAdd").click(function(e){
		var obj = {
			name : $("#input-name").val(),
			description : $("#input-description").val()
		}
		if(obj.name == ""){
			alert("name could not be null!");
		}else{
			var eventtype = new ptms.Eventtype(obj);
			try{
				eventtype.add();
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