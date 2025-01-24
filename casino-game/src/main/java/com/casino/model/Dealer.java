package com.casino.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Dealer {

	private List<Card> mano;
	 
	public Dealer() {
		 this.mano = new ArrayList<>();
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
