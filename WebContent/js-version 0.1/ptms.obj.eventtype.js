ptms.Eventtype = function(arg1){
	if(typeof arg1 == "string"){
		arg1 = JSON.parse(arg1);
	}
	
	this.id = arg1.id;
	this.name = arg1.name;
	this.createtime = arg1.createtime || (new Date()).toLocaleString(),
	this.description = arg1.description;
	return this;
}

ptms.Eventtype.get = function(arg1){
	var result;	
	var obj = {
		 type: "get"
	}
	
	if(typeof arg1 == "undefined" || arg1 == ""){
		// get all users list
		obj.url = "Eventtype";
		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		console.log(response);
		if(response.status == "ok"){
			result = new Array();
			for(var i in response.data){
				result.push(new ptms.Eventtype(response.data[i]));
			}
		}else{
			throw response.code;
		}	
	}else{
		// arg1 as user id
		obj.url = "Eventtype/" + arg1;

		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		if(response.status != "ok"){
			throw response.code;
		}	
		result = new ptms.Eventtype(response.data);
	}
	return result;
}

ptms.Eventtype.del = function(arg1){
	var result;	
	var obj = {
		 type: "get"
	}
	console.log("arg1:"+arg1);
	// arg1 as user id
	obj.url = "Eventtype/del/" + arg1;
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}	
	result = new ptms.Eventtype(response.data);
	return result;
}




ptms.Eventtype.getAll = function(arg1){
	var result;	
	var obj = {
		 type: "get"
	}
	console.log("arg1:"+arg1);
	// get all users list
	obj.url = "Eventtype";
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	console.log(response);
	if(response.status == "ok"){
		result = new Array();
		for(var i in response.data){
			result.push(new ptms.Eventtype(response.data[i]));
		}
	}else{
		throw response.code;
	}	
	return result;
}

ptms.Eventtype.prototype.add = function(){
	if(!this instanceof ptms.Eventtype){
		throw "not ptms.Eventtype type , could not invoke add();";
	}
	var EventtypeData = JSON.stringify(this);
	var obj = {
		 type: "post",
		 url : "Eventtype",
		 data : EventtypeData
	}
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}
	return new ptms.Eventtype(response.data);
}

ptms.Eventtype.prototype.del = function(){
	if(!this instanceof ptms.Eventtype){
		throw "not ptms.Eventtype type , could not invoke del();";
	}
	var result;	
	var obj = {
		type: "get",
	}
	obj.url = "Eventtype/del/" + this.id;
	ptms.url(obj);
	result = JSON.parse($.ajax(obj).responseText);
	if(result.status != "ok"){
		throw result.code;
	}
	return result;
}

ptms.Eventtype.prototype.update = function(){
	if(!this instanceof ptms.Eventtype){
		throw "not ptms.Eventtype type , could not invoke status();";
	}
	var EventtypeData = JSON.stringify(this);
	var obj = {
		 type: "put",
		 url : "Eventtype/"+this.id,
		 data : EventtypeData
	}
	ptms.url(obj);	
	var res = JSON.parse($.ajax(obj).responseText);
	if(res.status != "ok"){
		throw res.code;
	}
	return new ptms.Eventtype(res);
}

ptms.Eventtype.prototype.sync = function(){
	if(!this instanceof ptms.Eventtype){
		throw "not ptms.Eventtype type , could not invoke status();";
	}
	return ptms.Eventtype.get(this.id);
}