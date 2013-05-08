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
	this.deleted = false;
	return arg1;
}

ptms.fields = {};
ptms.fields.obj = {
	id 			: 	{ type: Number , limit : { max : 99999999999 , min : 0 } 	, def : 0},
	name 		: 	{ type: String , limit : { max : 45 , min : 1 } 			, def : 0},
	createtime 	: 	{ type: String , limit : { max : 45 , min : 1 } 			, def : 0},
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
	workid 			:{ type:String	 , limit:{ max:45,min:1},	def:0},
	personalid 		:{ type:String	 , limit:{ max:45,min:1},	def:0},
	address 		:{ type:String	 , limit:{ max:45,min:1},	def:0},
	cellphone 		:{ type:String	 , limit:{ max:45,min:1},	def:0},
	password 		:{ type:String	 , limit:{ max:45,min:1},	def:0}, 
	passwordAgain 	:{ type:String	 , limit:{ max:45,min:1},	def:0},
	gender 			:{ type:Boolean	 , limit:{ max:45,min:1},	def:0},
	jointime 		:{ type:String	 , limit:{ max:45,min:1},	def:0}, 
	resigntime 		:{ type:String	 , limit:{ max:45,min:1},	def:0},
	role 			:{ type:ptms.Role						 ,	def:new ptms.Role()}
}
ptms.User = ptms.generatConstructor(ptms.fields.User);

ptms.fields.Bus = {	
	type 		: { type : String 	, limit : {max : 45 ,min:1 } , def : "45座客车" },
	lefttime 	: { type : String 	, limit : {max : 45 ,min:1 } , def : "" },
	user 		: { type : ptms.User							  , def : new ptms.User() },
	maxpassager : { type : Number 	, limit : {max : 45 ,min:1 } , def : 45 },
	purchasetime: { type : String 	, limit : {max : 45 ,min:1 } , def : "" },
	line		: { type : ptms.Line, 								def : new ptms.Line()}
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

ptms.fields.LineStatus = { 
	line 		: { type : ptms.Line  		,def : new ptms.Line()},
	status   	: { type : Number	, limit : {max : 99999999999 ,min:0 }},
}

ptms.LineStatus = ptms.generatConstructor(ptms.fields.LineStatus);


ptms.fields.BusStatus = { 
	bus 		    : { type : ptms.Bus  		,def : new ptms.Bus()},
	wheelpressure   : { type : Number	, limit : {max : 99999999999 ,min:0 }},
	temperature   	: { type : Number	, limit : {max : 99999999999 ,min:0 }},
	gasleft   	    : { type : Number	, limit : {max : 99999999999 ,min:0 }},
	locationx   	: { type : Number	, limit : {max : 99999999999 ,min:0 }},
	locationy   	: { type : Number	, limit : {max : 99999999999 ,min:0 }}
}

ptms.BusStatus = ptms.generatConstructor(ptms.fields.BusStatus);

ptms.fields.StationStatus = { 
	station 		: { type : ptms.Station  		,def : new ptms.Station()},
	status 		    : { type : Number	, limit : {max : 99999999999 ,min:0 }},
	trafficstatus   : { type : Number	, limit : {max : 99999999999 ,min:0 }},
	passagerstatus  : { type : Number	, limit : {max : 99999999999 ,min:0 }},
}

ptms.StationStatus = ptms.generatConstructor(ptms.fields.StationStatus);

ptms.fields.LineStation = { 
	station : { type : ptms.Station ,def : new ptms.Station()},
	line 	: { type : ptms.Line  	,def : new ptms.Line()},
}

ptms.LineStation = ptms.generatConstructor(ptms.fields.LineStation);






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
	getEvents : {	pattern : "{this.id}/events/",type : "get", classMethod : false },
	getBuses : {	pattern : "{this.id}/bus/",type : "get", classMethod : false },
    getStations : { pattern : "{this.id}/station/",type : "get", classMethod : false },
    addStation : { pattern : "{this.id}/station/add/{stationid}",type : "get", classMethod : false },
    delStation : { pattern : "{this.id}/station/del/{stationid}",type : "get", classMethod : false },
    addBus : { pattern : "{this.id}/bus/add/{busid}",type : "get", classMethod : false },
    delBus : { pattern : "{this.id}/bus/del/{busid}",type : "get", classMethod : false }
}

ptms.Events.api = {
	base : "Events/",
    bus     : {	pattern : "c/bus/",type : "get", classMethod : true },
    user : {	pattern : "c/user/",type : "get", classMethod : true },
    station : {	pattern : "c/station/",type : "get", classMethod : true },
    line    : {	pattern : "c/line/",type : "get", classMethod : true }
}

ptms.Station.api = {
	base : "Station/",
	events : {	pattern : "{this.id}/events/",type : "get", classMethod : false },
    getStatus :  {	pattern : "{this.id}/status/",type : "get", classMethod : false },
    getLastStatus :  {	pattern : "{this.id}/status/last",type : "get", classMethod : false },
    addStatus :  {	pattern : "{this.id}/status/",type : "post", classMethod : false },
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
	addStatus 	    : {	pattern : "{this.id}/status/{statusId}",type : "post", classMethod : false },
	updateStatus 	: {	pattern : "{this.id}/status/{statusId}",type : "put", classMethod : false },
	deleteStatus 	: {	pattern : "{this.id}/status/del/{statusId}",type : "get", classMethod : false },
	getFreeBus 		: {	pattern : "free/",type : "get", classMethod : true }
}

ptms.BusStatus.api = {
	base : "BusStatus/"
}

ptms.LineStatus.api = {
    base : "LineStatus/"
}
ptms.BusStatus.api = {
    base : "BusStatus/"
}
ptms.StationStatus.api = {
    base : "StationStatus/"
}
ptms.LineStation.api = {
    base : "LineStation/"
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
ptms.registApi(ptms.LineStatus,ptms.Obj.api);
ptms.registApi(ptms.StationStatus,ptms.Obj.api);
ptms.registApi(ptms.LineStation,ptms.Obj.api);


ptms.registApi(ptms.Bus);
ptms.registApi(ptms.Role);
ptms.registApi(ptms.User);
ptms.registApi(ptms.Line);
ptms.registApi(ptms.Events);
ptms.registApi(ptms.Station);
ptms.registApi(ptms.Eventtype);
ptms.registApi(ptms.BusStatus);
ptms.registApi(ptms.LineStatus);
ptms.registApi(ptms.StationStatus);
ptms.registApi(ptms.LineStation);

var href = window.location.href;

document.write(href.substr(href.indexOf("/subapp/")+8));
