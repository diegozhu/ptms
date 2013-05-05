ptms.User = function(arg1){
	if(typeof arg1 == "string"){
		arg1 = JSON.parse(arg1);
	}

	this.id = arg1.id;
	this.name = arg1.name;
	this.createtime = arg1.createtime || (new Date()).toLocaleString(),
	this.description = arg1.description;
	this.workid = arg1.workid;
	this.personalid = arg1.personalid;
	this.address = arg1.address;
	this.cellphone = arg1.cellphone;
	this.password = arg1.password;
	this.passwordAgain = this.password;
	this.gender = arg1.gender;
	this.jointime = arg1.jointime || (new Date()).toLocaleString(),
	this.resigntime = arg1.resigntime;
	this.role = arg1.role ? new ptms.Role(arg1.role) : ptms.Role.get(1);
	return this;
}

ptms.User.get = function(arg1){
	var result;	
	var obj = {
		 type: "get"
	}
	console.log("arg1:"+arg1);
	
	if(typeof arg1 == "undefined" || arg1 == ""){
		// get all users list
		obj.url = "User";
		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		console.log(response);
		if(response.status == "ok"){
			result = new Array();
			for(var i in response.data){
				result.push(new ptms.User(response.data[i]));
			}
		}else{
			throw response.code;
		}	
	}else{
		// arg1 as user id
		obj.url = "User/" + arg1;

		ptms.url(obj);
		var response = JSON.parse($.ajax(obj).responseText);
		if(response.status != "ok"){
			throw response.code;
		}	
		result = new ptms.User(response.data);
		console.log(result);
	}
	return result;
}


ptms.User.del = function(arg1){
	var result;	
	var obj = {
		 type: "get"
	}
	console.log("arg1:"+arg1);
	// arg1 as user id
	obj.url = "User/del/" + arg1;
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}	
	result = new ptms.User(response.data);
	return result;
}

ptms.User.prototype.add = function(){
	if(!this instanceof ptms.User){
		throw "not ptms.User type , could not invoke add();";
	}
	var UserData = JSON.stringify(this);
	var obj = {
		 type: "post",
		 url : "User",
		 data : UserData
	}
	ptms.url(obj);
	var response = JSON.parse($.ajax(obj).responseText);
	if(response.status != "ok"){
		throw response.code;
	}
	return new ptms.User(response.data);
}

ptms.User.prototype.del = function(){
	if(!this instanceof ptms.User){
		throw "not ptms.User type , could not invoke del();";
	}
	var result;	
	var obj = {
		type: "get",
	}
	obj.url = "User/del/" + this.id;
	ptms.url(obj);
	result = JSON.parse($.ajax(obj).responseText);
	if(result.status != "ok"){
		throw response.code;
	}
	return result;
}

ptms.User.prototype.update = function(){
	if(!this instanceof ptms.User){
		throw "not ptms.User type , could not invoke status();";
	}
	var UserData = JSON.stringify(this);
	var obj = {
		 type: "put",
		 url : "User/"+this.id,
		 data : UserData
	}
	ptms.url(obj);	
	var res = JSON.parse($.ajax(obj).responseText);
	if(res.status != "ok"){
		throw response.code;
	}
	return new ptms.User(res);
}

ptms.User.prototype.sync = function(){
	if(!this instanceof ptms.User){
		throw "not ptms.User type , could not invoke status();";
	}
	return ptms.User.get(this.id);
}