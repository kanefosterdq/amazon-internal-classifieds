package com.amazon.classified.model;

public class User {
	//create table user (login varchar(100) primary key,name varchar(100),password varchar(100),
	//location varchar(100),email varchar(100), phone varchar(100)
	private String login;
	private String name;
	private String password;
	private String location;
	private String email;
	private String phone;
	
	//default constructor
	public User()
	{
		
	}
	
	//parameterised constructor
	public User(String login, String name, String password, String location, String email, String phone) {
		super();
		this.login = login;
		this.name = name;
		this.password = password;
		this.location = location;
		this.email = email;
		this.phone = phone;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", name=" + name + ", password=" + password + ", location=" + location
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	
	
}
