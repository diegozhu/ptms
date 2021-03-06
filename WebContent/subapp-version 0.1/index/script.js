i18n.init();
	
$(function(){

	ko.applyBindings(i18n.model());
	ptms.commonInit();
	
	$("#side_nav li a").click(function(e){
		var id = e.currentTarget.id;
		id.replace("nav_","");
		$(".nav li").removeClass("active");
		$(e.currentTarget.parentElement).addClass("active");
		return false;
	});
	
	$("iframe").on("load",function(e){
		this.style.height = e.currentTarget.contentDocument.height + 100 + "px";
	});
	
	$('#myTab a').click(function (e) {
	  e.preventDefault();
	  $(this).tab('show');
	})
	
	$("#change").click(function(){
		i18n.setLanguage("en_us");
		ko.applyBindings(i18n.model());
	});
	
	$("#changeLanguage").click(function(){
		var href = window.location.href;
		if(href.indexOf("zh_cn") != -1){
			href = href.replace("zh_cn","en_us");
		}else{
			href = href.replace("en_us","zh_cn");
		}
		window.location = href;
	});
	
	$("#side_nav li a").click(function(e){
		$("#pannel").attr("src",$(this).attr("page"));
	});
});