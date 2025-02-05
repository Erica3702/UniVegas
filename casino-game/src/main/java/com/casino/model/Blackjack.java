package com.casino.model;

public class Blackjack {
    private Mazzo deck;
    private Dealer dealer;
    private UserBlackjack player;
    private boolean dealerHiddenCard;

    public Blackjack() {
        deck = new Mazzo();
        dealer = new DealerBlackjack();
        player = new UserBlackjack();
        dealerHiddenCard = true;
        startGame();
    }

    public void startGame() {
    	//resetta il mazzo e le mani
    	deck = new Mazzo();
        dealer = new DealerBlackjack();
        player = new UserBlackjack();
        dealerHiddenCard = true;
        
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
    }
    
    public void revealDealerCard() {
        dealerHiddenCard = false; // Mostra la prima carta del dealer
    }

    public boolean isDealerCardHidden() {
        return dealerHiddenCard;
    }

    public Mazzo getDeck() {
        return deck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public UserBlackjack getPlayer() {
        return player;
    }
}
