package com.casino.model;

public class CarteP implements Comparable<CarteP>{
	/*ATTRIBUTI STATICI*/
    /** Ranghi in un deck */
    public static final int NO_OF_RANKS = 13;
    
    /** num semi*/
    public static final int NO_OF_SUITS = 4;
    
    // i ranghi.
    public static final int ASSO      	= 12;
    public static final int RE     		= 11;
    public static final int REGINA    	= 10;
    public static final int JACK     	= 9;
    public static final int DIECI      	= 8;
    public static final int NOVE     	= 7;
    public static final int OTTO    	= 6;
    public static final int SETTE    	= 5;
    public static final int SEI      	= 4;
    public static final int CINQUE     	= 3;
    public static final int QUATTRO     = 2;
    public static final int TRE    		= 1;
    public static final int DUE    		= 0;
    
    // i semi.
    public static final int PICCHE   = 3;
    public static final int CUORI   = 2;
    public static final int FIORI    = 1;
    public static final int QUADRI = 0;
    
    /** simboli di rango */
    public static final String[] RANK_SYMBOLS = {
        "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"
    };
    
    /** simboli di semi */
    public static final char[] SUIT_SYMBOLS = { 'q', 'f', 'c', 'p' };
    
    /*ATTRIBUTI DI ISTANZA*/
    /** il rango */
    private final int rank;
    
    /** i semi */
    private final int suit;
    
    /**
		Costruttore 1 con numeri
     */
    public CarteP(int rank, int suit) {
        if (rank < 0 || rank > NO_OF_RANKS - 1) {
            throw new IllegalArgumentException("Rango invalido");
        }
        if (suit < 0 || suit > NO_OF_SUITS - 1) {
            throw new IllegalArgumentException("Seme invalido");
        }
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
		Costruttore 2
     */
    public CarteP(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Stringa nulla o di lunghezza non valida");
        }
        s = s.trim(); //ritorna stringa con spazi iniziali e finli rimossi
        if (s.length() != 2) {
            throw new IllegalArgumentException("Stringa vuota o lunghezza non valida\r\n");
        }
        
        // Analizzare il carattere del rango.
        String rankSymbol = s.substring(0, 1);
        char suitSymbol = s.charAt(1);
        int rank = -1;
        for (int i = 0; i < CarteP.NO_OF_RANKS; i++) {
            if (rankSymbol.equals(RANK_SYMBOLS[i])) {
                rank = i;
                break;
            }
        }
        if (rank == -1) {
            throw new IllegalArgumentException("Rango sconosciuto: " + rankSymbol);
        }
        // Analizzare il carattere del seme.
        int suit = -1;
        for (int i = 0; i < CarteP.NO_OF_SUITS; i++) {
            if (suitSymbol == SUIT_SYMBOLS[i]) {
                suit = i;
                break;
            }
        }
        if (suit == -1) {
            throw new IllegalArgumentException("Seme sconosciuto: " + suitSymbol);
        }
        this.rank = rank;
        this.suit = suit;
    }
    

    public int getSuit() {
        return suit;
    }
    

    public int getRank() {
        return rank;
    }
    

    @Override
    public int hashCode() {
        return (rank * NO_OF_SUITS + suit);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CarteP) {
            return ((CarteP) obj).hashCode() == hashCode();
        } else {
            return false;
        }
    }


    @Override
    public int compareTo(CarteP card) {
        int thisValue = hashCode();
        int otherValue = card.hashCode();
        if (thisValue < otherValue) {
            return -1;
        } else if (thisValue > otherValue) {
            return 1;
        } else {
            return 0;
        }
    }
    

    @Override
    public String toString() {
        return RANK_SYMBOLS[rank] + SUIT_SYMBOLS[suit];
    }
    
}