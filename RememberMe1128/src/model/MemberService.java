package model;

import model.dao.MemberDAOJdbc;

public class MemberService 
{
	MemberDAO memberDao = new MemberDAOJdbc();
	
	public MemberBean login(String username, String password) 
	{
		MemberBean bean = memberDao.select(username);
		if(bean!=null) 
		{
			if(password!=null && password.length()!=0) 
			{
				String pass = bean.getPassword();//資料庫抓出的密碼
				String temp = password;          //使用者輸入的密碼
				if(pass.equals(temp)) 
				{
					return bean;
				}
			}
		}
		return null;
	}
}
