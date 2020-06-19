<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
	position: relative;
	left: -2000px;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	//문서가 로드되어야 생성된 DOM에 접근할 수 있으므로.
	$(function() {
		$("table").animate({
			left : '0px' // js style.left 와 동일
		});
	});
</script>
</head>
<body>

	<h2>Zebra Striped Table</h2>
	<p>For zebra-striped tables, use the nth-child() selector and add a
		background-color to all even (or odd) table rows:</p>

	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>Jill</td>
			<td>Smith</td>
			<td>50</td>
			<td>50</td>
			<td>50</td>
		</tr>
		<tr>
			<td colspan="5">
				<button onClick="location.href='/comments/registForm.jsp';">글등록</button>
			</td>
		</tr>
	</table>

</body>
</html>










