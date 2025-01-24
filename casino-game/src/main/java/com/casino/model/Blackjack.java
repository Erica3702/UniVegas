package com.casino.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 

public class Blackjack {
	
	private UserBlackjack giocatore;
	private DealerBlackjack dealer;
	private String nome;
	private String password;
	
	
	public Blackjack(UserBlackjack giocateore, int numMazzi) {
		this.giocatore = new UserBlackjack(nome, password);
		this.dealer = new DealerBlackjack();
	}
	
	public UserBlackjack getPlayer() {
		return giocatore;
	}
	
	public DealerBlackjack getDealer() {
		return dealer;
	}

	public void iniziaPartita() {
		giocatore.resetMano();
		dealer.resetMano();
	}
	
	public void calcolaPartita() {
		int valoreGiocatore = giocatore.calcolaValoreMano();
		int valoreDealer = dealer.calcolaValoreMano();
		
		if (valoreGiocatore > 21 || (valoreDealer <= 21 && valoreDealer > valoreGiocatore)) {
			giocatore.adjustTokens(- giocatore.getCurrentBet());
		} else if(valoreGiocatore <= 21 && (valoreDealer > 21 || valoreGiocatore > valoreDealer)) {
			giocatore.adjustTokens(giocatore.getCurrentBet() * 2);
		}
	}
}
