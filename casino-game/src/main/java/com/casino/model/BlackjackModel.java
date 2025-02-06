package com.casino.model;

public class BlackjackModel {
    private Mazzo deck;
    private Dealer dealer;
    private User player;
    private boolean dealerHiddenCard;

    public BlackjackModel() {
        deck = new Mazzo();
        dealer = new Dealer();
        player = new User();
        dealerHiddenCard = true;
        startGame();
    }

    public void startGame() {
    	//resetta il mazzo e le mani
    	deck = new Mazzo();
        dealer = new Dealer();
        player = new User();
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

    public User getPlayer() {
        return player;
    }
}
