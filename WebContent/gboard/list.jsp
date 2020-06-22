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
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>

	<h2>갤러리 목록</h2>

	<table>
		<tr>
			<th>No</th>
			<th>이미지</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		
		<tr>
			<td>1</td>
			<td>Smith</td>
			<td>안녕하세용</td>
			<td>최성헌</td>
			<td>2020-06-22</td>
			<td>2</td>
		</tr>
		<tr>
			<td colspan="6">
				<button onClick="location.href='/gboard/registForm.jsp';">등록</button>
			</td>
		</tr>
	</table>

</body>
</html>
