ptms.status = function(name){
	this.name = name;
	return this;
}

ptms.status.prototype.bus = function(){}
ptms.status.prototype.line = function(){}
ptms.status.prototype.station = function(){}