package com.casino.model;

import java.util.List;

public class UserPoker extends User{
	
	private int puntataCorrente; 
	
	public UserPoker(String username, String password, int token, List<Card> mano) {
		super(username, password);
		this.puntataCorrente = 0;

	}

	@Override
	public int calcolaValoreMano() {
		// TODO Auto-generated method stub  ///////////////////////////////////////////////////////////////////////////
		return 0;
	}
	
	public int getPuntataCorrente() {
		return puntataCorrente;
	}
	
	public void setPuntataCorrente(int puntata) {
		this.puntataCorrente = puntata;
	}
	
	public boolean èEliminato() {
		return getTokens()<=0;
	}

}
