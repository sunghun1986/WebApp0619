<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=button] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=button]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		CKEDITOR.replace('content');
		
		$($("input[type='button']")[1]).click(function(){
			location.href="/gboard/list.jsp";
		});		
	});

	//파일을 포함한 댈ㅇ의 데이터를 웹서버 요청시 가져가려면?
	//http 의 전송방식중 post를 이용해야한다!
	//전송하는 데이터중 파일이 포함되어 잇을경우(바이너리파일)
	//form의 속성에 반드시 multipart/form-data 지정되어있어야함
	function regist() {
		$("form").attr({
			"method":"post",
			"enctype":"multipart/form-data",
			"action":"/gboard/upload.jsp"
		});
		$("form").submit();
	}
</script>
</head>
<body>

	<h3>글작성</h3>

	<div class="container">
		<form>
			<input type="text" name="title" placeholder="Title"> <input
				type="text" name="writer" placeholder="Your name"> <input
				type="file" name="imgFile" />
			<textarea id="content" name="content" placeholder="Write something.."
				style="height: 200px"></textarea>
			<input type="button" value="등록" onClick="regist()" />
			<input type="button" value="목록"/>
		</form>
	</div>
</body>
</html>
