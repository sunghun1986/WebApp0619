<%@page import="com.study.async.HotPlace"%>
<%@page import="java.util.List"%>
<%@page import="com.study.async.HotPlaceDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!HotPlaceDAO hpDAO = new HotPlaceDAO();%>
<%
	List<HotPlace> list = hpDAO.selectAll();

	StringBuilder sb = new StringBuilder();

sb.append("{");
sb.append("\"storeList\":[");
for(int i = 0; i<list.size();i++){
HotPlace hp = list.get(i);
sb.append("{");
sb.append("\"hotplace\":\""+hp.getHotplace_id()+"\",");
sb.append("\"name\":\""+hp.getName()+"\",");
sb.append("\"tel\":\""+hp.getTel()+"\",");
sb.append("\"addr\":\""+hp.getName()+"\",");
sb.append("\"food\":\""+hp.getFood()+"\"");
if(i==list.size()-1) sb.append("}");
else sb.append("},");

}

sb.append("]");
sb.append("}");

out.print(sb.toString());
%>



