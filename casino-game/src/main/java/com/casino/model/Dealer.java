package com.casino.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Dealer {

	private List<Card> mano;
	private Mazzo mazzo;
	private int piatto;
	private int turnoCorrente;
	private List<Card>carteComuni;
	 
	public Dealer() {
		 this.mano = new ArrayList<>();
	 }
	
	public List<Card> getMano(){
		return mano;
	}
	
	public void distribuisciCarte(List<User> giocatori) {
		for(User giocatore : giocatori) {
			giocatore.aggiungiCarta(mazzo.pescaCarta());
			giocatore.aggiungiCarta(mazzo.pescaCarta());
		}
	}
	
	public void mostraFlop() {
		mano.add(mazzo.pescaCarta());
		mano.add(mazzo.pescaCarta());
		mano.add(mazzo.pescaCarta());
	}
	
	public void mostraTurn() {
		mano.add(mazzo.pescaCarta());
	}
	
	public void mostraRiver() {
		mano.add(mazzo.pescaCarta());
	}
	
	public void aggiungiCarta(Card carta) {
		mano.add(carta);
	}
	
	public void resetMano() {
		mano.clear();
	}
	
	public void aggiungiAlPiatto(int puntata) {
		piatto +=puntata;
	}
	
	public void assegnaPiatto(User vincitore) {
		vincitore.aggiungiToken(piatto);
		piatto=0;
	}
	
	public void resetPartita(){
		carteComuni.clear();
		mazzo.reset();
		piatto=0;
		
	}
	
	public void prossimoTurno(int numGiocatori) {
		turnoCorrente =(turnoCorrente+1)%numGiocatori;
	}
	
	//public User calcolaVincitore(List<User> giocatori) {///////////////////////////////////////////////////
		//Logica per determinare il giocatore con la mano migliore 
		// TODO : Implementare le regole di confronto delle mani
		//return giocatoreConManoMigliore;
	//}
	

	public abstract int calcolaValoreMano();
}
