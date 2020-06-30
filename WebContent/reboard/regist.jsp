<%@page import="com.study.model.reboard.ReBoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!ReBoardDAO reboardDAO = new ReBoardDAO();%>
<jsp:useBean id="reboard" class="com.study.model.reboard.ReBoard"/>
<%request.setCharacterEncoding("utf-8");%>
<jsp:setProperty property="*" name="reboard"/>
<%
	int result = reboardDAO.insert(reboard);
	System.out.println(result);
	
	response.sendRedirect("/reboard/list.jsp");
	
	
%>