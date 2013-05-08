var ptms = {};

ptms.debug = false;
ptms.host = "localhost:8080/ptms/";

// for new Object , if the arg is an Object , constructor will just return ,
//	so , we create a new Object by JSON not by new Object() 
ptms.clone = function(obj){
	return JSON.parse(JSON.stringify(obj));
}

ptms.getObj = function(obj){
	return JSON.stringify(obj);
}