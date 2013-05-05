// defination of objs
// field in Obj Object is common field , every object got a copy but not shared the same one.
ptms.Obj = function(arg1){
	arg1 = arg1 ? arg1 : new Object();
	if(typeof arg1 == "string"){
		arg1 = JSON.parse(arg1);
	}
	if(typeof arg1.id == "string"){
		this.id = parseInt(arg1.id);
	}else{
		this.id = arg1.id || 0;
	}
	this.name = arg1.name || "";
	this.createtime = arg1.createtime || (new Date()).toLocaleString(),
	this.description = arg1.description || "";
	return arg1;
}

ptms.Role = function(arg1){
	arg1 = ptms.Obj.call(this,arg1);
	return this;
}

ptms.User = function(arg1){
	arg1 = ptms.Obj.call(this,arg1);
	this.workid = arg1.workid || "";
	this.personalid = arg1.personalid || "";
	this.address = arg1.address || "";
	this.cellphone = arg1.cellphone || "";
	this.password = arg1.password || "";
	this.passwordAgain = this.password || "";
	this.gender = arg1.gender || "0";
	this.jointime = arg1.jointime || (new Date()).toLocaleString(),
	this.resigntime = arg1.resigntime || "";
	this.role = new ptms.Role(arg1.role);
	this.api = ptms.User.api;
	return this;
}

ptms.Bus = function(arg1){
	arg1 = ptms.Obj.call(this,arg1);
	this.type = arg1.type　|| "";
	this.lefttime = arg1.lefttime || "";
	this.user = new ptms.User(arg1.user);
	this.maxpassager = arg1.maxpassager ||　45;
	this.purchasetime = arg1.purchasetime || "";
	return this;
}

ptms.Station = function(arg1){
	arg1 = ptms.Obj.call(this,arg1);
	this.periority = arg1.periority || 0;
	this.locationX = arg1.locationX || 0;
	this.locationY = arg1.locationY || 0;
	this.availble = arg1.availble || true;
	return this;
}

ptms.Events = function(arg1){
	arg1 = ptms.Obj.call(this,arg1);
	this.bus = new ptms.Bus(arg1.bus);
	this.user = new ptms.User(arg1.user);
	this.line = new ptms.Line(arg1.line);
	this.station = new ptms.Station(arg1.station);
	this.eventtype = new ptms.Eventtype(arg1.eventtype);
	return this;
}

ptms.Line = function(arg1){
	arg1 = ptms.Obj.call(this,arg1);
	this.timespace = arg1.timespace || "";
	this.starttime = arg1.starttime || "";
	this.endtime = arg1.endtime || "";
	return this;
}

ptms.Eventtype = function(arg1){
	arg1 = ptms.Obj.call(this,arg1);
	return this;
}


// defination of apis
// this apis is in common , every obj got one copy but not share the same one;
ptms.Obj.api = {
	getAll 	: {	pattern : "",			type : "get"  , generate : true , classMethod : true },
	get 	: {	pattern : "{id}",		type : "get"  , generate : true	, classMethod : true },
	getSome	: {	pattern : "user/f/{n}/t/{t}",		type : "get"  , generate : true	, classMethod : true },
	del		: {	pattern : "del/{id}",	type : "get"  ,	generate : true	, classMethod : true },	
	update 	: {	pattern : "",			type : "put"  ,	generate : true	, classMethod : false , dataFromThis : true },
	add 	: {	pattern : "",			type : "post" , generate : true , classMethod : false , dataFromThis : true }
}

// below is specific api for different objects
ptms.Eventtype.api = {
	base : "Eventtype/"
}

ptms.Line.api = {
	base : "Line/",
	events : {	pattern : "{this.id}/event/",type : "get", classMethod : false }
}

ptms.Events.api = {
	base : "Events/"
}

ptms.Station.api = {
	base : "Station/",
	events : {	pattern : "{this.id}/event/",type : "get", classMethod : false }
}

ptms.User.api = {
	base : "User/",
	events : {	pattern : "{this.id}/event/",type : "get", classMethod : false }
}

ptms.Role.api = {
	base : "Role/",
}

ptms.Bus.api = {
	base : "Bus/",
	events : {	pattern : "{this.id}/event/",type : "get", classMethod : false }
}

// handler api extensions
ptms.registApi(ptms.Bus,ptms.Obj.api);
ptms.registApi(ptms.Role,ptms.Obj.api);
ptms.registApi(ptms.User,ptms.Obj.api);
ptms.registApi(ptms.Line,ptms.Obj.api);
ptms.registApi(ptms.Events,ptms.Obj.api);
ptms.registApi(ptms.Station,ptms.Obj.api);
ptms.registApi(ptms.Eventtype,ptms.Obj.api);


ptms.registApi(ptms.Bus);
ptms.registApi(ptms.Role);
ptms.registApi(ptms.User);
ptms.registApi(ptms.Line);
ptms.registApi(ptms.Events);
ptms.registApi(ptms.Station);
ptms.registApi(ptms.Eventtype);


ptms.Test = {};
ptms.Test2 = {};

ptms.fields = {
	timespace : { type : Number , limit : { max : 45 , min : 15 } 	, def : 0},
	starttime : { type: String , limit : { max : 45 , min : 15 } 	, def : 0},
}

ptms.fields2 = {
	endtime : {  type : String , limit : { max : 45 , min : 15 } 	, def : 0},
	timespace : {  type : Number , limit : { max : 45 , min : 15 } 	, def : 0}
}

/**
*		@warning this method will return an conctruction function;
*/
function applyField(fields){
	var fieldList = fields;
	// c is constructor of objs
	var c =  function(arg1){
				arg1 = ptms.Obj.call(this,arg1);
				for(fieldName in fieldList){
					var fieldDefination = fieldList[fieldName];
					if(typeof arg1[fieldName] != "undefined"){
						this[fieldName] = arg1[fieldName];
					}else{
						var defaultValue = fieldDefination["def"];
						this[fieldName] = typeof defaultValue == "object" ? ptms.clone(defaultValue) : defaultValue;
					}
				}
				return this;
			}

	c.prototype.checkFields = function(){
		var result = true;
		for(fieldName in this){
			var fieldValue = this[fieldName];
			var fieldDefination = fieldList[fieldName];
			if(typeof fieldDefination.limit == "object"){
				if(fieldDefination.limit.max == undefined || fieldDefination.limit.max == undefined){
					throw "unknow typeof limit defination , only support Array(emun) and object like { max : value , min : value } , defined in :" + fieldDefination;
				}
				if(fieldValue > fieldDefination.limit.max){
					result = false
					result.msg = "value of:"+ fieldName +" is bigger than the max value defined in " + fieldDefination;
					break;
				}else if(fieldValue < fieldDefination.limit.min){
					result = false;
					result.msg = "value of:"+ fieldName +" is smaller than the max value defined in " + fieldDefination;
					break;
				}else{
					// value in limit, ok ,check next field;
					// do nothing;
				}
			}else if(typeof fieldDefination.limit == "array"){
				// check if the value is in the Array
				var inArray = false;
				for(i in array){
					if(fieldValue == array[i]){
						inArray = true;
						break;
					}
				}
				result = inArray ? true : false;
				if(result == false){
					result.msg = "value of:"+ fieldName +" is not in the given value array(emun) "+ array +" defined in " + fieldDefination;
				}else{
					// do nothing , check next field , value in limit ok
				}
			}else{
				throw "unknow typeof limit defination , only support Array(emun) and {} , defined in :" + fieldDefination;
			}
			
		}
		return result;
	}
	
	return c;
}

ptms.Test = applyField(ptms.fields)
ptms.Test2 = applyField(ptms.fields2)

ptms.Test.api = {
	base : "Test/",
}

ptms.Test2.api = {
	base : "Test2/",
}

ptms.registApi(ptms.Test,ptms.Obj.api);
ptms.registApi(ptms.Test);

ptms.registApi(ptms.Test2,ptms.Obj.api);
ptms.registApi(ptms.Test2);



