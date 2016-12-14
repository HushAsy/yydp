$(function() {
	var basePath = getContextPath();

	$('#xtglBtn').menubutton({
		iconCls : 'icon-man',
		plain : true,
		menu : '#xtglMenu'
	});
	
	$('#xtglBtn').menu('disableItem', $('#disable-101'))
	$('#xtglBtn').menu('disableItem', $('#disable-102'))
	$('#xtglBtn').menu('disableItem', $('#disable-103'))
	$('#xtglBtn').menu('disableItem', $('#disable-104'))
	$('#xtglBtn').menu('disableItem', $('#disable-105'))
	$('#xtglBtn').menu('disableItem', $('#disable-106'))
	$('#xtglBtn').menu('disableItem', $('#disable-107'))
	
	$('#sjzdBtn').menubutton({
		iconCls : 'icon-man',
		plain : true,
		menu : '#sjzdMenu'
	});
	
	$('#sjzdBtn').menu('disableItem', $('#disable-201'))
	$('#sjzdBtn').menu('disableItem', $('#disable-202'))
	$('#sjzdBtn').menu('disableItem', $('#disable-203'))
	$('#sjzdBtn').menu('disableItem', $('#disable-204'))
	$('#sjzdBtn').menu('disableItem', $('#disable-205'))
	$('#sjzdBtn').menu('disableItem', $('#disable-206'))
	$('#sjzdBtn').menu('disableItem', $('#disable-207'))
	$('#sjzdBtn').menu('disableItem', $('#disable-208'))
	$('#sjzdBtn').menu('disableItem', $('#disable-209'))
	$('#sjzdBtn').menu('disableItem', $('#disable-210'))
	$('#sjzdBtn').menu('disableItem', $('#disable-211'))
	$('#sjzdBtn').menu('disableItem', $('#disable-212'))
	
	$('#jssmBtn').menubutton({
		iconCls : 'icon-man',
		plain : true,
		menu : '#jssmMenu'
	});
	
	$('#ajglBtn').menubutton({
		iconCls : 'icon-man',
		plain : true,
		menu : '#ajglMenu'
	});
	
	$('#dzajglBtn').menubutton({
		iconCls : 'icon-man',
		plain : true,
		menu : '#dzajglMenu'
	});
	
	$('#dzajglMenu').menu('disableItem', $('#disable-601'))
	$('#dzajglMenu').menu('disableItem', $('#disable-602'))
	$('#dzajglMenu').menu('disableItem', $('#disable-603'))

	$('#zzajglBtn').menubutton({
		iconCls : 'icon-man',
		plain : true,
		menu : '#zzajglMenu'
	});
	
	$('#zzajglMenu').menu('disableItem', $('#disable-301'))
	$('#zzajglMenu').menu('disableItem', $('#disable-302'))
	$('#zzajglMenu').menu('disableItem', $('#disable-303'))
	$('#zzajglMenu').menu('disableItem', $('#disable-304'))
	$('#zzajglMenu').menu('disableItem', $('#disable-305'))
	$('#zzajglMenu').menu('disableItem', $('#disable-306'))
	$('#zzajglMenu').menu('disableItem', $('#disable-307'))
	$('#zzajglMenu').menu('disableItem', $('#disable-308'))
	
	$('#ajgdBtn').menubutton({
		iconCls : 'icon-man',
		plain : true,
		menu : '#ajgdMenu'
	});
	
	$('#ajgdBtn').menu('disableItem', $('#disable-401'))
	$('#ajgdBtn').menu('disableItem', $('#disable-402'))
	$('#ajgdBtn').menu('disableItem', $('#disable-403'))
	$('#ajgdBtn').menu('disableItem', $('#disable-404'))
	
	$('#tjfxBtn').menubutton({
		iconCls : 'icon-man',
		plain : true,
		menu : '#tjfxMenu'
	});
	
	$('#tjfxBtn').menu('disableItem', $('#disable-501'))
	$('#tjfxBtn').menu('disableItem', $('#disable-502'))
	$('#tjfxBtn').menu('disableItem', $('#disable-503'))
	$('#tjfxBtn').menu('disableItem', $('#disable-504'))
	$('#tjfxBtn').menu('disableItem', $('#disable-505'))
	
	

	$('#leftNav').tree({
		url : '',
		lines : true
	});
});
// 修改密码
function updatepwd(uid) {
	$('#pwddialog').dialog({
		title : '修改密码',
		width : 512,
		height : 300,
		closed : false,
		cache : false,
		href : getContextPath() + '/user/updatePwdUI.do',
		modal : true
	});
}
// 当前用户信息
function currUser() {
	$('#currUser').dialog({
		title : '用户信息',
		width : 512,
		height : 300,
		closed : false,
		cache : false,
		href : getContextPath() + '/user/currUser.do',
		modal : true
	});
}
// 退出系统
function quit() {
	$.messager.confirm('退出系统', '确定要退出系统吗?', function(r) {
		if (r) {
			window.location.href = getContextPath()+'/login/quit.do';
		}
	});
}
//刷新center窗口
function changeCenter(url){
//	$('#center').panel('refresh',url);
	$("#center").panel({
		cache : false,
		href : url
	});
}

function getContextPath() {
			var localObj = window.location;
			var contextPath = localObj.pathname.split("/")[1];
			return localObj.protocol + "//" + localObj.host + "/" + contextPath;
		}
