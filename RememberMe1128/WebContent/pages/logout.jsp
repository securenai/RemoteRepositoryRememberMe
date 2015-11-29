
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<%@ page language="java" %> 


<% if(session.getAttribute("user")!=null) { 
 	session.invalidate();
 	out.println("Successfully Logged out.");
 	%> 
     <script type="text/javascript"> 
 function Redirect()
 {
     window.location="../index.jsp";
 }
 document.write("You will be redirected to main page in a few sec.");
 setTimeout('Redirect()', 1000);
 </script> 
 <% 
 }
 else
 {%> 
 You're already Logged out.  
 Click <a href="../index.jsp">here</a> to go to the home page. 
 <%}%> 
</body>
</html>