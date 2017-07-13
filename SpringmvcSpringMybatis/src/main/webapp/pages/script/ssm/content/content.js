SSM.namespace("COT");
SSM.COT = (function() {
	"use strict";
	var CONTEXT = ""; // URL的上下文，是否包含项目名，默认不包含，若包含修改之

	// 获取项目上下文路径
	function getPorjPath() {
		if (window.location.href.indexOf("SpringmvcSpringMybatis") > 0) {
			CONTEXT = "/SpringmvcSpringMybatis";
		}
	}

	function getCot(id) {
		if (!isNull(id)) {
			window.location.href = CONTEXT + "/content/getOne/" + id
		}
	}
	function getContents() {
		getPorjPath();
		$.ajax({
			type : 'Post',
			contentType : 'application/json',
			url : CONTEXT + '/content/getAll',
			processData : false,
			dataType : 'json',
			data : '{}',
			success : function(data) {
				console.log("%o", data);
				// 动态修改DOM
				append2Dom(data);
			},
			error : function() {
				alert("悲剧了，保存失败！");
			}

		});
	}
	function append2Dom(list) {
		// 判断list是非空
		if (isNull(list)) {
			return
		} else {
			var items = "";
			// 追加动态生成的组件
			var title = "<tr><th>选择</th><th>试题序号</th><th>试题内容</th><th>选项A</th><th>选项B</th><th>选项C</th><th>选项D</th><th>正确答案</th></tr>";
			for (var i = 0; i < list.length; i++) {
				var tmp = "<tr><td><input type='checkbox' name='ids' value='"
						+ list[i].id + "' /></td><td>" + list[i].id
						+ "</td><td>" + list[i].test + "</td><td>" + list[i].a
						+ "</td><td>" + list[i].b + "</td><td>" + list[i].c
						+ "</td><td>" + list[i].d + "</td><td>"
						+ list[i].answer + "</td>" + "</tr>";
				items = items + tmp;
			}
			$("#myTable").empty();// 删除原来的子元素，防止重复生成
			// 获取需要追加的元素
			$("#myTable").append(title + items);
		}
	}
	function saveCot(id) {// 有id为更新，没有id为添加
		var requesturl = CONTEXT + "/content/addOrMod";
		var reqdata;
		if (isNull(id)) {
			reqdata = '{"test":"' + $("#test").val() + '","A":"'
					+ $("#A").val() + '","B":"' + $("#B").val + '","C":"'
					+ $("#C").val + '","D":"' + $("#D").val + '","Answer":"'
					+ $("#Answer") + '"}';

		} else {
			reqdata = '{"test":"' + $("#test").val() + '","A":"'
					+ $("#A").val() + '","B":"' + $("#B").val + '","C":"'
					+ $("#C").val + '","D":"' + $("#D").val + '","Answer":"'
					+ $("#Answer") + '","id":"' + $("#id").val() + '"}';

		}
		$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : requesturl,
			processData : false,
			dataType : 'json',
			data : reqdata,
			success : function(data) {
				console.log("%o", data);
				// alert(data.result);
				// 返回到主页面
				window.location.href = CONTEXT
						+ "/pages/jsp/content/contentMain.jsp"
			},
			error : function() {

				alert("悲剧了，保存失败！");
			}
		});
	}
	function delCot(ids) {
		$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : CONTEXT + "content/del",
			processData : false,
			dataType : 'json',
			data : '{"ids":"' + ids + '"}',
			success : function(data) {
				// alert(data.result);
				// 返回到主页面
				window.location.href = CONTEXT
						+ "/pages/jsp/content/contentMain.jsp"
			},
			error : function() {
				alert("删除失败，悲剧了!");
			}
		});
	}
	// 下面两个方法之所以写在这里，是因为jQuery中因为作用域的问题，取不到CONTEXT的内容；
	function openAddOrModPage() {
		window.location.href = CONTEXT + "/pages/jsp/content/contentUpdate.jsp"
	}
	function cotSaveCancel() {
		// 回到主页面
		window.location.href = CONTEXT + "/pages/jsp/content/contentMain.jsp"
	}
	// 若上面定义的常量和function可以被外面调用，要使用下面用法
	return {
		CONTEXT : CONTEXT,// 获取项目上下文
		openAddOrModPage : openAddOrModPage,
		cotSaveCancel : cotSaveCancel,
		saveCot : saveCot,// 新增和更新可以用一个
		delCot : delCot,
		getCot : getCot,
		getContents : getContents
	};
})();
$(function() {
	// 实现页面载入完成后，自动查询所有数据，也就是回到这个主页面要看到数据的变化，类似刷新的功能。
	window.onload = SSM.COT.getContents();
	// SSM.COT
	// 新增按钮
	$("#cotAddBtn").click(function() {
		SSM.COT.openAddOrModPage();
	});
	// 修改按钮
	$("#cotModBtn").click(function() {
		// 获取选中的checkbox
		var ids = [];
		$("#myTable :input:checked").each(function() {
			ids.push($(this).val())
		});
		if (isNull(ids) || ids.length > 1) {
			alert("请选择一条记录更新");
		} else {
			SSM.COT.getCot(ids[0]);
		}
	});
	// 保存按钮
	$("#cotSaveBtn").click(function() {
		var id = $("#id").val();
		if (isNull(id)) {
			SSM.COT.saveCot();
		} else {
			SSM.COT.saveCot(id);
		}
	});
	// 取消按钮
	$("#cotCancelBtn").click(function() {
		SSM.COT.cotSaveCancel();
	})
	// 删除按钮
	$("#cotDelBtn").click(function() {
		// 获取选中的checkbox
		var ids = [];
		$("#myTable :input:checked").click(function() {
			ids.push($(this).val())
		});
		if (isNull(ids) || ids.length < 1) {
			showmsg("请至少选择一条记录以删除！");
		} else {
			SSM.COT.delCot(ids);
		}
	});
	// 查询按钮
	$("#cotGetBtn").click(function() {
		SSM.COT.getContents();
	})
});