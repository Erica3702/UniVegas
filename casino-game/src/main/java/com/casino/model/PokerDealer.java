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

    @Override
    public int calcolaValoreMano() {
        throw new UnsupportedOperationException("Non applicabile per il Poker Dealer.");
    }

    public void distribuisciCarte(List<User> giocatori) {
        for (User giocatore : giocatori) {
            giocatore.aggiungiCarta(mazzo.pescaCarta());
            giocatore.aggiungiCarta(mazzo.pescaCarta());
        }
    }

    public void mostraFlop() {
        carteComuni.add(mazzo.pescaCarta());
        carteComuni.add(mazzo.pescaCarta());
        carteComuni.add(mazzo.pescaCarta());
    }

    public void mostraTurn() {
        carteComuni.add(mazzo.pescaCarta());
    }

    public void mostraRiver() {
        carteComuni.add(mazzo.pescaCarta());
    }

    public void aggiungiAlPiatto(int puntata) {
        piatto += puntata;
    }

    public void assegnaPiatto(User vincitore) {
        vincitore.aggiungiToken(piatto);
        piatto = 0;
    }
}

