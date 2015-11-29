<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                 <h2>註冊成功!</h2>
                     				  
				 <h2>帳號: ${ memberBean.username }<BR></h2> 
				 <h2>密碼: ${ memberBean.password }<BR></h2> 
				 <h2>信箱: ${ memberBean.email }<BR></h2> 
              </div>		
              		
              	</table>
              </form>
        </div>  
        
       
<jsp:include page="/includes/footer.jsp" />
</body>
</html>