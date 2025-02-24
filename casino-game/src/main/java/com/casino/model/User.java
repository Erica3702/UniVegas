package com.casino.model;

import java.util.ArrayList;

public class User {

	private boolean inGioco;


	 private ArrayList<Card> hand;
	    private int sum;
	    private int aceCount;

	    public User() {
	        hand = new ArrayList<>();
	        sum = 0;
	        aceCount = 0;
	    }

	    public void addCard(Card card) {
	        hand.add(card);
	        sum += card.getCardValue();
	        if (card.isAce()) {
	            aceCount++;
	        }
	    }

	    public int getSum() {
	        return sum;
	    }

	    public ArrayList<Card> getHand() {
	        return hand;
	    }


	    public int reduceAce() {
	        while (sum > 21 && aceCount > 0) {
	            sum -= 10;
	            aceCount--;
	        }
	        return sum;
	    }


	public boolean isInGioco() {
		return inGioco;
	}

	public void setInGioco(boolean inGioco) {
		this.inGioco = inGioco;

	}


	public void resetMano() {
		hand.clear();
	}

	public String visualizzaMano() {
		StringBuilder sb = new StringBuilder();
		for(Card carta : hand) {
			sb.append(carta.toString()).append(", ");
		}
		return sb.toString().trim();
	}


    public ArrayList<Card> getMano() {
        return hand;
    }
}