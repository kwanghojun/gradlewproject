<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
  $(
      function() {
        $( "#button" ).on( "click", function() {
      	    $( "#dialog" ).dialog();
    	});
    	
    	$( "#dialog" ).dialog('close');
    	
      }
        	
  );
  
  ( function(factory) {
  		console.log('factory='+factory);
    }
  ) ( function($) {
        console.log('function2');
      }
    ) 
</script>
</head>
<body>
Home Page.!!!  1234  1234 aaaa
<%
	System.out.println("home page.. jsp log..["+request.getAttribute("test")+"]...");
%>
<br/>
<button id="button">run</button>
<%=request.getAttribute("test")%>


<div id="dialog">
	popupmesage
</div>
</body>
</html>