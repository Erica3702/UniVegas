package com.casino.model;

import com.casino.controller.BlackjackController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class TestBlackjack {
    private static final Logger logger = LogManager.getLogger(TestBlackjack.class);

    public static void main(String[] args) {
        BlackjackController controller = new BlackjackController("Giocatore1");

        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        logger.info("Benvenuto a Blackjack!");
        logger.info("Hai a disposizione 500 token.");

        while (continua) {
            // Chiedi la puntata
            logger.info("Inserisci la tua puntata: ");
            int puntata = scanner.nextInt();

            // Inizia un nuovo round
            try {
                controller.iniziaNuovoRound(puntata);
                logger.info("Nuova partita iniziata. La tua mano:");
                controller.getGiocatore().getMano().forEach(carta -> logger.info(carta));
                logger.info("La carta visibile del dealer: " + controller.getDealer().getMano().get(0));
            } catch (IllegalArgumentException ex) {
                logger.error(ex.getMessage());
                continue;
            }

            // Loop per il turno del giocatore
            boolean turnoGiocatore = true;
            while (turnoGiocatore) {
                logger.info("Vuoi [H]it (prendi una carta) o [S]tand (resta)? ");
                String scelta = scanner.next().toUpperCase();

                if (scelta.equals("H")) {
                    String risultato = controller.hit();
                    logger.info(risultato);
                    logger.info("La tua mano:");
                    controller.getGiocatore().getMano().forEach(carta -> logger.info(carta));

                    if (risultato.contains("Hai perso!")) {
                        turnoGiocatore = false;
                    }
                } else if (scelta.equals("S")) {
                    turnoGiocatore = false;
                } else {
                    logger.warn("Scelta non valida.");
                }
            }

            // Turno del dealer e risultato finale
            String risultatoFinale = controller.stand();
            logger.info(risultatoFinale);
            logger.info("La mano del dealer:");
            controller.getDealer().getMano().forEach(carta -> logger.info(carta));
            logger.info("Token rimanenti: " + controller.getGiocatore().getTokens());

            // Chiedi se il giocatore vuole continuare
            logger.info("Vuoi giocare un'altra partita? [S/N]: ");
            String risposta = scanner.next().toUpperCase();
            if (risposta.equals("N")) {
                continua = false;
                logger.info("Grazie per aver giocato! I tuoi token finali: " + controller.getGiocatore().getTokens());
            }
        }

        scanner.close();
    }
}
