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
        <h2>加入會員<hr></h2>
        <h4>join member</h4>
        <h4>會員服務<br>成為會員後可以線上訂購本店周邊產品 接收電子報 </h4>
        </div>
        
        
        <div>
              <form action="../controller/ProcessMember" method="POST">
              
              	<div class="formWrapper">
<!------------------------------------帳號----------------------------------------->
              		<table id="from_table">
              		<tr>
              			<td class="td_title">帳號</td>
              			<td class="td_content"><input class="txt" type="text" size="35" 
              				name="username" value="${param.username}"/></td>
              			<td>${ErrorMsg.username}</td>
              		</tr>				
<!------------------------------------密碼----------------------------------------->
					<tr>
              			<td class="td_title">密碼</td>
              			<td class="td_content"><input class="txt" type="password" size="35" 
              				name="password" value="${param.password}"/></td>
              			<td>${ErrorMsg.password}</td>
              		</tr>
              		<tr>
              			<td class="td_title">確認密碼</td>
              			<td class="td_content"><input class="txt" type="password" size="35" name="password"/></td>
              			<td>${ErrorMsg.password}</td>
              		</tr>
<!------------------------------------姓名----------------------------------------->
					<tr>
              			<td class="td_title">姓名</td>
              			<td class="td_content"><input class="txt" type="text" size="35" name="name"/></td>
              			<td>${ErrorMsg.name}</td>
              		</tr>
<!------------------------------------性別----------------------------------------->
					
					<tr>
              			<td class="td_title">性別</td>
              			<td class="td_content">
	              			<input class="txt" type="radio" name="gender" value="M"/>M 男
	              			<input class="txt" type="radio" name="gender" value="F"/>F 女
              			</td>
              			<td>${ErrorMsg.gender}</td>
              		</tr>
<!------------------------------------生日----------------------------------------->
					<tr>
              			<td class="td_title">生日</td>
              			<td class="td_content"><input class="txt" type="text" size="35" name="birthday"/></td>
              			<td>${ErrorMsg.birthday}</td>
              		</tr>
<!------------------------------------電話----------------------------------------->
					<tr>
              			<td class="td_title">電話</td>
              			<td class="td_content"><input class="txt" type="text" size="35" name="phone"/></td>
              			<td>${ErrorMsg.phone}</td>
              		</tr>		
<!------------------------------------信箱----------------------------------------->
              		<tr>
              			<td class="td_title">信箱</td>
              			<td class="td_content"><input class="txt" type="email" size="35" name="email"/></td>
              			<td>${ErrorMsg.email}</td>
              		</tr>	
<!------------------------------------地址----------------------------------------->
					<tr>
              			<td class="td_title">地址</td>
              			<td class="td_content"><input class="txt" type="text" size="35" name="address"/></td>
              			<td>${ErrorMsg.address}</td>
              		</tr>		
					</table>
					<input id="gobutton" type="submit"  value="提交"/>
					<input id="gobutton" type="reset"  value="重填"/>
              		
              	</div>
              </form>
             </div>
              <h4>已註冊會員 立即<a class="alogin"
               href="${pageContext.request.contextPath}/pages/login.jsp">登入</a></h4>
            </div> <!--end inner -->
         </div> <!--end container -->
        
       
<jsp:include page="/includes/footer.jsp" />
</body>
</html>