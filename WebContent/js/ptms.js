var ptms = {};

ptms.debug = false;

Object.prototype.toString = function(){
	return JSON.stringify(this);
}

// for new Object , if the arg is an Object , constructor will just return ,
//	so , we create a new Object by JSON not by new Object() 
ptms.clone = function(obj){
	return JSON.parse(JSON.stringify(obj));
}