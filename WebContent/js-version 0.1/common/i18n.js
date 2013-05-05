/**
    @name i18n
    
    @important
        when you add your own strings , see notice in string.js
    
    @include

        <script type="text/javascript" src="../../js/common/i18n.js"></script>

    @need
        //any version is okay
        <script type="text/javascript" src="../../js/libs/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="../../js/libs/knockout-2.1.0.js"></script>
        <script type="text/javascript" src="../../js/common/storage.js"></script>

    @init
        i18n.init(callBackFunc);
            @return this

    @howToAddYourOwnLanguageFile
        language string file is under "strings" folder,there are already some demos there.


    @publicFields:
        i18n.inited
            you can check this.

    @publicFunctions :
        set : 	i18n.model(yourViewName) or get : i18n.model()
        set : 	i18n.string(key,value) or get : i18n.string(key)
				i18n.setLanguage();
*/
var i18n;

(function(){

    i18n = {
        _language : "zh_cn",
        inited : false,
        viewModeUrl : "../../strings/",
        _currentViewModelName : "g"
    };


    i18n.init = function(lang,callBackFunc){
		var href = (window.top == this) ? window.location.href : window.top.location.href;
		var markIndex = href.indexOf("language=");
		if(markIndex != -1){
			var parameterIndex = href.indexOf("?");
			if(parameterIndex < markIndex){
				var l = href.substr(markIndex+9,5);
			}
		}
		i18n._language = lang || l || i18n._language;
        if(!i18n.inited){
			checkBeforeInit();
			 //check localstorage first
            i18n.Dictionary = JSON.parse(local("i18n.D."+i18n._language));
            //if(i18n.Dictionary != null){
            if(false){
                i18n.inited = true;
                $.each(i18n.Dictionary,function(index,object){
                    if(object != i18n.Dictionary.global){                    
                        object.__proto__ = i18n.Dictionary.global;
                    }
                });
                console.log("get i18n.Dictionary from localstorage");
            }else{
                var langFile = i18n.viewModeUrl + "string."+i18n._language +".js";
				console.log(langFile);
                $.ajax({
                    url : langFile,
                    async : false,   // must be sync,
                    cache : false,
                    complete : function(resp){
                                i18n.Dictionary = anlysis(resp.responseText);
                                i18n.inited = true;
                                var storageKey = "i18n"+i18n._language;
                                local(storageKey,JSON.stringify(i18n.Dictionary));
                             }
                });
            }
            if(typeof callBackFunc == "function"){
                callBackFunc();
            }
        }
        return this;
    }

    i18n.model = function(key){
		var result = this;
		if(typeof key == "undefined"){
			result = this.Dictionary[this._currentViewModelName];
		}else{
			this._currentViewModelName = key;
		}
        return result;
    }

    i18n.string = function(key){
		if(typeof key == "undefined"){
			throw "key must be specified!";
		}
		var res = i18n.Dictionary[i18n._currentViewModelName][key];
		return   res ? res : i18n.Dictionary["g"][key];
    };
    //json.parse
    function anlysis(data){
		// delete single line comments,keep \n : \\;
		data = data.replace(/\/\/[^\n]*/g,"");
		data = data.split("\n");
		var D = {
            g : {}
        };
		
		var file = i18n.viewModeUrl + "string."+i18n._language +".js";
		
		for(i in data){
			var item = data[i];
			item = item.trimLeft().trimRight();	
			if(item == ""){
				continue;
			}
			
			var viewName = item.substring(0,item.indexOf("-"));
			var key = item.substring(item.indexOf("-")+1,item.indexOf("="));
			var value = item.substring(item.indexOf("=")+1);
			
			if(viewName == ""){
				throw ("error on file:"+file + " line:"+(parseInt(i)+1)+" viewName expected!");
			}
			if(key == ""){
				throw ("error on file:"+file + " line:"+(parseInt(i)+1)+" key expected!");
			}
			if(value == ""){
				throw ("error on file:"+file + " line:"+(parseInt(i)+1)+" value expected!");
			}
			// replace all blanks
			viewName = viewName.replace(/ */g,"");
			// replace all blanks
			key = key.replace(/ */g,"");
			value = value.trimLeft().trimRight();
			
			if(D[viewName] == undefined){
				D[viewName] = {
					__proto__ : D.g
				};
			}
			if(typeof D[viewName][key] != "undefined"){
				throw ("record already exist in view in file:"+file + " line:"+(parseInt(i)+1)+","+item);
			}
			D[viewName][key] = value;
		}		
        return D;
    }
	
	i18n.setLanguage = function(str){
		i18n.inited = false;
		i18n.init(str);
	}
	
    function checkBeforeInit(){
        if(typeof $ == "undefined" ||  typeof jQuery == "undefined" || jQuery != $){
            throw ("jquery.js is required!");
        }
        if(typeof ko == "undefined"){
            throw ("kockout.js is required!");
        }    
        if(typeof local == "undefined" || typeof session == "undefined"){
            throw ("storage.js is required!");
        }
    }
})();