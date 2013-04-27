ptms.User = function(arg1){
	if(typeof arg1 == "string"){
		arg1 = JSON.parse(arg1);
	}

	this.id = arg1.id;
	this.name = arg1.name;
	this.createtime = arg1.createtime || (new Date()).toString();
	this.description = arg1.description;
	this.workid = arg1.workid;
	this.personalid = arg1.personalid;
	this.address = arg1.address;
	this.cellphone = arg1.cellphone;
	this.gender = arg1.gender;
	this.jointime = arg1.jointime;
	this.resigntime = arg1.resigntime;
	this.role = new ptms.Role(arg1.role);
	return this;
}

ptms.User.prototype.get = function(arg1,arg2,arg3){
	var result;
	var obj = { type: "get" }
	if(typeof arg1 != "undefined" && typeof arg2 != "undefined"){
		// get users from arg1 to arg2
		obj.url = "user/f/" + arg1 + "/t/" + arg2;
	}else if(typeof agr1 != "undefined"){
		// arg1 as user id
		obj.url = "user/" + arg1;
	}else{
		// get all users list
		obj.url = "user";
	}
	ptms.url(obj);
	var array = JSON.parse($.ajax(obj).responseText);
	result = new Array();
	for(var i in array){
		result.push(new ptms.User(array[i]));
	}
	return result;
}

ptms.User.get = ptms.User.prototype.get;

ptms.User.prototype.add = function(){
	if(!this instanceof ptms.User){
		throw "not ptms.User type , could not invoke add();";
	}
	var userData = JSON.stringify(this);
	var obj = {
		 type: "post",
		 url : "user",
		 data : userData
	}
	ptms.url(obj);	
	var res = JSON.parse($.ajax(obj).responseText);
	return new ptms.User(res);
}
ptms.User.prototype.update = function(id){}
ptms.User.prototype.event = function(id){}
ptms.User.prototype.status = function(id){}
