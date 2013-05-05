i18n.init();
var model = i18n.model("role");

$(function(){

	var section_id = "list";
	
	var $sections = $(".page_section");
	
	var href = window.location.href;

	model.data = {};
	
	if(href.indexOf(".html#") != -1){
		section_id = href.indexOf("?") == -1 ? href.substring(href.indexOf(".html#")+6) : href.substring(href.indexOf(".html#")+6,href.indexOf("?"));		
	}

	var chagePage = {};
	
	chagePage.detail = function(){
		$sections.hide();
		$("#page_section_detail").show();
		try{
			model.data.role = ptms.Role.get(parseInt(local("role-id")));
		}catch(e){
			ptms.error(e);
		}
	}
	
	chagePage.add = function(){
		$sections.hide();
		$("#page_section_add").show();
	}
	
	chagePage.list = function(){
		$sections.hide();
		$("#page_section_list").show();
		try{
			model.data.roles = ptms.Role.getAll();
		}catch(e){
			ptms.error(e);
		}
	}
	
	chagePage.edit = function(){
		$sections.hide();
		$("#page_section_edit").show();
	}
	
	switch(section_id){
		case "add":
			chagePage.add();
			break;
		case "edit":
			chagePage.eidt();
			break;
		case "detail":
			chagePage.detail();
			break;
		case "list":
			chagePage.list();
			break;
		default : 
			chagePage.list();
			break;
	}
	
	$("#page_section_detail .btnEidt").click(function(e){
			local.one("role",model.data.role);
			pageChage.edit();
	});

	$("#page_section_list li a").on("click",function(e){
			local.one("role-id",$(this).attr("role-id"));
			pageChage.detail();
	});

	$("#page_section_add .btnSave").click(function(e){
			var role = model.data.role;
			role.name = $("#edit-name").val();
			role.description = $("#edit-description").val();
			try{
				role.update();
				ptms.success("update ok!");
				local.one("role-id",role.id);
				pageChage.list();
			}catch(e){
				ptms.error(e);
			}
		});
		
		
	$("#page_section_edit .btnCancel").on("click",function(){
		local.one("role-id",model.data.role.id);
		pagePage.detail();
		return false;
	});
		
	var $page_section = $("#page_section_"+section_id);
	ko.applyBindings(model,$page_section[0]);
	$page_section.show();
	ptms.commonInit();
});