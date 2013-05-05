ptms.Role = function(arg1){
	if(typeof arg1 == "string"){
		arg1 = JSON.parse(arg1);
	}
	
	this.id = arg1.id;
	this.name = arg1.name;
	this.createtime = arg1.createtime || (new Date()).toLocaleString(),
	this.description = arg1.description;
	return this;
}



ptms.Role.get = function(arg1){
	var result;	
	var obj = {	 type: "get" };
	
	if(typeof arg1 == "undefined" || arg1 == ""){
		// get all users list
		obj.url = "Role";
		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		console.log(response);
		if(response.status != "ok"){
			throw response.code;
		}
		result = new Array();
		for(var i in response.data){
			result.push(new ptms.Role(response.data[i]));
		}	
	}else{
		// arg1 as user id
		obj.url = "Role/" + arg1;

		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		if(response.status != "ok"){
			throw response.code;
		}	
		result = new ptms.Role(response.data);
	}
	return result;
}

ptms.Role.del = function(arg1){
	var result;	
	var obj = {	 type: "get" };
	// arg1 as user id
	obj.url = "Role/del/" + arg1;
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}	
	result = new ptms.Role(response.data);
	return result;
}

ptms.Role.prototype.add = function(){
	if(!this instanceof ptms.Role){
		throw "not ptms.Role type , could not invoke add();";
	}
	var RoleData = JSON.stringify(this);
	var obj = {
		 type: "post",
		 url : "Role",
		 data : RoleData
	}
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}
	return new ptms.Role(response.data);
}

ptms.Role.prototype.del = function(){
	if(!this instanceof ptms.Role){
		throw "not ptms.Role type , could not invoke del();";
	}
	ptms.Role.del(this.id);
}

ptms.Role.prototype.update = function(){
	if(!this instanceof ptms.Role){
		throw "not ptms.Role type , could not invoke status();";
	}
	var RoleData = JSON.stringify(this);
	var obj = {
		 type: "put",
		 url : "Role/"+this.id,
		 data : RoleData
	}
	ptms.url(obj);	
	var res = JSON.parse($.ajax(obj).responseText);
	if(res.status != "ok"){
		throw res.code;
	}
	return new ptms.Role(res);
}

ptms.Role.prototype.sync = function(){
	if(!this instanceof ptms.Role){
		throw "not ptms.Role type , could not invoke status();";
	}
	return ptms.Role.get(this.id);
}