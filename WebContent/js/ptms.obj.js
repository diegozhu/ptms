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
		this.id = arg1.id || 1;
	}
	this.name = arg1.name || "";
	this.createtime = arg1.createtime || (new Date()).toLocaleString(),
	this.description = arg1.description || "";
	return arg1;
}

ptms.fields = {};
ptms.fields.obj = {
	id 			: 	{ type: Number , limit : { max : 99999999999 , min : 0 } 	, def : 0},
	name 		: 	{ type: String , limit : { max : 45 , min : 5 } 			, def : 0},
	createtime 	: 	{ type: String , limit : { max : 45 , min : 5 } 			, def : 0},
	description : 	{ type: String , limit : { max : 45 , min : 0 } 			, def : 0},
}

ptms.fields.Role = {}
ptms.Role = ptms.generatConstructor(ptms.fields.Role);

ptms.fields.Eventtype = {}
ptms.Eventtype = ptms.generatConstructor(ptms.fields.Eventtype);

ptms.fields.Station = {
	periority : { type : Number , limit : { max : 40 , min : 0 } ,def : 0 },
	locationX : { type : Number , limit : { max : 99999999999 , min : 0 } ,def : 0 },
	locationY : { type : Number , limit : { max : 99999999999 , min : 0 } ,def : 0 },
	availble  :	{ type : Boolean , limit : [true,false] 				 ,def : true }
}
ptms.Station = ptms.generatConstructor(ptms.fields.Station);

ptms.fields.Line = { 
	timespace : { type : String , limit : { max : 45 , min : 10 } ,def : "" },
	starttime : { type : String , limit : { max : 45 , min : 10 } ,def : "" },
	endtime   : { type : String , limit : { max : 45 , min : 10 } ,def : "" }
}
ptms.Line = ptms.generatConstructor(ptms.fields.Line);



ptms.fields.User = {
	workid 			:{ type:String	 , limit:{ max:45,min:10},	def:0},
	personalid 		:{ type:String	 , limit:{ max:45,min:10},	def:0},
	address 		:{ type:String	 , limit:{ max:45,min:10},	def:0},
	cellphone 		:{ type:String	 , limit:{ max:45,min:10},	def:0},
	password 		:{ type:String	 , limit:{ max:45,min:10},	def:0}, 
	passwordAgain 	:{ type:String	 , limit:{ max:45,min:10},	def:0},
	gender 			:{ type:Boolean	 , limit:{ max:45,min:10},	def:0},
	jointime 		:{ type:String	 , limit:{ max:45,min:10},	def:0}, 
	resigntime 		:{ type:String	 , limit:{ max:45,min:10},	def:0},
	role 			:{ type:ptms.Role						 ,	def:new ptms.Role()}
}
ptms.User = ptms.generatConstructor(ptms.fields.User);

ptms.fields.Bus = {	
	type 		: { type : String 	, limit : {max : 45 ,min:10 } , def : "45座客车" },
	lefttime 	: { type : String 	, limit : {max : 45 ,min:10 } , def : "" },
	user 		: { type : ptms.User							  , def : new ptms.User() },
	maxpassager : { type : Number 	, limit : {max : 45 ,min:10 } , def : 45 },
	purchasetime: { type : String 	, limit : {max : 45 ,min:10 } , def : "" },
}
ptms.Bus = ptms.generatConstructor(ptms.fields.Bus);

ptms.fields.BusStatus = {
	wheelpressure	: { type : Number 	, limit : {max : 99999999999 ,min:0 } , def : 0 },
	temperature 	: { type : Number 	, limit : {max : 99999999999 ,min:0 } , def : 0 },
	gasleft			: { type : Number 	, limit : {max : 99999999999 ,min:0 } , def : 0 },
	locationx 		: { type : Number 	, limit : {max : 99999999999 ,min:0 } , def : 0 },
	locationy		: { type : Number 	, limit : {max : 99999999999 ,min:0 } , def : 0 },
	bus				: { type : ptms.Bus										  , def : new ptms.Bus() },
}
ptms.BusStatus = ptms.generatConstructor(ptms.fields.BusStatus);

ptms.fields.Events = { 
	bus 		: { type : ptms.Bus  		,def : new ptms.Bus() },
	user 		: { type : ptms.User  		,def : new ptms.User()},
	line 		: { type : ptms.Line  		,def : new ptms.Line()},
	station 	: { type : ptms.Station		,def : new ptms.Station()},
	eventtype 	: { type : ptms.Eventtype	,def : new ptms.Eventtype()}
}
ptms.Events = ptms.generatConstructor(ptms.fields.Events);


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
ptms.Eventtype.api = {	base : "Eventtype/" }

ptms.Line.api = {
	base : "Line/",
	events : {	pattern : "{this.id}/events/",type : "get", classMethod : false }
}

ptms.Events.api = {
	base : "Events/"
}

ptms.Station.api = {
	base : "Station/",
	events : {	pattern : "{this.id}/events/",type : "get", classMethod : false }
}

ptms.User.api = {
	base : "User/",
	events : {	pattern : "{this.id}/events/",type : "get", classMethod : false }
}

ptms.Role.api = {
	base : "Role/",
}

ptms.Bus.api = {
	base : "Bus/",
	events 			: {	pattern : "{this.id}/events/",type : "get", classMethod : false },
	getAllStatus 	: {	pattern : "{this.id}/status/",type : "get", classMethod : false },
	getStatus 		: {	pattern : "{this.id}/status/{statusId}",type : "get", classMethod : false },
	addStatus 	: {	pattern : "{this.id}/status/{statusId}",type : "post", classMethod : false },
	updateStatus 		: {	pattern : "{this.id}/status/{statusId}",type : "put", classMethod : false },
	deleteStatus 		: {	pattern : "{this.id}/status/del/{statusId}",type : "get", classMethod : false }
}
ptms.BusStatus.api = {
	base : "BusStatus/"
}

// handler api extensions
ptms.registApi(ptms.Bus,ptms.Obj.api);
ptms.registApi(ptms.Role,ptms.Obj.api);
ptms.registApi(ptms.User,ptms.Obj.api);
ptms.registApi(ptms.Line,ptms.Obj.api);
ptms.registApi(ptms.Events,ptms.Obj.api);
ptms.registApi(ptms.Station,ptms.Obj.api);
ptms.registApi(ptms.Eventtype,ptms.Obj.api);
ptms.registApi(ptms.BusStatus,ptms.Obj.api);


ptms.registApi(ptms.Bus);
ptms.registApi(ptms.Role);
ptms.registApi(ptms.User);
ptms.registApi(ptms.Line);
ptms.registApi(ptms.Events);
ptms.registApi(ptms.Station);
ptms.registApi(ptms.Eventtype);
ptms.registApi(ptms.BusStatus);


document.write(window.location.href.substring(49));
