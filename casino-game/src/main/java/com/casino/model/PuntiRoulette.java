package com.casino.model;


public class PuntiRoulette{
	
	//associa il colore al numero (sia per il nuero puntato che per quello estratto)
	private static int calcolaColore(int numero) {
		int coloreEstratto=2; //rosso 0, nero 1, verde 2
		int rossi[]= {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
		int neri[]= {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
		for(int i=0;i<rossi.length;i++) {
			if(rossi[i]==numero) {
				coloreEstratto=0;
			}
		}
		for(int i=0;i<neri.length;i++) {
			if(neri[i]==numero) {
				coloreEstratto=1;
			}
		}
		return coloreEstratto;
	}
	
	
	private static int calcolaParità(int numero) {
		int parità=2;  //pari 0, dispari 1, zero 2
		if(numero==0) {
			parità = 2;
		}else {
			if(numero%2==0) {
			parità = 0;
			}else {
			parità = 1;
			}
		}
		return parità;
	}
	
	
	
	//calcolo vincita
	
	// punti sul numero esatto
    public static int calculatePointsForExactNumber(int numeroPuntato, int numeroEstratto) {
        if (numeroPuntato == numeroEstratto) {
            return 36; // 36 è il moltiplicatore
        }
        return 0;
    }

    // punti colore
    public static int calculatePointsForColor(int numeroPuntato, int numeroEstratto) {
        if (PuntiRoulette.calcolaColore(numeroPuntato)==PuntiRoulette.calcolaColore(numeroEstratto)) {
            return 2; 
        }
        return 0;
    }

    // punti pari/dispari
    public static int calculatePointsForParity(int betParità, int paritaEstratta) {
    	if (PuntiRoulette.calcolaParità(betParità)==PuntiRoulette.calcolaParità(paritaEstratta)) {
            return 2; // Payout per pari/dispari è 1 a 1
        }
        return 0;
    }

    // punti dozzine
    public static int calculatePointsForDozen(int betDozen, int numeroEstratto) {
        int dozzinaEstratta = (numeroEstratto - 1) / 12 + 1; // Calcola la dozzina del numero estratto
        if (numeroEstratto == 0) return 0; // 0 non appartiene a nessuna dozzina
        if (betDozen == dozzinaEstratta) {
            return 3; 
        }
        return 0;
    }

    // punti colonne
    public static int calculatePointsForColumn(int betColumn, int numeroEstratto) {
        if (numeroEstratto == 0) return 0; // 0 non appartiene a nessuna colonna
        int colonnaEstratta = (numeroEstratto - 1) % 3 + 1; // Calcola la colonna del numero estratto
        if (betColumn == colonnaEstratta) {
            return 3;
        }
        return 0;
    }

    // punti totali
    public static int calculateTotalPoints(int betNumber, int numeroEstratto, int betColor, int coloreEstratto,
                                           int betType, int paritaEstratta, int betDozen, int betColumn) {
        int points = 0;

        points += calculatePointsForExactNumber(betNumber, numeroEstratto);
        points += calculatePointsForColor(betNumber, numeroEstratto);
        points += calculatePointsForParity(betType, paritaEstratta);
        points += calculatePointsForDozen(betDozen, numeroEstratto);
        points += calculatePointsForColumn(betColumn, numeroEstratto);

        return points;
    }
  
}
 
