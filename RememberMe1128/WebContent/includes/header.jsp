<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
</head>

<body>
	<div id="header">
	<div>
		<div class="inner_header">
		<h1>
			<a href="<c:url value='/index.jsp'/> " class="nav_a">Remember me</a>
		</h1>
		<nav id="nav">
			<ul id="main-nav">
				<li><a class="nav_a">簡介</a></li>
				<li><a href="<c:url value='/pages/page2.jsp'/> " class="nav_a">文章</a></li>
				<li><a class="nav_a">菜單</a></li>		
				<li><a href="<c:url value='/pages/ProductList.jsp'/> " class="nav_a">產品</li>
				<li><a href="<c:url value='/pages/MessageBoard.jsp'/> " class="nav_a" >聯絡</a></li>	
			</ul>
		</nav>
		
<%-- 		<% if(session.getAttribute("user")==null) {%> --%>
<%--         <a href="<c:url value='/pages/login.jsp'/>">登入</a> --%>
<%--         <%} else {%> --%>
<%--         <a href="${pageContext.request.contextPath}/controller/LogoutMember"><span>${user.username} </span> 登出</a> --%>
<%--         <%}%>	 --%>
        
<%--         <a href="<c:url value='/pages/register.jsp'/>"> 註冊</a> --%>
		</div>
		
		<div id="functions">
			<ul id="main-nav">
				<% if(session.getAttribute("user")==null) {%>
				<li><a href="<c:url value='/pages/login.jsp'/>">登入</a></li>
				<%} else {%>
				<a href="${pageContext.request.contextPath}/controller/LogoutMember"><span>${user.username} </span> 登出</a>
				<%}%>
				<li><a href="<c:url value='/pages/register.jsp'/>"> 註冊</a></li>
				<li><a>購物車</a></li>		
			</ul>
		</div>
		
		
		
		
		</div>
	</div>	
</body>

</html>

<%-- <c:url value='/pages/logout.jsp'/> --%>