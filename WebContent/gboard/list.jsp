<%@page import="com.study.model.gboard.GBoard"%>
<%@page import="java.util.List"%>
<%@page import="com.study.model.gboard.GBoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	GBoardDAO gboardDAO = new GBoardDAO();	
%>
<%
	List<GBoard> list = gboardDAO.selectAll();
%>
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
<script src="//cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<h2>갤러리 목록</h2>

	<table>
		<tr>
			<th width="5%">No</th>
			<th width="15%">이미지</th>
			<th width="50%">제목</th>
			<th width="10%">작성자</th>
			<th width="10%">등록일</th>
			<th width="10%">조회수</th>
		</tr>
		<%int total = list.size(); %>
		<%for(int i = 0; i < list.size(); i++){ %>
		<%GBoard gboard = list.get(i);%>
		<tr>
			<td><%=total--%></td>
			<td><img src="/data/<%=gboard.getFilename()%>" width="50px"></td>
			<td><a href="/gboard/content.jsp?gboard_id=<%=gboard.getGboard_id()%>"><%=gboard.getTitle()%></a></td>
			<td><%=gboard.getWriter()%></td>			
			<td><%=gboard.getRegdate().substring(0,10)%></td>
			<td><%=gboard.getHit()%></td>
		</tr>
		
		<%}%>
		<tr>
			<td colspan="6">
				<button onClick="location.href='/gboard/registForm.jsp';">등록</button>
			</td>
		</tr>
	</table>

</body>
</html>
