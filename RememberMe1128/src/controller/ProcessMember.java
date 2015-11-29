package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.MemberDAO;
import model.dao.MemberDAOJdbc;

@WebServlet("/controller/ProcessMember")
public class ProcessMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
		
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException
	{
		// 定義存放錯誤訊息的 Collection物件
		Map<String, String> errorMessage = new HashMap<String, String>();
		//Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg",errorMessage );
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		// 檢查使用者所輸入的資料
		if(username == null || username.trim().length()==0)
		{
			errorMessage.put("username","帳號欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料，注意大小寫
		String password = request.getParameter("password");
		// 檢查使用者所輸入的資料
		if(password == null || password.trim().length()==0)
		{
			errorMessage.put("password","password欄必須輸入!");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 Name欄位內的資料
		String name = request.getParameter("name");
		// 讀取使用者所輸入，由瀏覽器送來的 gender欄位內的資料
		String gender = request.getParameter("gender");
		// 讀取使用者所輸入，由瀏覽器送來的 birthday欄位內的資料
		String birthday = request.getParameter("birthday");
		//將birthday轉換成Date型別
		
		// 讀取使用者所輸入，由瀏覽器送來的 Phone欄位內的資料
		String phone = request.getParameter("phone");
		// 讀取使用者所輸入，由瀏覽器送來的 email欄位內的資料
		String email = request.getParameter("email");
		// 讀取使用者所輸入，由瀏覽器送來的 address欄位內的資料
		String address = request.getParameter("address");
		if(email == null || email.trim().length()==0)
		{
			errorMessage.put("email","email欄必須輸入!");
		}
		
		if(!errorMessage.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("/pages/register.jsp");
			rd.forward(request, response);
			return;
		}
		
		//MemberBean mb = new MemberBean(username,password,email);//傳進來
		MemberBean mb = new MemberBean(username,password,name,gender
				,phone,email,address);
		try 
		{
			/***********************************/
			MemberDAO mDao = new MemberDAOJdbc();
			mDao.insertMember(mb);
			/***********************************/
			
			request.setAttribute("memberBean", mb);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/InsertMemberSuccess.jsp");
			rd.forward(request, response);
			return;
		} 
		catch (IOException e) 
		{
			errorMessage.put("username","格式錯誤" + e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/pages/InsertMemberError.jsp");
			rd.forward(request, response);
			return;
		} 
		catch (SQLException e) 
		{
			if (e.getMessage().indexOf("重複的索引鍵") != -1 || 
					e.getMessage().indexOf("Duplicate entry") != -1) 
			{
				errorMessage.put("username","帳號重複，請重新輸入帳號");
			} 
			else 
			{
				errorMessage.put("username","資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/pages/InsertMemberError.jsp");
			rd.forward(request, response);
			return;
		}
		
		
	}

}
