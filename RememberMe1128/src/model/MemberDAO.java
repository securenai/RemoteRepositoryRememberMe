package model;

import java.sql.SQLException;

public interface MemberDAO 
{
	MemberBean select(String username);
	
	public MemberBean insertMember(MemberBean bean) throws SQLException;
}
