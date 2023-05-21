<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testlist</title>
</head>
<body>
testList Page.!!!   
<%
	System.out.println("testlist.. jsp log.."); 
%>
<br/>
<%
java.util.List<java.util.Map> list=(java.util.List)request.getAttribute("testlist");
for(int i=0; i < list.length;i++) {
	java.util.Map fmap=(java.util.Map)list.get(i);
%>
	<%=fmap.get("grp_id")%>
<%
}
%>
</body>
</html>