package clases;

import java.util.Arrays;

public class Baraja {
	private Carta[] baraja;

	public Baraja() {
		int i, j, k = 0;
		
		baraja = new Carta[40];
		
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 10; j++) {
				baraja[k] = new Carta(Valor.values()[j], Palo.values()[i]);
				k++;
			}
		}
	}
	
	public Carta[] getBaraja() {
		return baraja;
	}
	
	public Carta getCarta(int pos) {
		return baraja[pos];
	}
	
	public void borrarCarta(int pos) {
		baraja[pos] = null;
	}

	@Override
	public String toString() {
		return "Baraja [baraja=" + Arrays.toString(baraja) + "]";
	}
}
