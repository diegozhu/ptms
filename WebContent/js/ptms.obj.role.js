ptms.Role = function(arg1){
	if(typeof arg1 == "string"){
		arg1 = JSON.parse(arg1);
	}
	
	this.id = arg1.id;
	this.name = arg1.name;
	this.createtime = arg1.createtime || (new Date()).toString();
	this.description = arg1.description;
	return this;
}

ptms.Role.get = function(arg1){
	var result;	
	var obj = {
		 type: "get",
	}
	if(typeof agr1 != "undefined"){
		// arg1 as user id
		obj.url = "role/" + arg1;
		ptms.url(obj);
		var res = JSON.parse($.ajax(obj).responseText);
		result = new ptms.Role(res);
	}else{
		// get all users list
		obj.url = "role";
		ptms.url(obj);
		var array = JSON.parse($.ajax(obj).responseText);
		result = new Array();
		for(var i in array){
			result.push(new ptms.Role(array[i]));
		}
	}
	return result;
}

ptms.Role.prototype.add = function(){
	if(!this instanceof ptms.Role){
		throw "not ptms.Role type , could not invoke add();";
	}
	var roleData = JSON.stringify(this);
	var obj = {
		 type: "post",
		 url : "role",
		 data : roleData
	}
	ptms.url(obj);	
	var res = JSON.parse($.ajax(obj).responseText);
	return new ptms.Role(res);
}

ptms.Role.prototype.del = function(){
	if(!this instanceof ptms.Role){
		throw "not ptms.Role type , could not invoke update();";
	}
	var result;	
	var obj = {
		type: "delete",
	}
	obj.url = "role/" + this.id;
	ptms.url(obj);
	result = JSON.parse($.ajax(obj).responseText);
	return result;
}

ptms.Role.prototype.update = function(){
	if(!this instanceof ptms.Role){
		throw "not ptms.Role type , could not invoke status();";
	}
	var roleData = JSON.stringify(this);
	var obj = {
		 type: "put",
		 url : "role/"+this.id,
		 data : roleData,
		 success: function(msg){ 
			console.log(msg);
		 },
		error : function(msg){
		   console.log(msg);
		 }
	}
	ptms.url(obj);	
	var res = JSON.parse($.ajax(obj).responseText);
	return new ptms.Role(res);
}

ptms.Role.prototype.sync = function(){
	if(!this instanceof ptms.Role){
		throw "not ptms.Role type , could not invoke status();";
	}
	return ptms.Role.get(this.id);
}