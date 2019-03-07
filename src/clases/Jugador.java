package clases;

import java.util.Arrays;

public class Jugador {
	private Carta[] mano;
	private int numeroJugador;
	private int primeraPosicionVacia;
	private double puntos;
	private boolean jugando;
	private static Baraja baraja = new Baraja();
	
	
	public Jugador() {
		this.mano = new Carta[14];
		this.numeroJugador = 0;
		this.jugando = true;
		this.primeraPosicionVacia = 0;
		this.puntos = 0;
	}

	public void robarCarta() {
		int aleat;
		
		aleat = (int) (Math.random() * 40);
		if(baraja.getBaraja()[aleat] == null) {
			robarCarta();
		}else {
			mano[primeraPosicionVacia] = baraja.getCarta(aleat);
			contarPuntos(baraja.getCarta(aleat).getValor());
			baraja.borrarCarta(aleat);
			primeraPosicionVacia++;
		}
	}

	public void contarPuntos(double puntos) {
		this.puntos += puntos;
		if(this.puntos > 7.5) {
			jugando = false;
		}
	}

	public void IA() {
		double aux, probabilidad, cartasRestantes = 0, cartasUtiles = 0;
		
		aux = 7.5 - this.puntos;
		
		if(aux != 0) {
			for(int i = 0; i < baraja.getBaraja().length; i++) {
				if(baraja.getBaraja()[i] != null) {
					cartasRestantes++;
					if(baraja.getBaraja()[i].getValor() <= aux) {
						cartasUtiles++;
					}
				}
			}	
		}
		probabilidad = cartasUtiles / cartasRestantes;
		
		if(probabilidad >= 0.5) {
			robarCarta();
		}
		else {
			plantarse("si");
		}
	}

	public double getPuntos() {
		return puntos;
	}
	
	public Carta[] getMano() {
		return mano;
	}
	
	public int getPrimeraPosicionVacia() {
		return primeraPosicionVacia;
	}
	
	public boolean isJugando() {
		return jugando;
	}

	public void plantarse(String jugando) {
		if(jugando.equals("si")) {
			this.jugando = false;
		}
	}

	public String mostrarMano() {
		String cadena = "";
		for(int i = 0; i < this.mano.length; i++) {
			if(mano[i] != null) {
				cadena = cadena + mano[i];
			}
		}
		return cadena;
	}
	
	public String toString() {
		return "Jugador "+ numeroJugador;
	}
	
	public static String mostrarBaraja() {
		return Arrays.toString(baraja.getBaraja());
	}
	
}
