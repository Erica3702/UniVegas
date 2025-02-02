package com.casino.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	 /** numero di carte nel deck */
    private static final int NO_OF_CARDS = CarteP.NO_OF_RANKS * CarteP.NO_OF_SUITS;
    
    /**le carte nel deck*/
    private CarteP[] cards;
    
    /*l'indice dellaprosima carta da pescare*/
    private int nextCardIndex = 0;
    
    /*Random num*/
    
    private Random random = new SecureRandom();
    
    /** Costruttore*/
    
    public Deck() {
        cards = new CarteP[NO_OF_CARDS];
        int index = 0;
        for (int suit = CarteP.NO_OF_SUITS - 1; suit >= 0; suit--) {
            for (int rank = CarteP.NO_OF_RANKS - 1; rank >= 0 ; rank--) {
                cards[index++] = new CarteP(rank, suit);
            }
        }
    }
    
    
    /**Mischia*/
    
    public void shuffle() {
        for (int oldIndex = 0; oldIndex < NO_OF_CARDS; oldIndex++) {
            int newIndex = random.nextInt(NO_OF_CARDS);
            CarteP tempCard = cards[oldIndex];
            cards[oldIndex] = cards[newIndex];
            cards[newIndex] = tempCard;
        }
        nextCardIndex = 0;
    }
    
    /**Resets  deck*/
    public void reset() {
        nextCardIndex = 0;
    }
    
    /**Pesca na carta*/
    public CarteP deal() {
        if (nextCardIndex + 1 >= NO_OF_CARDS) {
            throw new IllegalStateException("Non ci sono piu carte");
        }
        return cards[nextCardIndex++];
    }
    
    /**Pesca multiple carte */
    public List<CarteP> deal(int noOfCards) {
        if (noOfCards < 1) {
            throw new IllegalArgumentException("noOfCards < 1");
        }
        if (nextCardIndex + noOfCards >= NO_OF_CARDS) {
            throw new IllegalStateException("nessuna carta e rimasata nel deck");
        }
        List<CarteP> dealtCards = new ArrayList<CarteP>();
        for (int i = 0; i < noOfCards; i++) {
            dealtCards.add(cards[nextCardIndex++]);
        }
        return dealtCards;
    }
    
    /**	Pesca una carta speciale*/
    public CarteP deal(int rank, int suit) {
        if (nextCardIndex + 1 >= NO_OF_CARDS) {
            throw new IllegalStateException("Nessuna carta rimasta nel deck");
        }
        CarteP card = null;
        int index = -1;
        for (int i = nextCardIndex; i < NO_OF_CARDS; i++) {
            if ((cards[i].getRank() == rank) && (cards[i].getSuit() == suit)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            if (index != nextCardIndex) {
                CarteP nextCard = cards[nextCardIndex];
                cards[nextCardIndex] = cards[index];
                cards[index] = nextCard;
            }
            card = deal();
        }
        return card;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CarteP card : cards) {
            sb.append(card);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
    
}
