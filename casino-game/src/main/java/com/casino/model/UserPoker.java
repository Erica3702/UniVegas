package com.casino.model;

import java.util.List;

public class UserPoker extends User{

	public UserPoker(String username, String password, int token, List<Card> mano) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcolaValoreMano() {
		// TODO Auto-generated method stub
		return 0;
	}

}
