//alert("alluser.js");
var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.jquery;

 	var addUserArray = [],addUser;
 	form.on("submit(addUser)",function(data){

	 	//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
// 		windows.location.href="addUser_controller";
 		setTimeout(function(){
 	          top.layer.close(index);
 				top.layer.msg("用户添加成功！");
 				layer.closeAll("iframe");
 		 		//刷新父页面
 		 		parent.location.reload();
 	      },2000);
 	      return false;
 	})
	
})
