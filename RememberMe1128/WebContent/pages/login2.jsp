<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-tw">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body class="body_article">
<jsp:include page="/includes/header.jsp" />

     <div id="container">
     	
     
        <div class="inner">
        
        <div class="about_register">
        <h2>管理者登入<hr></h2>
        <h4>admin login</h4>
        </div>
        
        
        <div>
              <form action="../controller/LoginAdmin" method="POST">
              
              	<div class="formWrapper">
<!------------------------------------帳號----------------------------------------->
              		<table id="from_table">
              		<tr>
              			<td class="td_title">帳號</td>
              			<td class="td_content"><input class="txt" type="text" size="30" name="username"/></td>
              			<td>${errors.username}</td>
              		</tr>				
<!------------------------------------密碼----------------------------------------->
					<tr>
              			<td class="td_title">密碼</td>
              			<td class="td_content"><input class="txt" type="password" size="30" name="password"/></td>
              			<td>${errors.password}</td>
              		</tr>
              		

					</table>
					<input id="gobutton" type="submit"  value="登入"/>
              		
              	</div>
              </form>
             </div>
            </div> <!--end inner -->
         </div> <!--end container -->
        
       
<jsp:include page="/includes/footer.jsp" />
</body>
</html>