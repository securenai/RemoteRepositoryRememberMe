package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.MemberService;


@WebServlet("/controller/LoginMember")
public class LoginMember extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public MemberService memberService = new MemberService();   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//接收資料
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
				
		if(username==null || username.length()==0) {
			errors.put("username", "請輸入ID");
		}
		if(password==null || password.length()==0) {
			errors.put("password", "請輸入PWD");
		}
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/pages/login.jsp").forward(request, response);
			return;
		}
		//呼叫Model
		MemberBean bean = memberService.login(username, password);	
		//根據Model執行結果，呼叫View
		if(bean==null) {
			errors.put("password", "登入失敗，請再試一次");
			request.getRequestDispatcher(
					"/pages/login.jsp").forward(request, response);
		} else {//登入成功!
			HttpSession session = request.getSession();
			//將bean物件放入Session範圍內,識別字串為"user"
			session.setAttribute("user", bean);

			String path = request.getContextPath();
			response.sendRedirect(path+"/index.jsp");
			
			
		}
	}

}
