<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
Home Page.!!!  1234  1234 aaaa
<%
	System.out.println("home page.. jsp log..["+request.getAttribute("test")+"]...");
%>
<br/>
<%=request.getAttribute("test")%>
</body>
</html>