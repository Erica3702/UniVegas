package com.casino.controller;

import com.casino.model.BlackjackModel;
import com.casino.model.Card;
import com.casino.view.BlackjackView;
import com.casino.view.MenuGiochi;

public class BlackjackController {
    private BlackjackModel model;
    private BlackjackView view;

    public BlackjackController(BlackjackModel model, BlackjackView view) {
        this.model = model;
        this.view = view;

        view.setHitButtonListener(e -> hit());
        view.setStayButtonListener(e -> stay());
        view.setNextGameButtonListener(e -> nextGame());
        view.setExitToMenuButtonListener(e -> exitToMenu());
    }

    public void hit() {
        Card card = model.getDeck().drawCard();
        model.getPlayer().addCard(card);
        view.updateView();
        if (model.getPlayer().getSum() > 21) {
            view.disableHitButton();
        }
    }

    public void stay() {
        view.disableButtons();
        model.revealDealerCard(); // Rivela la prima carta del dealer
        if(model.getPlayer().getSum()<=21) {
        	// Il dealer pesca carte fino a raggiungere un punteggio di almeno 17
	        while (model.getDealer().getSum() < 17) {
	            Card card = model.getDeck().drawCard();
	            model.getDealer().addCard(card);
	        }
	        view.updateView();
	        view.showResult(determineResult());
	        view.enableNextGameButton(); // Abilita il pulsante "Next Game"
        }else {
             view.showResult(determineResult());
             view.enableNextGameButton(); // Abilita il pulsante "Next Game"	
        }
    }

    public void nextGame() {
        // Resetta il modello per una nuova partita
        model = new BlackjackModel();
        view = new BlackjackView(model);
        new BlackjackController(model, view); // Ricrea il controller per la nuova partita
    }

    private void exitToMenu() {
        view.close();
        MenuGiochi.Start();
    }

    public String determineResult() {
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