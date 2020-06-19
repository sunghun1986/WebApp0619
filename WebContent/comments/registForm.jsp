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

input[type=submit] {
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
$(function(){
	CKEDITOR.replace( "content" );
});
</script>
</head>
<body>

	<h3>Contact Form</h3>

	<div class="container">
		<form action="/action_page.php">
			<input type="text" id="fname"	name="firstname" placeholder="Your name..">
			<input type="text" id="lname"	name="lastname" placeholder="Your last name..">		
			<textarea id="content" name="subject" placeholder="Write something.."
				style="height: 200px"></textarea>
			<input type="submit" value="등록">
			<input type="submit" value="목록">
		</form>
	</div>

</body>
</html>









