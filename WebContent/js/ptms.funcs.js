

ptms.log = function(str){
	console.log(str);
}

ptms.alert = function(e){
	alert(e);
	console.log(e + ( typeof e.stack == "undefined" ? "" : e.stack));
}

ptms.error =  function(e){
	alert(ptms.code[e]);
	console.log(e);
	console.log(( typeof e.stack == "undefined" ? "" : e.stack));
};

ptms.confirm =  ptms.alert;
ptms.notice =  ptms.alert;
ptms.success =  ptms.alert;
ptms.warn =  ptms.alert;

ptms.analyzeHTTPResponse = function(res){
	var e = 000;
	if(res.status == "404"){
		e = 502;
	}else if(res.status =="0"){
		e = 503;
	}else{
		// ok , no error; 
		return;
	}
	throw e;
}


ptms.commonInit = function(){
	$(".btnback").on("click",function(){
		window.history.back();
	});
}

ptms.registApi = function(son,fatherApi){
	var Fapi = fatherApi ? fatherApi : son.api;
	for(i in Fapi){
		son.api[i] = ptms.clone(Fapi[i]);
		son.api[i]._class = son;
		var name = son.api[i];

		if(Fapi[i].classMethod){
			son[i] = (function(){
							var name = i;
							return 	function(){									
										var args = new Array(son.api[name]);
										for(index in arguments){
											args.push(arguments[index]);
										}
										return ptms.ajax.apply(this,args);
									};
							})();
		}else{
			son.prototype[i] = (function(){
							var name = i;
							return 	function(){									
										var args = new Array(son.api[name]);
										for(index in arguments){
											args.push(arguments[index]);
										}
										return ptms.ajax.apply(this,args);
									};
							})();
		}
	}
}


/**
	@usage : ptms.ajax(ptms.User.api.get,arg1,agr2,arg3...);
*/
ptms.ajax = function(apiObj){
	
	if(apiObj == undefined){
		var e = "lack paramters , @usage :  ptms.ajax(ptms.User.api.get , arg1 , agr2 , arg3...);";
		e.self = this;
		throw e;
	}
	//set default attribute
	var obj = {};
	var host = 	ptms.debug ? "../../fakedata/api/" : "http://" + ptms.host 
				+ (ptms.host[ptms.host.length -1 ] == "/" ? "" : "/")
				+ "api/";
	
	obj.cache = apiObj.cache || false;
	obj.async = apiObj.async || false;
    obj.contentType = "text/plain";
	obj.data = {};

	if(apiObj.dataFromThis){
		var tmp = {};
		for(var i in this){
			if(typeof this[i] != "function"){
				tmp[i] = this[i];
			}
		}
		obj.data = tmp;
	}
	// handle patterns
	var pattern = apiObj.pattern + "";   //so changes to pattern will not influence apiObj.pattern

	// handle args in pattern group by {} like {id} and self arg like {this.id}
	var patternArgs = pattern.match(/{[^}]*}/g);  
	var selfPatternArgs = pattern.match(/{this.[^}]*}/g);
	
	patternArgs = patternArgs ? patternArgs : new Array();
	selfPatternArgs = selfPatternArgs ? selfPatternArgs : new Array() ;
	
	var argsNeed = patternArgs.length - selfPatternArgs.length + 1;

	var argsGet = arguments.length;

	if( argsNeed > argsGet ){
		// lack of args
		var e = "missing parameters in function ptms.ajax , you have signed "
		e += patternArgs.length + " parameters in pattern:" + apiObj;
		e += " , but only get "+(arguments.length - 1)+" parameters while invoke."
		e.self = this;
		e.apiObj = apiObj;
		throw e;
	}else if(argsNeed == argsGet){
		// this apiObj maybe get, no data followed!
		// do nothing
	}else if(argsNeed < argsGet ){
		// spare args all treated as data , if already exist , not throw exception but just warn!
		for(var i = argsNeed ; i < arguments.length;i++){
			var arg = arguments[i];
			for(var j in arg){
				if(typeof arg[j] != "function"){
					if(typeof obj.data[j] != "undefined"){
						ptms.log("field "+j+" already exist in obj.data with value of:"+obj.data[j] + " will be overide by new value:"+arg[j] + "in arg:" + arguments[i]);
					}
					obj.data[j] = arg[j];
				}
			}
		}
	}
	
	obj.data = JSON.stringify(obj.data);
	
    var nextUsingArgIndexInArguments = 1;  // just for args not from object : this;
    
	// handle patternArgs
	for(var i in patternArgs){
		var field = patternArgs[i].replace("{","").replace("}","");
		if(field.indexOf("this.") == 0){
			var tmp = this[field.replace("this.","")];
			if(typeof tmp == undefined){
				var e = "could not find field in object "+ this +" named "+ field +" matches parameters signed in pattern:" + apiObj;
				e.self = this;
				e.apiObj = apiObj;
				throw e;
			}else{
				pattern = pattern.replace(patternArgs[i],tmp);
			}			
		}else{
			pattern = pattern.replace(patternArgs[i],arguments[nextUsingArgIndexInArguments]);
            nextUsingArgIndexInArguments ++;
		}		
	}
	
	// set data accroding to http request method put and post

	obj.type = apiObj.type;
	obj.url = host + apiObj._class.api.base + pattern;
	obj.url = obj.url[obj.url.length-1] == "/" ? obj.url.substring(0,obj.url.length-1) : obj.url;	
	obj.url = obj.url + (ptms.debug ? "."+obj.type + ".json" : ""); 

	var method = obj.type.toLowerCase();
	
	ptms.log(obj);
	
	var response;
	
	// send a request
	try{
		var res = $.ajax(obj);
		ptms.analyzeHTTPResponse(res);
		response = JSON.parse(res.responseText);
	}catch(e){
		e.ajaxResponse = res;
		e.ajaxObj = obj;
		e.apiObj = apiObj;
		throw(e);
	}
	
	// generate response
	if(response.status != "ok"){
		response = response == undefined ? { code : {} } : response;
		response.code = response.code == undefined ? {} : response.code;
		response.code.apiObj = apiObj;
		response.code.ajaxObj = obj;		
		response.code.self = this;
		throw response.code;
	}
	
	var result;
	
	// generate data for application and return
	if(response.data instanceof Array){
		result = new Array();
		for(var i in response.data){
			result.push( apiObj.generate ? new apiObj._class(response.data[i]) : new Object(response.data[i]));
		}
	}else{
		result = apiObj.generate ? new apiObj._class(response.data) : new Object(response.data);
	}
	return result;
}

/**
*		@warning this method will return an conctruction function;
*/
ptms.generatConstructor = function(fields){
	var fieldList = fields;
	// c is constructor of objs
	var c =  function(arg1){
				arg1 = ptms.Obj.call(this,arg1);
				for(fieldName in fieldList){
					var fieldDefination = fieldList[fieldName];
					if(typeof arg1[fieldName] != "undefined" && arg1[fieldName] != ""){
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
		var msg = "";
		for(fieldName in this){
            if(fieldName == "id" || fieldName=="createtime"){
                continue;
            }
			if(!this.hasOwnProperty(fieldName) || typeof this[fieldName] == "function"){
				continue;
			}
			var fieldValue = this[fieldName];
			var fieldDefination = fieldList[fieldName] || ptms.fields.obj[fieldName];
			
			if(fieldDefination == undefined){
				msg += "\ncould not find fieldDefination:"+fieldName;
				continue;
			}else{
                // value from input is always string
                if(fieldDefination.type == Number){
                    try{
                        var value = parseFloat(fieldValue);
                        if(isNaN(value)){
                            result = false;
                            msg += "\nvalue of field:"+fieldName+" not match field:"+fieldName+" should be "+ fieldDefination.type;
                            break;
                        }
                    }catch(e){
                        result = false;
                        msg += "\nvalue of field:"+fieldName+" not match field:"+fieldName+" should be "+ fieldDefination.type;
                        break;
                    }
                }else{
                    if(! (fieldValue.constructor == fieldDefination.type)){
                        result = false;
                        msg += "\nvalue of field:"+fieldName+" not match field:"+fieldName+" should be "+ fieldDefination.type;
                        break;
                    }
                }
            }
			
			if(typeof fieldDefination.limit == "object"){
			
				if(fieldDefination.limit.max == undefined || fieldDefination.limit.max == undefined){
					throw "unknow typeof limit defination , only support Array(emun) and object like { max : value , min : value } , should be "+ fieldDefination.type;
				}
				
				// for typeof number ,limit.max and limit.min treated as max value and min value;
				// while typeof string ,limit.max and limit.min treated as max length and min length;
				if(typeof fieldValue == "number"){
					if(fieldValue > fieldDefination.limit.max){
						result = false
						msg += "\nvalue of:"+ fieldName +" is bigger than the max:" + fieldDefination.limit.max;
						break;
					}else if(fieldValue < fieldDefination.limit.min){
						result = false;
						msg += "\nvalue of:"+ fieldName +" is smaller than the min value:" + fieldDefination.limit.min;
						break;
					}else{
						// value in limit, ok ,check next field;
						// do nothing;
					}
				}else if(typeof fieldValue == "string"){
					if(fieldValue.length > fieldDefination.limit.max){
						result = false
						msg += "\nvalue of:"+ fieldName +" is longger than the max length:"+fieldDefination.limit.max;
						break;
					}else if(fieldValue.length < fieldDefination.limit.min){
						result = false;
						msg += "\nvalue of:"+ fieldName +" is shorter than the max length:"+fieldDefination.limit.min;
						break;
					}else{
						// value in limit, ok ,check next field;
						// do nothing;
					}
				}else{
					msg += "\n field name:"+ fieldName+" could not be found in :" + ptms.getObj(fieldList) + " or "+ptms.getObj(ptms.fields.obj);
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
					msg += "value of:"+ fieldName +" is not in the given value array(emun) "+ ptms.getObj(array);
				}else{
					// do nothing , check next field , value in limit ok
				}
			}else if(typeof fieldDefination.limit == "undefined"){
				// do nothing				
			}else{
				throw "unknow typeof limit defination , only support Array(emun) and {}";
			}
			
		}
		
		return { res : result , msg : msg};
	}
	
	return c;
}