<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
Login Page.!!!  
<%
	System.out.println("Login.. jsp log..["+request.getAttribute("test")+"]...");
%>
<br/>
<%=request.getAttribute("test")%>
</body>
</html>