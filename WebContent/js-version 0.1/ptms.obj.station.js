ptms.Station = function(arg1){
	if(typeof arg1 == "string"){
		arg1 = JSON.parse(arg1);
	}
	
	this.id = arg1.id;
	this.name = arg1.name;
	this.createtime = arg1.createtime || (new Date()).toLocaleString(),
	this.description = arg1.description;
	this.periority = arg1.periority
	this.locationX = arg1.locationX
	this.locationY  = arg1.locationY
	this.availble  = arg1.availble
	
	return this;
}

ptms.Station.get = function(arg1){
	var result;	
	var obj = {
		 type: "get"
	}
	console.log("arg1:"+arg1);
	if(typeof arg1 == "undefined" || arg1 == ""){
		// get all users list
		obj.url = "Station";
		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		console.log(response);
		if(response.status != "ok"){
			throw response.code;
		}
		result = new Array();
		for(var i in response.data){
			result.push(new ptms.Station(response.data[i]));
		}
	}else{
		// arg1 as user id
		obj.url = "Station/" + arg1;
		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		if(response.status != "ok"){
			throw response.code;
		}	
		result = new ptms.Station(response.data);
	}
	return result;
}


ptms.Station.del = function(arg1){
	var result;	
	var obj = {
		 type: "get"
	}
	console.log("arg1:"+arg1);
	// arg1 as user id
	obj.url = "Station/del/" + arg1;
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}	
	result = new ptms.Station(response.data);

	return result;
}

ptms.Station.prototype.add = function(){
	if(!this instanceof ptms.Station){
		throw "not ptms.Station type , could not invoke add();";
	}
	var StationData = JSON.stringify(this);
	var obj = {
		 type: "post",
		 url : "Station",
		 data : StationData
	}
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}
	return new ptms.Station(response.data);
}

ptms.Station.prototype.del = function(){
	if(!this instanceof ptms.Station){
		throw "not ptms.Station type , could not invoke del();";
	}
	var result;	
	var obj = {
		type: "get",
	}
	obj.url = "Station/del/" + this.id;
	ptms.url(obj);
	result = JSON.parse($.ajax(obj).responseText);
	if(result.status != "ok"){
		throw response.code;
	}
	return result;
}

ptms.Station.prototype.update = function(){
	if(!this instanceof ptms.Station){
		throw "not ptms.Station type , could not invoke status();";
	}
	var StationData = JSON.stringify(this);
	var obj = {
		 type: "put",
		 url : "Station/"+this.id,
		 data : StationData
	}
	ptms.url(obj);	
	var res = JSON.parse($.ajax(obj).responseText);
	if(res.status != "ok"){
		throw response.code;
	}
	return new ptms.Station(res);
}

ptms.Station.prototype.sync = function(){
	if(!this instanceof ptms.Station){
		throw "not ptms.Station type , could not invoke status();";
	}
	return ptms.Station.get(this.id);
}
