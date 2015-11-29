package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.MemberBean;
import model.MemberDAO;

public class MemberDAOJdbc implements MemberDAO
{
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=RememberMeDB";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "P@ssw0rd";
	
	private DataSource dataSource;
	public MemberDAOJdbc() 
	{
		try 
		{
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_BY_PASSWORD = "select * from member where memberId=?";
	

	@Override
	public MemberBean select(String username) 
	{	
		MemberBean result = null;
		ResultSet rset = null;
		
		try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();	
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PASSWORD);)
			
			{
			pstmt.setString(1, username);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new MemberBean();
				result.setUsername(rset.getString("memberId"));
				result.setPassword(rset.getString("mPassword"));
				result.setName(rset.getString("name"));
				result.setGender(rset.getString("gender"));
				result.setBirthday(null);
				result.setPhone(rset.getString("phone"));
				result.setEmail(rset.getString("email"));
				result.setAddress(rset.getString("mAddress"));
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("sorry...." + e.getMessage());
		}
		finally 
		{
			if (rset!=null) 
			{
				try 
				{
					rset.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	//private static final String INSERT_MEMBER = "Insert into member (memberId,mPassword,email) values (?, ?, ?)";
	private static final String INSERT_MEMBER = 
	"Insert into member (memberId,mPassword,name,gender,birthday,phone,email,mAddress) values (?,?,?,?,?,?,?,?)";
	
	@Override
	public MemberBean insertMember(MemberBean bean) throws SQLException 
	{
		MemberBean result = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
		try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();	
			PreparedStatement pstmt = conn.prepareStatement(INSERT_MEMBER);)
		{
			pstmt.setString(1, bean.getUsername());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getGender());
			pstmt.setDate(5, null);
			pstmt.setString(6, bean.getPhone());
			pstmt.setString(7, bean.getEmail());
			pstmt.setString(8, bean.getAddress());
			pstmt.executeUpdate();	
		} 
		
//		catch (SQLException e) 
//		{
//			System.out.println("sorry...." + e.getMessage());
//		}
		return result;
	}
	
	
	public static void main(String[] args) 
	{
		MemberDAOJdbc mBean = new MemberDAOJdbc();
		//MemberBean bean = new MemberBean("michaelnccu@hotmail.com","0958067415","securenai3");
		//mBean.insertMember(bean);
		
		
		//MemberBean bean = mBean.select("securenai","securenai3333");
		//System.out.println(bean);
	}

}
