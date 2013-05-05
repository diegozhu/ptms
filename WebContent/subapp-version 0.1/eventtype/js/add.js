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
			}catch(e){
				alert(e);
			}
			alert("add ok");
			window.history.back();
		}
		return false;
	});
	
	ptms.commonInit();
});