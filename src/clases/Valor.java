package clases;

public enum Valor {
	
	UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), SOTA(0.5), CABALLO(0.5), REY(0.5);
	
	private double valor;
	
	/**
	 * Enumerado Valor, este enumero contiene el nombre de las cartas de la baraja y asociado a cada uno su valor en el juego.
	 */
	private Valor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
}
