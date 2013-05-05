/**
    @invoke method:
    
    session(key,value)  store the value with key and return session itself
    session(key)        return the value with key(maybe null)
    session.remove()    clear all the session data and return session iteself
    session.remove(key) clear the selected session data and return session iteself
    
    local(key,value,readTimes)  store the value with key and return local itself  @notice readTimes must be 0(default,no limit) to 9
    local(key)        return the value with key(maybe null)
    local.remove()    clear all the local data and return local iteself
    local.remove(key) clear the selected local data and return local iteself
	
	local.one(key);
	local.one(key,value);
    
    @support chain invoke like : session(key,value)(key,value).remove(key).remove()(key)
    @support chain invoke like : local(key,value)(key,value).remove(key).remove()(key)
*/


function session(key,value){
    var result = this;
    if(typeof key == "undefined"){
        throw "param of key is undefined";
    }
    if(typeof value == "undefined"){
        result = sessionStorage.getItem(key);
    }else{
		if(value instanceof Array){
			value = "["+value+"]";
		}
        try{
            sessionStorage.setItem(key,JSON.stringify(value));
        }catch(e){
            this.sessionRemove(key);
            console.warn(key+" already exist in sessionStorage,overwrite it");
            this.session(key,value);
        }
    }
    return result;
}

function local(key,value,readTimes){
    var result = this;
	
	// 0 means no limit for read
	
    if(typeof key == "undefined"){
        throw "param of key is undefined";
    }
    if(typeof value == "undefined"){
        result = localStorage.getItem(key);
		if(result != null){
			timesLeft = result.substring(0,1);
			result = result.substring(1);
			result = JSON.parse(result);
			timesLeft = parseInt(timesLeft);
			if(timesLeft == 1 ){
				localStorage.removeItem(key);
			}else if(timesLeft > 1){
				localStorage.removeItem(key);
				localStorage.setItem(key,(timesLeft -1 ) + JSON.stringify(result));
			}else if(timesLeft < 0){
				// timesLeft <= 0
				// do nothing;
				localStorage.removeItem(key);
				localStorage.setItem(key,"0" + JSON.stringify(result));
			}
		}
    }else{
		if(value.__readTimes != undefined ){
			throw "value could not have a field of __readTimes";
		}
        try{
			if(value instanceof Array){
				value = "["+value+"]";
			}
			value = ( readTimes ?  readTimes : 0 ) + JSON.stringify(value);
			localStorage.setItem(key,value);
        }catch(e){
            localStorage.removeItem(key);
            console.warn(key+" already exist in sessionStorage,overwrite it");
            localStorage.setItem(key,value);
        }
    }
    return result;
}

local.one = function(key,value){
	return local(key,value,1);
}

session.remove = function(key){
    if(typeof key == "undefined"){
        sessionStorage.clear();
    }else{
        sessionStorage.removeItem(key);
    }
    return this;
};

local.remove = function(key){
    if(typeof key == "undefined"){
        localStorage.clear();
    }else{
        localStorage.removeItem(key);
    }
    return this;
};