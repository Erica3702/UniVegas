package com.casino.model;

import java.util.List;

public abstract class Dealer {

	private List<Card> mano;
	 
	public Dealer() {
		 this.mano = mano;
	 }
	
	public List<Card> getMano(){
		return mano;
	}
	
	public void aggiungiCarta(Card carta) {
		mano.add(carta);
	}
	
	public void resetMano() {
		mano.clear();
	}
	
	public abstract int calcolaValoreMano();
}
