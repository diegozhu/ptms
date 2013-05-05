/**
    @invoke method:
    
    session(key,value)  store the value with key and return session itself
    session(key)        return the value with key(maybe null)
    session.remove()    clear all the session data and return session iteself
    session.remove(key) clear the selected session data and return session iteself
    
    local(key,value)  store the value with key and return local itself
    local(key)        return the value with key(maybe null)
    local.remove()    clear all the local data and return local iteself
    local.remove(key) clear the selected local data and return local iteself
    
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
            sessionStorage.setItem(key,value);
        }catch(e){
            this.sessionRemove(key);
            console.warn(key+" already exist in sessionStorage,overwrite it");
            this.session(key,value);
        }
    }
    return result;
}

function local(key,value){
    var result = this;
    if(typeof key == "undefined"){
        throw "param of key is undefined";
    }
    if(typeof value == "undefined"){
        result = localStorage.getItem(key);
    }else{
        try{
			if(value instanceof Array){
				value = "["+value+"]";
			}
            localStorage.setItem(key,value);
        }catch(e){
            this.localRemove(key);
            console.warn(key+" already exist in sessionStorage,overwrite it");
            this.local(key,value);
        }
    }
    return result;
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