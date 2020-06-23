<%@ page contentType="text/html; charset=UTF-8"%>
<%
StringBuilder sb = new StringBuilder();

sb.append("{");
sb.append("\"storeList\":[");
sb.append("{");
sb.append("\"name\":\"종로김밥\",");
sb.append("\"tel\":\"02-730-9888\",");
sb.append("\"addr\":\"서울시 종로구\",");
sb.append("\"food\":\"삼각김밥\"");
sb.append("},");
sb.append("{");
sb.append("\"name\":\"춘천닭갈비\",");
sb.append("\"tel\":\"051-332-9999\",");
sb.append("\"addr\":\"강원도 춘천\",");
sb.append("\"food\":\"매운닭갈비\"");
sb.append("}");
sb.append("]");
sb.append("}");

out.print(sb.toString());

%>