package main;

import java.util.Scanner;

import clases.Jugador;



public class Main {

	public static void main(String[] args) {
		
		Scanner S = new Scanner(System.in);
		
		System.out.println("Introduce el numero de jugadores, ten en cuenta que uno de ellos será la banca: ");
		Jugador[] jugadores = new Jugador[S.nextInt()];
		S.nextLine();
		for(int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador();
		}
		
	
	
	
		S.close();
	}
	
	
	public static boolean seguirJugando(Jugador[] jugadores) {
		int cont = 0;
		boolean seguirJugando = true;
		for(int i = 0; i < jugadores.length; i++) {
			if(jugadores[i].isJugando() == false) {
				cont++;
			}
		}
		if(cont == jugadores.length) {
			seguirJugando = false;
		}
		return seguirJugando;
		
	}

	public static Jugador jugadorMaxPuntos(Jugador[] jugadores) {
		double aux = 1000;
		int ganador = jugadores.length;
		
		for(int i = 0; i < jugadores.length; i++) {
			if(jugadores[i].getPuntos() < 7.5 && Math.abs(jugadores[i].getPuntos() - 7.5) < aux) {
				aux = jugadores[i].getPuntos();
				ganador = i;
			}
			else if(Math.abs(jugadores[i].getPuntos() - 7.5) == aux && ganador > i) {
				aux = jugadores[i].getPuntos();
				ganador = i; 
			}
		}
		
		return jugadores[ganador];
	}
	
}
