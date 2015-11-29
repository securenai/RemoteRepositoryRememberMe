<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body class="body_article">
<jsp:include page="/includes/header.jsp" />
        <div id="container">
              <div class="member">
                 <h2>註冊失敗...register failed...</h2>
                 <c:if test="${not empty ErrorMsg}">
                 <font color='red'>
                 	請修改下列錯誤
                 	<ul>
                 	<c:forEach var="aMsg" items="${ErrorMsg}">
                 		<li>${aMsg}</li>
                 	</c:forEach>
                 	</ul>
                 </font>    
                 </c:if>
              </div>		
        </div>  
</body>
</html>