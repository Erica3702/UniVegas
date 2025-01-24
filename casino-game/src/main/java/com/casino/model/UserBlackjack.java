package com.casino.model;

import java.util.ArrayList;
import java.util.List;

public class UserBlackjack extends User{

	private int tokens;
	private List<Card> mano;
	private int currentBet;

	public UserBlackjack(String username, String password) {
		super(username, password);
		this.tokens= 500;
		this.currentBet = 0;
		this.mano = new ArrayList<>();
	}

	@Override
	public int calcolaValoreMano() {
		int valore = 0;
		int assi = 0;
		for (Card carta : mano) {
			valore += carta.getValue();
			if (carta.getValue() == 11) {
				assi++;
			}
		}
		while (valore > 21 && assi > 0) {
			valore -= 10;
			assi--;
		}
		return valore;
	}

	public int getTokens() {
		return tokens;
	}

	public void adjustTokens(int amount) {
		this.tokens += amount;
		//return tokens;
	}

	public List<Card> getMano() {
		return mano;
	}

	public void aggiungiCarta(Card carta) {
		mano.add(carta);
	}

	public void resetMano() {
		mano.clear();
	}
	
	public void setCurrentBet( int puntata) {
		if( puntata > 0 && puntata <= tokens ) {
			this.currentBet = puntata;
		} else {
			throw new IllegalArgumentException("Puntata non valida");
		}
	}
	
	public int getCurrentBet() {
		return this.currentBet;
	}

}
