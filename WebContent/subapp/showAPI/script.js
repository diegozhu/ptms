$(function(){
	
	function w(str){
		document.write(str);
	}
	
	function wl(str){
		w(str+"<br />");
	}

	for(objName in ptms){
		if(typeof ptms[objName].api != "undefined" && objName != "Obj"){
			w(objName);
			var apis = ptms[objName].api;
			w("<table>")
			for(apiName in apis){
				var api = apis[apiName];
				if(typeof api == "object"){
					w( "<tr><td>"+ apiName +"</td><td>"+ api.pattern +"</td><td>"+ api.type +"</td><td>"+api.generate+"</td><td>"+api.classMethod+"</td></tr>");
				}
			}
			w("</table>");
		}
	}
	
	
});