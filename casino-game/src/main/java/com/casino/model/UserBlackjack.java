package com.casino.model;

import java.util.ArrayList;
import java.util.List;

public class UserBlackjack extends User{

	
	private List<Card> mano;
	private Blackjack blackjack;

	public UserBlackjack() {
	}

	
	public void resetMano() {
		mano.clear();
	}


	//public void hit(Mazzo mazzo) {
		//blackjack.playerHit();}


	//public void stay() {
		//blackjack.playerStay();}
	
	
}
