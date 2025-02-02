package com.casino.model;

import java.util.ArrayList;
import java.util.List;

public abstract class User {

	
	private String username;
	private  String password;

	private int token;
	private List<Card> mano;
	private boolean inGioco;

	
	
	public User(String username, String password) {
		super();
		
		this.username = username;
		this.password = password;

		this.token = token;
		this.mano = new ArrayList<>(mano);
		this.inGioco = true;
	}
	
	public boolean isInGioco() {
		return inGioco;
	}
	
	public void setInGioco(boolean inGioco) {
		this.inGioco = inGioco;

	}
	
	public String getUsername() {
		return username;
	}
	

	 
	public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	

	public boolean puòPuntare(int puntata) {
		return puntata<=token;
	}
	
	public void effettuaPuntata(int puntata) {
		if(puntata>token) {
			throw new IllegalArgumentException("puntata maggiore dei token disponibili");
		}
		aggiornaToken(-puntata);
	}
	
	public void resetMano() {
		mano.clear();
	}
	
	public String visualizzaMano() {
		StringBuilder sb = new StringBuilder();
		for(Card carta : mano) {
			sb.append(carta.toString()).append(", ");
		}
		return sb.toString().trim();
	}
	
	public int getTokens() {
		return token;
	}
	
	public void aggiornaToken(int amount) {
		token = token + amount;
        if (token < 0) {
            token = 0; // Impedisce di scendere sotto zero
        }
	}

	

    
    // Aggiungi token
    public void aggiungiToken(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Non puoi aggiungere un valore negativo.");
        }
        this.token += amount;
    }

    public void aggiungiCarta(Card carta) {
        mano.add(carta);
    }
	
    public abstract int calcolaValoreMano();
}
