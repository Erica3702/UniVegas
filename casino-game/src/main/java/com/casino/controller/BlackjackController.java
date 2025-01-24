package com.casino.controller;

import com.casino.model.Blackjack;
import com.casino.model.DealerBlackjack;
import com.casino.model.Mazzo;
import com.casino.model.UserBlackjack;
import com.casino.*;

public class BlackjackController {

	private UserBlackjack giocatore;
	private DealerBlackjack dealer;
	private Mazzo mazzo;
	private String password;
	private Blackjack blkjack;
	
	public BlackjackController(String nomeGiocatore) {
		this.giocatore = new UserBlackjack(nomeGiocatore, password);
		this.dealer = new DealerBlackjack();
		this.mazzo = new Mazzo(8);
		this.mazzo.shuffle();
		this.blkjack = new Blackjack(giocatore, 8);
	}
	
	public UserBlackjack getGiocatore() {
		return giocatore;
	}
	
	public DealerBlackjack getDealer() {
		return dealer;
	}
	
	public void iniziaNuovoRound(int puntata) {
		giocatore.setCurrentBet(puntata);
		giocatore.resetMano();
		dealer.resetMano();
		giocatore.aggiungiCarta(mazzo.pescaCarta());
		giocatore.aggiungiCarta(mazzo.pescaCarta());
		dealer.aggiungiCarta(mazzo.pescaCarta());
	}
	
	public String hit() {
		giocatore.aggiungiCarta(mazzo.pescaCarta());
		if(giocatore.calcolaValoreMano() > 21) {
			return "Hai perso!";
		}
		return "Carta aggiunta alla mano";
	}
	
	public String stand() {
		while(dealer.calcolaValoreMano() < 17) {
			dealer.aggiungiCarta(mazzo.pescaCarta());
		}
		calcolaPartita();
		int valoreGiocatore = giocatore.calcolaValoreMano();
		int valoreDealer = dealer.calcolaValoreMano();
		
		if (valoreDealer > 21 || valoreGiocatore > valoreDealer) {
			return "Hai vinto!";
		}else if (valoreGiocatore == valoreDealer) {
			return "Pareggio";
		}else {
			return "Hai perso";
		}
	}
	
	public void calcolaPartita() {
		blkjack.calcolaPartita();
	}
}
