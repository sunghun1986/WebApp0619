<%@page import="com.study.model.store.Icons"%>
<%@page import="com.study.model.store.IconsDAO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/json; charset=UTF-8"%>
<%!
	IconsDAO iconsDAO = new IconsDAO();
%>

<%
	//아이콘 목록 출력하기!!
	//이 jsp 는 클라이언트가 비동기인지,동기인지 모른다
	List<Icons> iconsList = iconsDAO.selectAll();

	StringBuilder sb = new StringBuilder();
	sb.append("{");
	sb.append("\"iconsList\":[");
	for(int i = 0; i<iconsList.size();i++){
		Icons icons = iconsList.get(i);
		sb.append("{");
		sb.append("\"icons_id\":"+icons.getIcons_id()+",");
		sb.append("\"title\":\""+icons.getTitle()+"\",");
		sb.append("\"filename\":\""+icons.getFilename()+"\"");
		if(i<iconsList.size()-1){
			sb.append("},");//마지막데이터는 쉼표가 없어야 한다!
		}else{
			sb.append("}");
		}
	}
	
	sb.append("]");
	sb.append("}");
	
	out.print(sb.toString());
%>




