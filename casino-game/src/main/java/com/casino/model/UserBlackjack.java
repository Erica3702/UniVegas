package com.casino.model;

import java.util.List;

public class UserBlackjack extends User{

	public UserBlackjack(String username, String password, int token, List<Card> mano) {
		super(username, password, token, mano);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcolaValoreMano() {
		// TODO Auto-generated method stub
		return 0;
	}

}
