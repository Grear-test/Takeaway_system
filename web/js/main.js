
$(function (){
	// 获取本地存储中的用户信息
	let userinfo = localStorage.getItem("userinfo")
	userinfo = JSON.parse(decodeURI(userinfo))
	console.log(userinfo);
	if(userinfo){
		$("#login_name").html(userinfo.uname)
		$('#login_reg').html("退出")
		$('#login_reg').prop("href","#")
		$('#login_name').prop("href","#")
	}

	$('#login_reg').click(function(){
		if($('#login_reg').text()=="退出"){
			console.log('logout');
			localStorage.removeItem("userinfo");
			$.get(
				"/user?type=logout",
				function(data){
					console.log(data);
					if(data.code==200){
						window.location.href='./main.html?'+new Date().getTime();
					}
				},
				"json"
			)
			return false;
		}

	})
	// 给所有请求添加请求头
	$(document).ajaxSend(function(event, xhr) {
		xhr.setRequestHeader('Authorization', localStorage.getItem("userinfo")); // 增加一个自定义请求头
	});
})


