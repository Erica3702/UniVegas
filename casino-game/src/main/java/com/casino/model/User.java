package com.casino.model;

import java.util.List;

public abstract class User {

	private String username;
	private  String password;
	private int token;
	private List<Card> mano;
	
	public User(String username, String password, int token, List<Card> mano) {
		super();
		this.username = username;
		this.password = password;
		this.token = token;
		this.mano = mano;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getTokens() {
		return token;
	}
	
	public void aggiornaToken(int amount) {
		token = token + amount;
	}
	
	public List<Card> getMano(){
		return mano;
	}
	
	public abstract int calcolaValoreMano();
}
