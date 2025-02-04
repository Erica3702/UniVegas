package com.casino.model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokerDealer extends Dealer {
    private Mazzo mazzo;
    private List<Card> carteComuni;
    private int piatto;
    private int turnoCorrente;

    public PokerDealer(Mazzo mazzo) {
        this.mazzo = mazzo;
        this.carteComuni = new ArrayList<>();
        this.piatto = 0;
        this.turnoCorrente = 0;
    }

 

    public void distribuisciCarte(List<User> giocatori) {
        for (User giocatore : giocatori) {
            giocatore.addCard(mazzo.drawCard());
            giocatore.addCard(mazzo.drawCard());
        }
    }

    public void mostraFlop() {
        carteComuni.add(mazzo.drawCard());
        carteComuni.add(mazzo.drawCard());
        carteComuni.add(mazzo.drawCard());
    }

    public void mostraTurn() {
        carteComuni.add(mazzo.drawCard());
    }

    public void mostraRiver() {
        carteComuni.add(mazzo.drawCard());
    }

    public void aggiungiAlPiatto(int puntata) {
        piatto += puntata;
    }

    public void assegnaPiatto(User vincitore) {
       
        piatto = 0;
    }
    public Card pescaCarta() {
        return mazzo.drawCard(); // Chiede al mazzo di rimuovere e restituire la carta in cima
    }

    // Metodo per accedere al mazzo
    public Mazzo getMazzo() {
        return mazzo; // Restituisce il riferimento al mazzo
    }
}

