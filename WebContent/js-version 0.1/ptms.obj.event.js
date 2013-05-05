ptms.Event = function(arg1){
	if(typeof arg1 == "string"){
		arg1 = JSON.parse(arg1);
	}
/*	
bus
station
line
*/
	
	this.id = arg1.id;
	this.name = arg1.name;
	this.createtime = arg1.createtime || (new Date()).toLocaleString();
	this.description = arg1.description;
	this.eventtype = arg1.eventtype ? new ptms.Eventtype(arg1.eventtype) : ptms.Eventtype.get(1);
	return this;
}

ptms.Event.get = function(arg1){
	var result;	
	var obj = {
		 type: "get"
	}
	console.log("arg1:"+arg1);
	if(typeof arg1 == "undefined" || arg1 == ""){
		// get all events list
		obj.url = "Events";
		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		console.log(response);
		if(response.status != "ok"){
			throw response.code;
		}
		result = new Array();
		for(var i in response.data){
			result.push(new ptms.Event(response.data[i]));
		}
	}else{
		// arg1 as event id
		obj.url = "Events/" + arg1;
		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		if(response.status != "ok"){
			throw response.code;
		}	
		result = new ptms.Event(response.data);
	}
	return result;
}


ptms.Event.del = function(arg1){
	var result;	
	var obj = {
		 type: "get"
	}
	console.log("arg1:"+arg1);
	// arg1 as event id
	obj.url = "Events/del/" + arg1;
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}	
	result = new ptms.Event(response.data);
	return result;
}

ptms.Event.prototype.add = function(){
	if(!this instanceof ptms.Event){
		throw "not ptms.Event type , could not invoke add();";
	}
	var EventData = JSON.stringify(this);
	var obj = {
		 type: "post",
		 url : "Events",
		 data : EventData
	}
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}
	return new ptms.Event(response.data);
}

ptms.Event.prototype.del = function(){
	if(!this instanceof ptms.Event){
		throw "not ptms.Event type , could not invoke del();";
	}
	var result;	
	var obj = {
		type: "get",
	}
	obj.url = "Events/del/" + this.id;
	ptms.url(obj);
	result = JSON.parse($.ajax(obj).responseText);
	if(result.event != "ok"){
		throw response.code;
	}
	return result;
}

ptms.Event.prototype.update = function(){
	if(!this instanceof ptms.Event){
		throw "not ptms.Event type , could not invoke event();";
	}
	var EventData = JSON.stringify(this);
	var obj = {
		 type: "put",
		 url : "Events/"+this.id,
		 data : EventData
	}
	ptms.url(obj);	
	var res = JSON.parse($.ajax(obj).responseText);
	if(res.event != "ok"){
		throw response.code;
	}
	return new ptms.Event(res);
}

ptms.Event.prototype.sync = function(){
	if(!this instanceof ptms.Event){
		throw "not ptms.Event type , could not invoke event();";
	}
	return ptms.Event.get(this.id);
}