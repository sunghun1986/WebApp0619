<%@page import="com.study.model.reboard.ReBoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! ReBoardDAO reBoardDAO = new ReBoardDAO();%>
<!-- 아래와 같이 태그이되, 서버에서만 실행될 수 잇는 태그를 가리켜
빈즈 태그라 한다!! bean태그를 이용하면, 코드량을 줄일수 있다! 

아래의 태그는 REBoard reboard = new ReBoard() 한것과 같다
-->
<jsp:useBean id="reboard" class="com.study.model.reboard.ReBoard"/>

<%request.setCharacterEncoding("utf-8"); %>

<!-- 아래의 태그는 VO를 생성한 후 setter 로 파라미터를 넣는 작업과 같다
	주의) 아래의 * 가 동작하려면, 반드시 html 파라미터명과 VO의 멤버 변수명이 같아야한다!!
-->
<jsp:setProperty property="*" name="reboard"/>

<!-- 아래의 태그는 out.print(reBoard.getTitle()); 과 동일
<jsp:getProperty property = "title" name="reboard"/>
<jsp:getProperty property = "writer" name="reboard"/>
<jsp:getProperty property = "content" name="reboard"/>
-->

<%
	//파라미터를 넘겨받아 오라클에 넣기!
	int result = reBoardDAO.insert(reboard);
	System.out.println(result);
	
%>