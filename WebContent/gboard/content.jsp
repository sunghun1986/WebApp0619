<%@page import="com.study.model.gboard.GBoard"%>
<%@page import="com.study.model.gboard.GBoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	GBoardDAO gboardDAO = new GBoardDAO();	
%>
<%
	String gboard_id = request.getParameter("gboard_id");
	GBoard gboard = gboardDAO.select(Integer.parseInt(gboard_id));
%>
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

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}


</style>
<script src="//cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		CKEDITOR.replace("content");

		//수정버튼
		$($("input[type='button']")[0]).click(function() {
			location.href = "/gboard/list.jsp";
		});

		//목록버튼
		$($("input[type='button']")[1]).click(function() {
			location.href = "/gboard/list.jsp";
		});
		

	});
</script>
</head>
<body>

	<h3>상세보기</h3>

	<div class="container">
		<form>
			<input type="text" id="fname" name="title"
				value="<%=gboard.getTitle()%>"> <input type="text" id="lname"
				name="writer" value="<%=gboard.getWriter()%>">
				<input
				type="file" name="imgFile" value="<%=gboard.getFilename()%>" />
			<textarea id="content" name="content" style="height: 200px""><%=gboard.getContent()%></textarea>
			<input type="button" value="수정"> <input type="button"
				value="목록">
		</form>
	</div>
	
</body>
</html>









