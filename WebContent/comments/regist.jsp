<%@page import="com.study.model.news.News"%>
<%@page import="com.study.model.news.NewsDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
 	NewsDAO newsdao = new NewsDAO();

%>
<%

	//입력폼에서 전송된 파라미터 받아서 DAO의 insert 메서드를 호출하자!!
	request.setCharacterEncoding("utf-8");//파라미터 받기전에 인코딩
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
		
	//DAO에게 일시키기
	News news = new News();
	
	news.setTitle(title);
	news.setWriter(writer);
	news.setContent(content);
	
	int result = newsdao.insert(news);
	
	if(result !=0){
		out.print("<script>");
		out.print("alert('등록성공');");
		out.print("location.href='/comments/list.jsp';");
		out.print("</script>");
	}else{
		out.print("<script>");
		out.print("alert('등록실패');");
		out.print("location.href='/comments/list.jsp';");
		out.print("</script>");
	}
%>








