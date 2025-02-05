package com.casino.controller;

import javax.swing.JFrame;

import com.casino.model.Blackjack;
import com.casino.model.Card;
import com.casino.view.BlackjackView;
import com.casino.view.MenuGiochi;

public class BlackjackController {
    private Blackjack model;
    private BlackjackView view;

    public BlackjackController(Blackjack model, BlackjackView view) {
        this.model = model;
        this.view = view;

        view.setHitButtonListener(e -> hit());
        view.setStayButtonListener(e -> stay());
        view.setNextGameButtonListener(e -> nextGame());
        view.setExitToMenuButtonListener(e -> exitToMenu()); 
    }

    private void hit() {
        Card card = model.getDeck().drawCard();
        model.getPlayer().addCard(card);
        view.updateView();
        if (model.getPlayer().getSum() > 21) {
            view.disableHitButton();
        }
    }

    private void stay() {
        view.disableButtons();
        model.revealDealerCard(); // Rivela la prima carta del dealer

        // Il dealer pesca carte fino a raggiungere un punteggio di almeno 17
        while (model.getDealer().getSum() < 17) {
            Card card = model.getDeck().drawCard();
            model.getDealer().addCard(card);
        }

        view.updateView();
        view.showResult(determineResult());
        view.enableNextGameButton(); // Abilita il pulsante "Next Game"
    }
    
    private void nextGame() {
        // Resetta il modello per una nuova partita
        model = new Blackjack();
        view = new BlackjackView(model);
        new BlackjackController(model, view); // Ricrea il controller per la nuova partita
    }

    private void exitToMenu() {
        view.close();
        MenuGiochi.Start();
    }
    
    private String determineResult() {
        int playerSum = model.getPlayer().reduceAce();
        int dealerSum = model.getDealer().reduceAce();

        if (playerSum > 21) {
            return "Hai Perso!";
        } else if (dealerSum > 21) {
            return "Hai Vinto!";
        } else if (playerSum == dealerSum) {
            return "Pareggio!";
        } else if (playerSum > dealerSum) {
            return "Hai Vinto!";
        } else {
            return "Hai Perso!";
        }
    }
}

