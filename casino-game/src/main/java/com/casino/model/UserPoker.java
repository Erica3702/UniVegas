package com.casino.model;

import java.util.List;

public class UserPoker extends User{
	
	private int puntataCorrente; 
	
	public UserPoker( List<Card> mano) {
		this.puntataCorrente = 0;

	}

	
	
	public int getPuntataCorrente() {
		return puntataCorrente;
	}
	
	public void setPuntataCorrente(int puntata) {
		this.puntataCorrente = puntata;
	}
	

}
