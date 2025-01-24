package com.casino.model;

public class DealerBlackjack extends Dealer {

	@Override
	public int calcolaValoreMano() {
		int valore = 0;
		int assi = 0;
		for (Card carta: getMano()) {
			valore = valore+ carta.getValue();
			if(carta.getValue() == 11) {
				assi++;
			}
		}
		
		while (valore > 21 && assi >0) {
			valore = valore -10;
			assi --;
		}
		return valore;
	}

}
