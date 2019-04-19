$(function() {
	$('#searchBtn').click(function() {
		if ($('#userId').val() == "") {
			alert("ユーザIDを入力してください。");
			return;
		}
		$.ajax({
			type : "GET",
			url : "./findUserName/" + $('#userId').val(),
			dataType : "json",
			success : function(data) {
				var $laberContent = $('#userName').empty();
				if (data == "0") {
					alert("ユーザIDが存在しません。");
				} else if ((data == "-1")) {
					alert("サービスがアクセスできません。");
				} else {
					var html = "";
					html = '<span>' + data.userName + '</span>';
					$laberContent.append($(html));
				}
			}
		});
	});
});
