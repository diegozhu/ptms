/**
    @name LanguageManager,LM
    
    @important
        when you add your own strings , 
        do not remain " " in your view like "yourViewModel-lbwelcome ":"something";
        blank after "yourViewModel-lbwelcome" will result in error;
    
    @include

        <script type="text/javascript" src="../../js/common/i18n.js"></script>

    @need
        //any version is okay
        <script type="text/javascript" src="../../js/libs/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="../../js/libs/knockout-2.1.0.js"></script>
        <script type="text/javascript" src="../../js/common/storage.js"></script>

    @init
        LM.init(callBackFunc);
            @return this

    @howToAddYourOwnLanguageFile
        language string file is under "www\strings" folder,there are already some demos there.


    @publicFields:
        LM.inited
            you can check this.

    @publicFunctions :
        LM.getString(key);
        LM.getViewMode(yourViewName);

*/
var i18n;

(function(){

    i18n = {
        _language : "zh_cn",
        inited : false,
        viewModeUrl : "../../strings/",
        _currentViewModelName : ""
    };


    i18n.init = function(callBackFunc){
        if(!i18n.inited){
            i18n.Dictionary = JSON.parse(local("LF.LM.D."+i18n._language));
            if(i18n.Dictionary != null){
                //check localstorage first
                i18n.inited = true;
                $.each(i18n.Dictionary,function(index,object){
                    if(object != i18n.Dictionary.global){                    
                        object.__proto__ = i18n.Dictionary.global;
                    }
                });
                console.log("get LM.Dictionary from localstorage");
            }else{
                console.log("could not get LM.Dictionary from localstorage");
                var langFile = i18n.viewModeUrl + "string."+i18n._language +".js";
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

    i18n.getViewMode = function(key){
        LM._currentViewModelName = key;
        return LM.Dictionary[key];
    }

    i18n.getString = function(key){
        return LM[LM._currentViewModelName][key];
    };
    //json.parse
    function anlysis(data){
        var map = JSON.parse("{"+data+"}");
        var D = {
            g : {}
        };
        var viewName,key,value,tmp;
        $.each(map,function(index,value){
            tmp = index.indexOf("-");
            viewName = index.substring(0,tmp);
            key = index.substring(tmp+1);
            if(D[viewName] == undefined){
                D[viewName] = {
                    __proto__ : D.g
                };
            }
            D[viewName][key] = value;
        });
        return D;
    }
    function checkBeforeInit(){
        if($ == undefined){
            throw ("jquery is required!");
        }
        if(ko == undefined){
            throw ("kockout is required!");
        }    
        if(localStorage == undefined){
            throw ("localStorage is required!");
        }
    }
    
    
})();