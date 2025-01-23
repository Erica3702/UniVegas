package com.casino.model;

public class User {

	private String username;
	private String email;
	private String password;
	private int saldo;
	
	public User(String username, String email, String password, int saldo) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.saldo = saldo;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getSaldo() {
		return saldo;
	}
	
	
	
	
}
