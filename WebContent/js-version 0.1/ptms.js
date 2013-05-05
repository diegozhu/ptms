var ptms = {};

ptms.debug = false;

ptms.url = function(obj){
	
	var api = obj.url;
	var host = ptms.debug ? "../../fakedata/api/" : "http://localhost:8080/ptms/api/";
	
	obj.cache = obj.cache || false;
	obj.async = obj.async || false;
    obj.contentType = "text/plain";
	
	obj.url = host + api +  ( ptms.debug ? "." + obj.type + ".json" : "");
	
	console.log(obj.type+":"+obj.url);
	return obj;
}

Object.prototype.toString = function(){
	return JSON.stringify(this);
}

ptms.commonInit = function(){
	$(".btnback").click(function(){
		window.history.back();
	});

}