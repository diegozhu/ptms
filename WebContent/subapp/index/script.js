i18n.init();
	
$(function(){

	ko.applyBindings(i18n.model());
	ptms.commonInit();
	
	$("#side_nav li a").click(function(e){
		var id = e.currentTarget.id;
		id.replace("nav_","");
		$(".nav li").removeClass("active");
    	$("#pannel").attr("src",$(this).attr("page"));
		$(e.currentTarget.parentElement).addClass("active");
		return false;
	});
	
	$("iframe").on("load",function(e){
		this.style.height = e.currentTarget.contentDocument.height + 20 + "px";
	});
	
	
	$("#side_nav li").hide();
	$(".corpmangement").show();
		
	$("#myTab li a").click(function(e){
		e.preventDefault();
		var id = e.currentTarget.id;
		$("#side_nav li").hide();
		$("."+id).show();
		if(id == "configure"){
            $("#pannel").hide();
        }else{
             $("#pannel").show();
            $("#pannel").attr("src",$($("."+id+" a")[0]).attr("page"));
        }
        
	});

	$("#change").click(function(){
		i18n.setLanguage("en_us");
		ko.applyBindings(i18n.model());
	});
	
	$("#changeLanguage").click(function(){
		var href = window.location.href;
		if(href.indexOf("zh_cn") != -1){
			href = href.replace("zh_cn","en_us");
		}else if(href.indexOf("en_us") != -1){
			href = href.replace("en_us","zh_cn");
		}else{
			href = href + "?language=en_us";
		}
		window.location = href;
	});
});