package model;

import java.util.Date;

public class MemberBean {
	private String username;
	private String password;
	private String name;
	private String gender;
	private java.util.Date birthday;
	private String phone;
	private String email;
	private String address;
	
	public MemberBean() {
	
	}
	public MemberBean(String username,String password,String email) 
	{
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public MemberBean(String username,String password,String name,
					  String gender,Date birthday,String phone,
					  String email,String address) 
	{
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.address = address;		
	}
	public MemberBean(String username, String password, String name,
			String gender, String phone, String address, String email) 
	{
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		//this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() 
	{
		return "[username=" + username + ", password=" + password
				+ ", name=" + name + ", gender=" + gender + ", birthday="
				+ birthday + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + "]";
	}
}
