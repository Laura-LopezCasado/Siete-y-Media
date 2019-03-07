package clases;

import java.util.Arrays;

public class Jugador {
	private Carta[] mano;
	private int numeroJugador;
	private int primeraPosicionVacia;
	private double puntos;
	private boolean jugando;
	private static int siguienteNumJugador = 0;
	private static int ronda = 1;
	private static Baraja baraja = new Baraja();
	
	/**
	 * Constructor de la clase Jugador.
	 */
	public Jugador() {
		this.mano = new Carta[14];
		this.numeroJugador = siguienteNumJugador;
		this.jugando = true;
		this.primeraPosicionVacia = 0;
		this.puntos = 0;
		siguienteNumJugador++;
	}
	
	/**
	 * Este método genera un número aleatorio entre 0 y 39 y comprueba
	 * que esa posición de la baraja no está vacía, si lo está se ejecuta la recursividad,
	 * si no lo está se introduce la carta extraida de la baraja en la primera posición
	 * vacía de la mano del jugador.
	 * 
	 * @param mano Es un array de Cartas que representa la mano del jugador.
	 * @param baraja Es el array de Cartas que representa la baraja.
	 * @param primeraPosicionVacia Es un int que indica la primera posición vacía en la mano del jugador.
	 * 
	 */
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
	
	/**
	 * Este método cuenta los puntos y si el jugador se pasa de
	 * 7.5 le saca del juego.
	 * 
	 * @param puntos Son los puntos del jugador.
	 * @param jugando Es un booleano que indica si el jugador está o no jugando la partida.
	 */
	public void contarPuntos(double puntos) {
		this.puntos += puntos;
		if(this.puntos > 7.5) {
			jugando = false;
		}
	}
	
	/**
	 * Este método es la Inteligencia artificial de la banca, se le llama desde el main cuando el numero de jugador es 0.
	 * Calcula la probabilidad de conseguir una carta que le sirva para llegar a siete y medio sin pasarse y llamará al metodo 
	 * robarCarta si esta es mayor o igual al 50%, en caso contrario se planta.
	 * De haber querido calcular la posibilidad respecto al jugador con más puntos, se hubiese pasado dicho parámetro
	 * y el aux hubiese sido la resta de los puntos del jugador menos los puntos de la banca
	 * 
	 * @param puntos son los puntos de la banca.
	 * @param 
	 * @param baraja Es el array de Cartas que representa la baraja.
	 */
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
	
	public static int getRonda() {
		return ronda;
	}
	
	public static void siguienteRonda() {
		ronda++;
	}

	/**
	 * Este método construye un string con las cartas de la mano del jugador.
	 * @return cadena Devuelve este String con las cartas en la mano del jugador.
	 */
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
