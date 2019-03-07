package clases;

public class Carta {
	private Valor valor;
	private Palo palo;
	
	/**Constructor de la clase Carta
	 * 
	 * @param numero es el número de la carta
	 * @param palo es el nombre del palo
	 */
	public Carta(Valor numero, Palo palo) {
		this. valor = numero;
		this. palo = palo;
	}
	
	public double getValor(){
		return valor.getValor();
	}
	
	public String toString() {
		return "["+ valor +" de "+ palo +"]";
	}
}
