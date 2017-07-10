SSM.namespace("COT");
SSM.COT=(function() {
	"use strict";
	var CONTEXT=""; //URL的上下文，是否包含项目名，默认不包含，若包含修改之
	
	//获取项目上下文路径
	function getPorjPath() {
		if(window.location.href.indexof("SpringmvcSpringMybatis")>0){
			CONTEXT="/SpringmvcSpringMybatis";
		}
	}
	
	function getCot(id) {
		if(!isNull(id)){
			window.location.href=CONTEXT+"/content/getOne/"+id
		}
	}
	function getContents() {
		getPorjPath();
		$.ajax({
			type:'Post',
			contentType:'application/json',
			url:CONTEXT+'/content/getAll',
			processData:false,
			dataType:'json',
			data:'{}',
			success:function(data){
				console.log("%o",data);
				//动态修改DOM
				append2Dom(data);
			},
			error:function(){
				alert("悲剧了，保存失败！");
			}
			
		});
	}
	function append2Dom(list) {
		//判断list是非空
		if(isNull(list)){
			return
		}else{
			var items="";
			//追加动态生成的组件
			var title="<tr><th>选择</th><th>试题序号</th><th>试题内容</th><th>选项A</th><th>选项B</th><th>选项C</th><th>选项D</th><th>正确答案</th></tr>";
			for(var i=0;i<list.length;i++){
				var tmp="<tr><td><input type='checkbox' name='ids' value='"
					+list[i].id
			}
		}
	}
})