ptms.bus = function(name){
	if(!(this instanceof ptms.bus)){
		throw 'ptms.bus is a constructor and must be called like "var car = new ptms.bus(id,name,...);"';
	};
	// new created means there is no data in database yet, u need to call bus.add() to store this newly created bus into database;
	this.newCreated = true;
	this.name = name;
	return this;
}

ptms.bus.list = function(start,end){
	var result = new Array();
	console.log(this);
	return result;
};

ptms.bus.prototype.add = function(){
		console.log(this);
	};

ptms.bus.prototype.detail = function(){
		console.log(this);
	};

ptms.bus.prototype.update = function(){
		console.log(this);
	};
ptms.bus.prototype.del = function(){
		console.log(this);
	};

ptms.bus.prototype.event = function(){
		console.log(this);
	};

ptms.bus.status = function(){
	console.log(this);
	// constructor of bus-status
	return this;
}

	//list :  function(){},
	//add : function(){}
	
ptms.bus.prototype.statusdetail = function(){
		console.log(this);
	};
	
ptms.bus.prototype.sadd = function(){
		console.log(this);
	};
	
	
var bus =  new ptms.bus();
/*
ptms.bus.add(bus);
ptms.bus.list();

bus.detail();
bus.update();

var status = new bus.status();

bus.status.list();
bus.status.add(status);

status.detail();
status.update();
*/
