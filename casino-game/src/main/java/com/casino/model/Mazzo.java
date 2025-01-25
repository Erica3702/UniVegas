package com.casino.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 

public class Mazzo {

	private List<Card> carte;
	private int numMazzi;
	
	public Mazzo( int numMazzi) {
		if(numMazzi <=0) {
			throw new IllegalArgumentException("il numero di mazzi deve essere maggiore di zero");
		}
		carte = new ArrayList<>();
		this.numMazzi = numMazzi;
		creaMazzo();
		shuffle();
	}
	
	private void creaMazzo() {
		String[] semi = { "Cuori", "Quadri", "Fiori", "Picche" };
        String[] rango = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        int[] values = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };

        for (int d= 0; d < numMazzi; d++) {
        for (String seme : semi) {
            for (int i = 0; i < rango.length; i++) {
                carte.add(new Card(rango[i], seme, values[i]));
            }
        }
	  }
	}
	
	
	
	
	public void shuffle() {
		Collections.shuffle(carte);
	}
	
	public Card pescaCarta() {
		if(!carte.isEmpty()) {
			return carte.remove(0);
		} else {
			throw new IllegalStateException("Il mazzo è vuoto");
		}
	}
	
	public int getCarteRimanenti() {
		return carte.size();
	}
	
	public void reset() { //se il mazzo si svuota genera nuove carte
		carte.clear();
		creaMazzo();
		shuffle();
	}
	
	
}
