package com.casino.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Blackjack {
	
	private UserBlackjack giocatore;
	private DealerBlackjack dealer;
	private String nome;
	private String password;
	private static final Logger logger = LogManager.getLogger(Blackjack.class);

	
	public Blackjack(UserBlackjack giocatore, int numMazzi) {
		this.giocatore = giocatore;
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
		 logger.info("Metodo calcolaPartita chiamato");
		int valoreGiocatore = giocatore.calcolaValoreMano();
		int valoreDealer = dealer.calcolaValoreMano();
		
		 logger.info("Valore giocatore: {}", valoreGiocatore);
		    logger.info("Valore dealer: {}", valoreDealer);
		    logger.info("Token iniziali: {}", giocatore.getTokens());
		    logger.info("Puntata corrente: {}", giocatore.getCurrentBet());

		if (valoreGiocatore > 21 || (valoreDealer <= 21 && valoreDealer > valoreGiocatore)) {
			giocatore.adjustTokens(-giocatore.getCurrentBet());
			logger.info("Giocatore ha perso. Token aggiornati: " , giocatore.getTokens());
		} else if(valoreGiocatore <= 21 && (valoreDealer > 21 || valoreGiocatore > valoreDealer)) {
			giocatore.adjustTokens(giocatore.getCurrentBet() );
			logger.info("Giocatore ha vinto. Token aggiornati: ",  giocatore.getTokens());
		}else {
	        logger.info("Pareggio. Token invariati: " , giocatore.getTokens());
	    }
	}
}
