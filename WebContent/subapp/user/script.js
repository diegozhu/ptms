/*function w(s){
        document.write(s);
    }
	

var get = new Array("user","user/1","user/1/event");
var post = new Array("user");
var put = new Array("user/1");
var del = new Array("user/1");

function o(str){
	$("#output").html( $("#output").html()+"<br />"+str);
}

for(var i in get){
	w('<input type="button" method="get" value="'+get[i]+'" url="'+get[i]+'">');
}

for(var i in post){
	w('<input type="button" method="post" value="'+post[i]+'" url="'+post[i]+'">');
}

for(var i in put){
	w('<input type="button" method="put" value="'+put[i]+'" url="'+put[i]+'">');
}

for(var i in del){
	w('<input type="button" method="delete" value="'+del[i]+'" url="'+del[i]+'">');
}

var a;*/

var users;

$(function(){

	
	
	/*$("input[type=button]").on("click",function(e,b){
		var apiurl = $(e.currentTarget).attr("url");
		var method = $(e.currentTarget).attr("method");
		console.log(apiurl);
		console.log(method);
		ptms.ajax({
			 type: method,
			 url: apiurl,
			 success: function(msg){
			   console.log(msg);
			   o(msg);
			 },
			 error : function(msg){
			   console.log(msg);
			 }
	   }); 
	});	*/
});