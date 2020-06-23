<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//클라이언트가 전송한 파라미터값들을 이용하여 오라클에 넣기!
	//서버측에서는 클라이언트의 통신 방식이 동기냐 비동기냐 관심없다!!
	request.setCharacterEncoding("utf-8");//파라미터 안깨지게
	
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String addr = request.getParameter("addr");
	String food = request.getParameter("food");
	
	System.out.print(name);
	System.out.print(tel);
	System.out.print(addr);
	System.out.print(food);
%>










